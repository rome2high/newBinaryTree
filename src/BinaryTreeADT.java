public interface BinaryTreeADT {
	//finish the rest of this code unit.
	public BTNode root();
	public boolean isEmpty();
	public int size();
	public boolean isRoot(BTNode v);
	public boolean hasParent(BTNode v);
	public BTNode parent(BTNode v);
	public boolean isLeaf(BTNode v);
	public boolean hasLeft(BTNode v);
	public BTNode left(BTNode v);
	public boolean hasRight(BTNode v);
	public BTNode right(BTNode v);
	public void addNode(int value);
}