/**
 * Interface for Visitor Pattern. Has visit methods for all node types.
 * 
 * @author Diana
 *
 */
public interface Visitor {
	/**
	 * Visits an operand node and computes its value.
	 * @param node - an operand node, a numeric value.
	 */
	public void visit(OperandNode node);
	
	/**
	 * Visits a summation node by adding the values of its subtrees.
	 * @param node - a summation node.
	 */
	public void visit(SumNode node);
	
	/**
	 * Visits a subtraction node by subtracting from the value of the left
	 * subtree the value of the right subtree , if the latter exists, or by
	 * computing the opposite of the value of the left subtree. 
	 * @param node - a subtraction node.
	 */
	public void visit(SubtractNode node);
	
	/**
	 * Visits a multiplication node by multiplying the value of the left subtree
	 * by the value of the right subtree.
	 * @param node - a multiplication node.
	 */
	public void visit(MultiplyNode node);
	
	/**
	 * Visits a division node by dividing the value of the left subtree by the
	 * value of the right subtree. Throws ZERO_DIV exception if the latter value
	 * is zero.
	 * @param node - a division node.
	 */
	public void visit(DivideNode node);
	
	/**
	 * Visits an exponential node by raising the value of the left subtree to
	 * the power of the value of the right subtree.
	 * @param node - an exponential node.
	 */
	public void visit(PowerNode node);
	
	/**
	 * Visits a logarithm node by computing the logarithm to base 10 of the
	 * value of the left subtree.
	 * @param node - a logarithm node.
	 */
	public void visit(LogNode node);
	
	/**
	 * Visits a square root node by computing the square root of the value of
	 * the left subtree. Throws ZERO_LOG exception if the value is zero, or
	 * NEG_LOG exception if it is negative.
	 * @param node - a square root node.
	 */
	public void visit(SqrtNode node);
	
	/**
	 * Visits a sine node by computing the sine of the value of the left
	 * subtree. Throws NEG_SQRT exception if the value is negative.
	 * @param node - a sine node.
	 */
	public void visit(SinNode node);
	
	/**
	 * Visits a cosine node by computing the cosine of the value of the left
	 * subtree.
	 * @param node - a cosine node.
	 */
	public void visit(CosNode node);
}