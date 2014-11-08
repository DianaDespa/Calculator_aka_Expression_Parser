/**
 * Class that defines a cosine node.
 * 
 * @author Diana
 *
 */
public class CosNode extends BinaryTreeNode {
	public CosNode() {
		this.setInfo("cos");
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
