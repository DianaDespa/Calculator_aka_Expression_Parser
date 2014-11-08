/**
 * Class that defines an exponential node.
 * 
 * @author Diana
 *
 */
public class PowerNode extends BinaryTreeNode {
	public PowerNode() {
		this.setInfo("^");
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
