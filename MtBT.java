/**
 * A class that holds the properties 
 * and methods for the MtBT object
 * This is meant for Binary trees that
 * are empty
 * 
 * @author Gabe Aponte
 */
import java.util.LinkedList;

class MtBT implements IBinTree {
	MtBT(){}

	/**
	 * This is the hasElt method which takes in an element and determines 
	 * whether this node or node in subtree has that element
	 * 
	 * @param e  integer representing the element you want to find
	 * @return false  a boolean value the element is not in the tree since it is empty
	 */
	public boolean hasElt(int e) {
		return false;
	}

	/**
	 * This is the size method which produces the size of the empty binary tree
	 * 
	 * @return 0  the value 0 representing that there are no elements in an empty tree
	 */
	public int size() {
		return 0;
	}

	/**
	 * This is the height method which produces the height of an empty binary tree
	 * 
	 * @return 0  the value representing there is no height to an empty tree
	 */
	public int height() {
		return 0;
	}

	/**
	 * This is the getTreeList method that produces a list of elements in an
	 * empty binary tree
	 * 
	 * @return originalList  an empty local linked list of integers representing that the empty tree has no elements
	 */
	public LinkedList<Integer> getTreeList(){
		LinkedList<Integer> originalList = new LinkedList<Integer>();
		return originalList;
	}

	/**
	 * This is the sameElementsAdd method which consumes a binary tree and an element and 
	 * will produce true if the elements from the binary tree are conserved after adding
	 *  
	 * @param original  a binary tree used to check the elements 
	 * @param elt  an int representing the element you wish to check
	 * @return true or false  a boolean value representing if the binary tree is conserved or not after adding
	 */
	public boolean sameElementsAdd(IBinTree original, int elt) {
		LinkedList<Integer> modifiedList = new LinkedList<Integer>();
		modifiedList.add(elt);

		return modifiedList.equals(this.getTreeList());
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
		LinkedList<Integer> btList = this.getTreeList();

		return modifiedList.equals(btList);
	}
}
