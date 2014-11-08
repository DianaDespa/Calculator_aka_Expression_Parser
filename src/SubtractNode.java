/**
 * Class that defines a subtraction node.
 * 
 * @author Diana
 *
 */
public class SubtractNode extends BinaryTreeNode{
	public SubtractNode() {
		this.setInfo("-");
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
