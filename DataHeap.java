/**
 * A class that holds the properties 
 * and methods for the DataHeap object
 * This is meant for Heaps that
 * will have data
 * 
 * @author Gabe Aponte
 */
import java.util.Random;

class DataHeap extends DataBT implements IHeap {
	IHeap left;
	IHeap right;

	DataHeap(int data, IHeap left, IHeap right) {
		super (data, left, right);
		this.left = left;
		this.right = right;
	}

	// an alternate constructor for when both subheaps are empty
	DataHeap(int data) {
		super(data);
		this.left = new MtHeap();
		this.right = new MtHeap();
	}

	/**
	 * This is the merge method which takes in a heap to be merged. The method
	 * compares the two heaps being merged to determine which trees to merge 
	 * in order to create a new tree. It returns a new DataHeap object that 
	 * has been created through the merge
	 * 
	 * @param withHeap  an IHeap object that will be used in merging 
	 * @return DataHeap  a new dataHeap object representing the merged heap
	 */
	public IHeap merge(IHeap withHeap) {
		int newRoot;
		IHeap H1, H2, H3;

		// determine the new root value and the three subtrees to consider merging
		if (withHeap.isBigger(this.data)) {
			newRoot = this.data;
			H1 = (IHeap) this.left;
			H2 = (IHeap) this.right;
			H3 = withHeap;
		} else {
			// Since a MtHeap will always return true on isBigger, satisfying
			//  the first condition, we know that withHeap is a DataHeap.
			//  Therefore, we can cast it.
			newRoot = ((DataHeap) withHeap).data;
			H1 = ((DataHeap) withHeap).left;
			H2 = ((DataHeap) withHeap).right;
			H3 = this;
		}

		// choose which trees to merge and construct the new tree
		if (H1.height() > H2.height() && H1.height() > H3.height()) {
			return new DataHeap (newRoot, H1, H2.merge (H3));
		} else if (H2.height() > H1.height() && H2.height() > H3.height()) {
			return new DataHeap (newRoot, H2, H1.merge (H3));
		} else if (H3.height() > H1.height() && H3.height() > H2.height()){
			return new DataHeap (newRoot, H3, H1.merge (H2));
		} else {
			// If the two bigger heaps are of the same size, choose one at random.
			Random coinFlip = new Random();
			if (H1.height() == H2.height()) {
				if (coinFlip.nextInt() % 2 == 1) {
					return new DataHeap (newRoot, H1, H2.merge(H3));
				} else {
					return new DataHeap (newRoot, H2, H1.merge(H3));
				}
			} else if (H2.height() == H3.height()) {
				if (coinFlip.nextInt() % 2 == 1) {
					return new DataHeap (newRoot, H2, H3.merge(H1));
				} else {
					return new DataHeap (newRoot, H3, H2.merge(H1));
				}
			} else {
				if (coinFlip.nextInt() %2 == 1) {
					return new DataHeap (newRoot, H3, H1.merge(H2));
				} else {
					return new DataHeap (newRoot, H1, H3.merge(H2));
				}
			}
		}
	}

	/**
	 * This is the addElt method which takes in an element and calls the merge
	 * method in order to add the heap with the element to another heap
	 * 
	 * @param e  an integer representing the element to be added
	 * @return IHeap  a new heap that has the element added in
	 */
	@Override
	public IHeap addElt(int e) {
		return this.merge(new DataHeap(e, new MtHeap(), new MtHeap()));
	}

	/**
	 * This is the remMinElt method which calls the merge
	 * method in order to remove the min element from the heap
	 * 
	 * @return IHeap  a new heap that has the min element removed
	 */
	@Override
	public IHeap remMinElt() {
		return this.right.merge(this.left);
	}
	
	/**
	 * This is the isBigger method which takes in an element and compares it to the 
	 * data field of a heap object and checks if it's bigger or not
	 * 
	 * @return true or false  a boolean value indicating if the given element is bigger or not
	 */
	@Override
	public boolean isBigger(int e) {
		return (this.data >= e);
	}

	/**
	 * This is the isHeap method which makes sure each subtree is a heap 
	 * and produces true if the whole thing is a heap 
	 * 
	 * @return true or false  a boolean value indicating if it is a heap or not
	 */
	public boolean isHeap(){
		if (this.left.isHeap() && this.right.isHeap()
				&& this.right.isBigger(this.data) && this.left.isBigger(this.data) ) {

			return true;
			
		} else {

			return false;
		}
	}
}