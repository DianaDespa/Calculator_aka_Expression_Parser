/**
 * Class that defines a summation node.
 * 
 * @author Diana
 *
 */
public class SumNode extends BinaryTreeNode{
	public SumNode() {
		this.setInfo("+");
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
