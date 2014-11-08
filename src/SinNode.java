/**
 * Class that defines a sine node.
 * 
 * @author Diana
 *
 */
public class SinNode extends BinaryTreeNode {
	public SinNode() {
		this.setInfo("sin");
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
