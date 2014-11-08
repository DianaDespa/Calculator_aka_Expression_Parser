/**
 * NodeFactory class implements the Factory Pattern for nodes.
 * 
 * @author Diana
 *
 */
public class NodeFactory {
	/**
	 * Based on the String given as input, the method returns a new operator
	 * node of certain kind.
	 * @param info - mathematical symbols or notations which the creation of
	 * the new node is based on. 
	 * @return - a new node of a certain kind.
	 * @throws SyntacticException - in case of an unknown operator
	 */
	public static BinaryTreeNode newNode(String info) throws SyntacticException {
		switch (info) {
		case "+": return new SumNode();
		case "-": return new SubtractNode();
		case "*": return new MultiplyNode();
		case "/": return new DivideNode();
		case "^": return new PowerNode();
		case "log": return new LogNode();
		case "sqrt": return new SqrtNode();
		case "sin": return new SinNode();
		case "cos": return new CosNode();
		case "(": case ")": return new BinaryTreeNode(info);
		}
		//Invalid operator
		throw new SyntacticException(SyntacticException.INV_OP);
	}
}
