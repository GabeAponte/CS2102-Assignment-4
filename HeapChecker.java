/**
 * A class that holds the properties 
 * and methods for the HeapChecker object
 * This class hold the addEltTester method
 * and the remMinEltTester method
 * 
 * @author Gabe Aponte
 */
import java.util.LinkedList;

public class HeapChecker {
	
	/**
	 * This is the addEltTester method which consumes a heap, an integer, 
	 * and a binary tree and returns true if the binary tree is a valid 
	 * result of adding the given integer to the first Heap.
	 * 
	 * @param hOrig  original heap inputed for comparison
	 * @param elt  int representing ultimate to be added
	 * @param hAdded  binary tree inputed for comparison when adding
	 * @return true or false  a boolean value indicating if the result is a valid after adding an element
	 */
	public boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
		return (hOrig.isHeap() && hAdded.sameElementsAdd(hOrig, elt) && (hOrig.size() == (hAdded.size() - 1)) 
				&& (hAdded.hasElt(elt)));
	}

	/**
	 * This is the remMinEltTester that consumes a heap and a binary tree 
	 * and returns true if the binary tree is a valid result of removing 
	 * the minimum integer of the first Heap.
	 * 
	 * @param hOrig  original heap inputed for comparison
	 * @param hRemoved  binary tree inputed for comparison when removing
	 * @return true or false  a boolean value indicating if the result is a valid after removing the min element
	 */
	public boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
		if (hRemoved.size() != 0) {
			
			return (hOrig.isHeap() && hRemoved.sameElementsRemoved(hOrig) && 
					(hOrig.size() == (hRemoved.size() + 1)) );
		} else {
			
			return (hOrig.isHeap() && hRemoved.sameElementsRemoved(hOrig) && 
					(hOrig.size() == hRemoved.size()) );
		}
	}
}
///How to check valid answer
//1. Is it a heap?
//2. Does the result contain all the elements from the original heap (the same number of occurrences)?
//3. The new element has been added
//4. No element in the result that weren't in the original
