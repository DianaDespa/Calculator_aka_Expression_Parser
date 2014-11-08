import java.util.Stack;
import java.util.StringTokenizer;

/**
 * ExpressionParser class handles the parsing and evaluation of mathematical
 * expressions, using a result stack and an operator stack to build a parse tree.
 * 
 * @author Diana
 *
 */
public class ExpressionParser {

	private Stack<BinaryTreeNode> resultStack = new Stack<>();
	private Stack<BinaryTreeNode> operatorStack = new Stack<>();
	private int numBrackets = 0;
	
	/**
	 * Checks if the parameter can be converted into a number.
	 * @param str - the string to be checked.
	 * @return - true or false, depending on the conversion being possible or
	 * not.
	 */
	private boolean isNumber(String str) {
		try {
			Double.parseDouble(str);
		}
		catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Gets the priority level of an operator.
	 * @param str - a string containing an operator.
	 * @return - the priority level of the operator.
	 */
	private int getPriority(String str) {
		switch (str) {
		case "(": case ")":
			return 0;
		case "+": case "-":
			return 1;
		case "*": case "/":
			return 2;
		case "^":
			return 3;
		}
		return 4;
	}
	
	/**
	 * Checks if an operator is binary or unary.
	 * @param node - a string containing an operator
	 * @return - true or false, depending on the operator being binary or not.
	 */
	private boolean isBinary(BinaryTreeNode node) {
		String str = node.getInfo();
		switch (str) {
		case "+": case "*": case "/": case "^":
			return true;
		case "(": case ")": case "log": case "sqrt": case "sin": case "cos":
			return false;
		case "-":
			/**
			 * The operator "-"(minus) is considered to be unary if it's the
			 * first node added to the parse tree/the first character in the
			 * expression or if it comes right after an open bracket in the
			 * operator stack.
			 */
			if (node.getIndex() == 0) {
				return false;
			}
			if (!operatorStack.isEmpty()) {
				if (operatorStack.peek().getInfo().equals("(")) {
					if (operatorStack.peek().getIndex() + 1 == node.getIndex()) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Builds a subtree based on a certain operation, using nodes from the
	 * result stack. The subtree is then placed in the result stack.
	 * @param operationNode - the reference operation. 
	 */
	private void buildSubTree(BinaryTreeNode operationNode) {
		BinaryTreeNode leftNode, rightNode;
		
		rightNode = resultStack.pop();
		if (isBinary(operationNode)) {
			leftNode = resultStack.pop();
			operationNode.setLeftNode(leftNode);
			operationNode.setRightNode(rightNode);
		} else {
			operationNode.setLeftNode(rightNode);
		}
		resultStack.push(operationNode);
	}
	
	/**
	 * Evaluates an operator which will be inserted in the operator stack.
	 * @param node - the node build at a certain step in the parsing of the
	 * expression. 
	 * @param currentStr - the current token from the expression.
	 */
	private void evalOperator(BinaryTreeNode node, String currentStr) {
		BinaryTreeNode operation;
		
		if (operatorStack.isEmpty() || currentStr.equals("(")) {
			operatorStack.push(node);
		} else {
			if (currentStr.equals(")")) {
				operation = operatorStack.pop();
				if (!operation.getInfo().equals("(")) {
					buildSubTree(operation);
					evalOperator(node, currentStr);
				}
			} else if ((currentStr.equals("^") && 
					operatorStack.peek().getInfo().equals("^")) || 
					getPriority(currentStr) > 
					getPriority(operatorStack.peek().getInfo())) {
				operatorStack.push(node);
			} else {
				operation = operatorStack.pop();
				buildSubTree(operation);
				evalOperator(node, currentStr);
			}
		}
	}
	
	/**
	 * Evaluates an expression by building a binary parse tree and using a
	 * visitor to compute the value of the root. Also, finds the syntactic
	 * mistakes in the expression.
	 * @param expression - the expression to be evaluated.
	 * @return - the result of the expression.
	 * @throws SyntacticException
	 * @throws EvaluatorException
	 */
	public float eval(String expression) throws SyntacticException, EvaluatorException{
		StringTokenizer st = new StringTokenizer(expression);
		int index = 0;
		BinaryTreeNode node;
		//Booleans which are used to check for syntactic mistakes.
		boolean wasOperand = false, wasOperator = false, wasBinaryOp = false;
		
		while (st.hasMoreTokens()) {
			String currentStr = st.nextToken();
			if (isNumber(currentStr)) {
				node = new OperandNode(currentStr);
				node.setIndex(index++);
				resultStack.push(node);
				if (wasOperand) {
					//Consecutive operands
					throw new SyntacticException(SyntacticException.CONS_OPD);
				}
				wasOperand = true;
				wasOperator = false;
				wasBinaryOp = false;
			} else {
				node = NodeFactory.newNode(currentStr);
				node.setIndex(index++);
				if (isBinary(node)) {
					if (wasBinaryOp) {
						//Consecutive binary operators
						throw new SyntacticException(SyntacticException.CONS_BIN);
					} 
					if (wasOperator) {
						//Binary operator after unary operator
						throw new SyntacticException(SyntacticException.AFT_BIN);
					}
					wasBinaryOp = true;
				} else {
					wasBinaryOp = false;
				}
				if (!currentStr.equals("(") && !currentStr.equals(")")) { 
					wasOperand = false;
					wasOperator = true;
				} else {
					if (currentStr.equals("(")) {
						numBrackets++;
					} else {
						numBrackets--;
					}
				}

				evalOperator(node, currentStr);
			}
		}
		
		if (numBrackets != 0) {
			//Invalid number of brackets
			throw new SyntacticException(SyntacticException.NUM_BRACK);
		}
		
		//Empty the operator stack and complete the parse tree.
		while (!operatorStack.isEmpty()) {
			node = operatorStack.pop();
			buildSubTree(node);
		}
		
		//Compute the value in the root using a visitor.
		Visitor v = new TreeEvalVisitor();
		resultStack.pop().accept(v);
		return (float) ((TreeEvalVisitor)v).getRootVal();
	}
}