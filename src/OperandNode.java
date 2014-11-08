/**
 * Class that defines an operand node. Has the member value, which represents
 * the numerical value(type double) of the node.
 * 
 * @author Diana
 *
 */
public class OperandNode extends BinaryTreeNode {
	private double value;
	
	public OperandNode(String info) {
		super();
		this.value = Double.parseDouble(info);
	}
	
	/**
	 * Getter for value.
	 * @return - the value of the node.
	 */
	public double getValue() {
		return value;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
