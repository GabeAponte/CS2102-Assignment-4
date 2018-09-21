/**
 * A class that holds the properties 
 * and methods for the DataHeap object
 * This is meant for Heaps that
 * will be empty
 * 
 * @author Gabe Aponte
 */
class MtHeap extends MtBT implements IHeap {
	MtHeap(){}
	
	/**
	 * This is the addElt method which takes in an element and calls the merge
	 * method in order to add the heap with the element to another heap
	 * 
	 * @param e  an integer representing the element to be added
	 * @return IHeap  a new heap that has the element added in (the only element)
	 */
	@Override
	public IHeap addElt(int e) {
		return new DataHeap(e, new MtHeap(), new MtHeap());
	}

	/**
	 * This is the remMinElt method which produces an empty heap since there
	 * are no elements to remove in an empty heap
	 * 
	 * @return IHeap  a new empty heap 
	 */
	@Override
	public IHeap remMinElt() {
		return new MtHeap();
	}
	
	/**
	 * This is the isBigger method which takes in an element and produces true since
	 * there are no elements in the empty heap
	 * 
	 * @return true a boolean value indicating the given element is bigger
	 */
	@Override
	public boolean isBigger(int e) {
		return true;
	}
	
	/**
	 * This is the merge method which takes in a heap to be merged. The method
	 * produces that heap since merging something with nothing is that something.
	 * (identity)
	 * 	 
	 * @param withHeap  an IHeap object that will be used in merging 
	 * @return withHeap  the IHeap object that was inputed 
	 */
	@Override
	public IHeap merge(IHeap withHeap) {
		return withHeap;
	}

	/**
	 * This is the isHeap method which produces true for an empty heap
	 * 
	 * @return true  a boolean value indicating it is a heap
	 */
	@Override
	public boolean isHeap(){
		return true;
	}
	
	/**
	 * This is the hasElt method which takes in an element and determines 
	 * whether this node or node in subtree has that element
	 * 
	 * @param e  integer representing the element you want to find
	 * @return false  a boolean value the element is not in the heap since it is empty
	 */
	
	@Override
	public boolean hasElt(int e) {
		return false;
	}

	/**
	 * This is the size method which produces the size of the empty heap
	 * 
	 * @return 0  the value 0 representing that there are no elements in an empty heap
	 */
	@Override
	public int size() {
		return 0;
	}

	/**
	 * This is the height method which produces the height of an empty heap
	 * 
	 * @return 0  the value representing there is no height to an empty heap
	 */
	@Override
	public int height() {
		return 0;
	}
}