/**
 * Class that defines a square root node.
 * 
 * @author Diana
 *
 */
public class SqrtNode extends BinaryTreeNode {
	public SqrtNode() {
		this.setInfo("sqrt");
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
