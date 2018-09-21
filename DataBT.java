/**
 * A class that holds the properties 
 * and methods for the DataBT object
 * This is meant for Binary trees that
 * will have data
 * 
 * @author Gabe Aponte
 */
import java.util.LinkedList;

class DataBT implements IBinTree{
	int data;
	IBinTree left;
	IBinTree right;

	DataBT(int data, IBinTree left, IBinTree right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// an alternate constructor for when both subtrees are empty
	DataBT(int data) {
		this.data = data;
		this.left = new MtBT();
		this.right = new MtBT();
	}

	/**
	 * This is the hasElt method which takes in an element and determines 
	 * whether this node or node in subtree has that element
	 * 
	 * @param e  integer representing the element you want to find
	 * @return true or false  a boolean value indicating if the element is in the tree
	 */
	public boolean hasElt(int e) {
		return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
	}

	/**
	 * This is the size method which adds 1 to the number of nodes in the 
	 * left and right subtrees to produce the size of the tree
	 * 
	 * @return int  an integer value representing the size of the tree
	 */
	public int size() {
		return 1 + this.left.size() + this.right.size();
	}

	/**
	 * This is the height method which adds 1 to the height of the taller subtree
	 * to produce the height of the tree
	 * 
	 * @return int  an integer value representing the height of the tree
	 */
	public int height() {
		return 1 + Math.max(this.left.height(), this.right.height());
	}

	/**
	 * This is the getTreeList method that adds elements to a list and 
	 * returns that linked list of every element in the tree
	 * 
	 * @return BSTList  a local linked list of integers representing the elements in the tree
	 */
	public LinkedList<Integer> getTreeList(){
		LinkedList<Integer> originalList = (this.right.getTreeList());

		originalList.addAll(this.left.getTreeList());
		originalList.add(data);

		return originalList;
	}

	/**
	 * This is the sameElementsAdd method which consumes a binary tree and an element and 
	 * will produce true if the elements from the binary tree are conserved
	 *  
	 * @param original  a binary tree used to check the elements 
	 * @param elt  an int representing the element you wish to check
	 * @return true or false  a boolean value representing if the binary tree is conserved or not after adding
	 */
	public boolean sameElementsAdd(IBinTree original, int elt) {
		LinkedList<Integer> modifiedList = original.getTreeList();
		modifiedList.add(elt);
		modifiedList.sort(null);

		LinkedList<Integer> btList = this.getTreeList();
		btList.sort(null);

		return modifiedList.equals(btList);
	}

	/**
	 * This is the sameElementsRemoved method which take in a binary tree and will return true if
	 * if the elements from the original BT are conserved after the removal
	 * 
	 * @param original  a binary tree used to check the elements 
	 * @return true or false  a boolean value representing if the binary tree is conserved or not after removing 
	 */ 
	public boolean sameElementsRemoved(IBinTree original) {
		LinkedList<Integer> modifiedList = original.getTreeList();

		int smallest = 999999999;
		for (Integer i : modifiedList) {
			if (i < smallest) {
				smallest = i;
			}
		}

		modifiedList.removeFirstOccurrence(smallest);
		modifiedList.sort(null);

		LinkedList<Integer> BTList = this.getTreeList();
		BTList.sort(null);

		return modifiedList.equals(BTList);
	}
}
