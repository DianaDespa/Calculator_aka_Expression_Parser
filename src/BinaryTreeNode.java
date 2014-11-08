/**
 * BinaryTreeNode class represents a node in the parse tree. It is the base for
 * all the types of nodes in the tree: operator nodes and operand nodes. It
 * implements the Visitable interface, assuring that all the classes that
 * extend are also visitable. The class has a member info, which contains the
 * information in the node: either a symbol for operators, or a number for
 * operands, a member index, which is the index of the nodes in the order in
 * which they were added in the tree, and members leftNode and rightNode, which
 * are references to left and right subtrees respectively, in the parse tree.
 * 
 * @author Diana
 *
 */
public class BinaryTreeNode implements Visitable{
	
	private String info;
	private int index;
	private BinaryTreeNode leftNode, rightNode;
	
	/**
	 * Constructor with no parameters.
	 */
	public BinaryTreeNode() {
		this.leftNode = null;
		this.rightNode = null;
	} 
	
	/**
	 * Constructor with String parameter.
	 * @param info - the information to be set for the node.
	 */
	public BinaryTreeNode(String info) {
		this();
		this.info = info;
	}
	
	/**
	 * Getter for index.
	 * @return - index of the current node.
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Setter for index.
	 * @param index - the index to be set for the node.
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * Getter for the information in the node.
	 * @return - information in the node.
	 */
	public String getInfo(){
		return info;
	}
	
	/**
	 * Setter for the information in the node.
	 * @param info - information to be set for the node.
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	
	/**
	 * Getter for the left subtree.
	 * @return - a reference to the root of left subtree.
	 */
	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}
	
	/**
	 * Getter for the right subtree.
	 * @return - a reference to the root of right subtree.
	 */
	public BinaryTreeNode getRightNode() {
		return rightNode;
	}
	
	/**
	 * Setter for the left subtree.
	 * @param leftNode - root of the subtree to be set as the left subtree.
	 */
	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}
	
	/**
	 * Setter for the right subtree.
	 * @param rightNode - root of the subtree to be set as the right subtree. 
	 */
	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}

	@Override
	public void accept(Visitor v) {
		;
	}
}