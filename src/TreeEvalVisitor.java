/**
 * Class TreeEvalVisitor is an implementation of the Visitor interface. It
 * defines the visit method for all node types, using the rootVal member to
 * keep track of the result of the subtree which is currently being visited.
 *  
 * @author Diana
 *
 */
public class TreeEvalVisitor implements Visitor{

	/**
	 * The leftVal and rightVal variables that are declared in every method
	 * are not declared as class members because their value changes every time
	 * the accept method is called from inside the visitor, which is not the
	 * wanted behavior. By making them local for methods, their values are
	 * kept properly in the stack until the recursive calls are finished, and
	 * then the rootVal is computed with the correct values for the current
	 * position in the parse tree.
	 */
	
	double rootVal;

	/**
	 * Returns the computed value of the subtree which is being visited.
	 * @return - the value of rootVal.
	 */
	public double getRootVal() {
		return rootVal;
	}
	
	@Override
	public void visit(OperandNode node) {
		rootVal = node.getValue();
	}

	@Override
	public void visit(SumNode node) {
		node.getLeftNode().accept(this);
		double leftVal = rootVal;
		node.getRightNode().accept(this);
		double rightVal = rootVal;
		rootVal = leftVal + rightVal;
	}

	@Override
	public void visit(SubtractNode node) {
		node.getLeftNode().accept(this);
		double leftVal = rootVal;
		if (node.getRightNode() != null) {
			node.getRightNode().accept(this);
			double rightVal = rootVal;
			rootVal = leftVal - rightVal;
		} else {
			rootVal = - leftVal;
		}
	}

	@Override
	public void visit(MultiplyNode node) {
		node.getLeftNode().accept(this);
		double leftVal = rootVal;
		node.getRightNode().accept(this);
		double rightVal = rootVal;
		rootVal = leftVal * rightVal;
	}

	@Override
	public void visit(DivideNode node) {
		node.getLeftNode().accept(this);
		double leftVal = rootVal;
		node.getRightNode().accept(this);
		double rightVal = rootVal;
		if (rightVal == 0) {
			throw new EvaluatorException(EvaluatorException.ZERO_DIV);
		}
		rootVal = leftVal / rightVal;
	}

	@Override
	public void visit(PowerNode node) {
		node.getLeftNode().accept(this);
		double leftVal = rootVal;
		node.getRightNode().accept(this);
		double rightVal = rootVal;
		rootVal = Math.pow(leftVal, rightVal);
	}

	@Override
	public void visit(LogNode node){
		node.getLeftNode().accept(this);
		double leftVal = rootVal;
		if (leftVal == 0) {
			throw new EvaluatorException(EvaluatorException.ZERO_LOG);
		} else if (leftVal < 0) {
			throw new EvaluatorException(EvaluatorException.NEG_LOG);
		}
		rootVal = Math.log10(leftVal);
	}

	@Override
	public void visit(SqrtNode node) {
		node.getLeftNode().accept(this);
		double leftVal = rootVal;
		if (leftVal < 0) {
			throw new EvaluatorException(EvaluatorException.NEG_SQRT);
		}
		rootVal = Math.sqrt(leftVal);
	}

	@Override
	public void visit(SinNode node) {
		node.getLeftNode().accept(this);
		double leftVal = rootVal;
		rootVal = Math.sin(leftVal);
	}

	@Override
	public void visit(CosNode node) {
		node.getLeftNode().accept(this);
		double leftVal = rootVal;
		rootVal = Math.cos(leftVal);
	}
}