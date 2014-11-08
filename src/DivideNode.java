/**
 * Class that defines a division node.
 * 
 * @author Diana
 *
 */
public class DivideNode extends BinaryTreeNode {
	public DivideNode() {
		this.setInfo("/");
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
