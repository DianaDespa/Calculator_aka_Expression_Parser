/**
 * Class that defines a multiplication node.
 * 
 * @author Diana
 *
 */
public class MultiplyNode extends BinaryTreeNode {
	public MultiplyNode() {
		this.setInfo("*");
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
