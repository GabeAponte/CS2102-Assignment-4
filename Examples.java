/**
 * this the the Examples class that
 * holds all the test cases for the program
 * 
 * @author Gabe Aponte
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {

	public Examples(){}

	HeapChecker HT = new HeapChecker();

	//empty tree
	IHeap MtHeap = new MtHeap();

	//heaps with empty subtrees
	IHeap Heap5 = new DataHeap(5, MtHeap, MtHeap);
	IHeap Heap7 = new DataHeap(7, MtHeap, MtHeap);
	IHeap Heap8 = new DataHeap(8, MtHeap, MtHeap);
	IHeap Heap9 = new DataHeap(9, MtHeap, MtHeap);
	IHeap Heap30 = new DataHeap(30, MtHeap, MtHeap);
	IHeap Heap27 = new DataHeap(27, MtHeap, MtHeap);

	//heaps trees with subtree
	IHeap Heap3 = new DataHeap(3, Heap7, Heap8);
	IHeap Heap4 = new DataHeap(4, Heap9, Heap5);
	IHeap Heap1 = new DataHeap(1, Heap3, Heap4);
	IHeap Heap10 = new DataHeap(3, Heap7, Heap8);
	IHeap Heap11 = new DataHeap(4, Heap9, Heap5);
	IHeap Heap12 = new DataHeap(1, Heap10, Heap11);
	IHeap negHeap12 = new DataHeap(-1, Heap10, Heap11);
	IHeap H10 = new DataHeap(10, Heap9, Heap27);

	//heap tree with a subtree having the same value as the parent root
	IHeap duplicate = new DataHeap (1, Heap12, Heap30);

	//Improperly constructed heaps
	IHeap badHeap1 = new DataHeap(20, Heap9, Heap30);
	IHeap badHeap2 = new DataHeap(20, Heap9, Heap27);

	//test add element that belongs at the end of the tree
	@Test
	public void addEltTest() {
		assertTrue(HT.addEltTester(Heap12, 30, Heap12.addElt(30)));
	}

	//tests adding a duplicate element
	@Test
	public void addEltTest2(){
		assertTrue(HT.addEltTester(Heap1, 9, Heap1.addElt(9)));
	}

	//tests for an improperly constructed heap
	@Test
	public void addEltTest3() {
		assertFalse(HT.addEltTester(badHeap1, 8, badHeap1.addElt(8)));
	}

	//tests for a case where no element was added to the binary tree
	@Test
	public void addEltTest4() {
		assertFalse(HT.addEltTester(Heap12, 8, Heap12));
	}

	//tests adding the same number to a heap 
	@Test
	public void addEltTest5() {
		assertFalse(HT.addEltTester(badHeap2, 8, badHeap2.addElt(8)));
	}

	//tests adding two of the same number to a heap
	@Test
	public void addEltTest6() {
		assertFalse(HT.addEltTester(Heap9, 10, Heap9));
	}

	//tests to see if the smallest element from the tree is removed
	@Test
	public void remMinEltTest() {
		assertTrue(HT.remMinEltTester(Heap12, Heap12.remMinElt()));
	}

	//testing for removing from a heap with duplicate values
	@Test
	public void remMinEltTest2() {
		assertTrue(HT.remMinEltTester(duplicate, duplicate.remMinElt()));
	}

	//testing for removing from a heap that contains a negative value
	@Test
	public void remMinEltTest3() {
		assertTrue(HT.remMinEltTester(negHeap12, negHeap12.remMinElt()));
	}

	//tests a false case where no element from the binary tree was removed
	@Test
	public void remMinEltTest4() {
		assertFalse(HT.remMinEltTester(Heap12, Heap12));
	}   

	//test for removing from an improperly constructed heap
	@Test
	public void remMinEltTest5() {
		assertFalse(HT.remMinEltTester(badHeap1, badHeap1.remMinElt()));
	}

	//tests removing element from an empty heap
	@Test
	public void remMinEltTest6() {
		assertFalse(HT.remMinEltTester(badHeap2, badHeap2.remMinElt()));
	}

	//testing to see if an empty tree is still counted as a heap tree
	@Test
	public void isHeapTest() {
		assertTrue(MtHeap.isHeap());
	}

	//testing to see if this binary tree is not counted as a heap tree
	@Test
	public void isHeapTest2() {
		assertFalse(badHeap1.isHeap());
	}

	//testing to see if this binary tree is counted as a heap tree
	@Test
	public void isHeapTest3() {
		assertTrue(Heap12.isHeap());
	}

	//tests result that isn't a heap
	@Test
	public void isHeapTest4() {
		assertFalse(H10.isHeap());
	}

	//testing to see if this method works properly
	@Test
	public void sameElmentsAddTest() {
		assertTrue(Heap12.addElt(12).sameElementsAdd(Heap12, 12));
	}

	//testing to see if this method works properly
	@Test
	public void sameElementsRemovedTest() {
		assertTrue(Heap12.remMinElt().sameElementsRemoved(Heap12));
	}
}