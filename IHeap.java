/**
 * this IHeap interface which holds the method headers that
 * will be shared to classes that implement it
 * 
 * @author Gabe Aponte
 *
 */
interface IHeap extends IBinTree {
	// adds given element to the heap without removing other elements
	IHeap addElt(int e);

	// removes one occurrence of the smallest element from the heap
	IHeap remMinElt();

	// Merge the current heap with another heap
	IHeap merge(IHeap withHeap);

	// Determine if the root of this heap is bigger than the given element
	boolean isBigger(int e);

	// Determines if it is a heap or not
	boolean isHeap();
}
