/**
 * Class that defines a base 10 logarithm node.
 * 
 * @author Diana
 *
 */
public class LogNode extends BinaryTreeNode{
	public LogNode() {
		this.setInfo("log");
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
