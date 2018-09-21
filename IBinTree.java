/**
 * This is the IBinTree interface that holds the method headers that
 * will be shared to classes that implement it
 * 
 * @author Gabe Aponte
 */
import java.lang.Math;
import java.util.LinkedList;
interface IBinTree {
	// determines whether element is in the tree
	boolean hasElt(int e);

	// returns number of nodes in the tree; counts duplicate elements as separate items
	int size();

	// returns depth of longest branch in the tree
	int height();

	//returns a linked list of all the elements in the tree
	LinkedList<Integer> getTreeList();
	
	// determines if the input elements are conserved in the current tree
	public boolean sameElementsAdd(IBinTree original, int elt);

	// determines if the input elements are conserved in the current tree
	public boolean sameElementsRemoved(IBinTree original);
}

