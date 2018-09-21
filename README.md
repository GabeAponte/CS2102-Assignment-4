# CS2102-Assignment-4
Problem Statement
Our discussion of data structures has introduced a couple of methods that could return one of several answers: remElt() on BSTs has this property, as do the addElt() and remMinElt() functions on heaps.
Writing test cases for such methods clearly requires more than writing a specific, concrete answer (as you are used to doing). Instead of writing a concrete answer, you have to write a method that checks whether your answer meets the requirements of a correct answer, and run that method within your test case. In other words, rather than checking whether you got the correct answer, you have to check whether you got a correct answer. This assignment is teaching you how to write tests for situations when you need "a correct answer".

Your job here is to write two methods, the first of which is addEltTester(). addEltTester() takes a heap, an integer, and a binary tree (in that order), and returns true if the binary tree is a valid result of adding the given integer to the first Heap. In other words, you want to fill in

  boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {

    ...code to compare hOrig and hAdded around the addition of elt as appropriate...

  }
You can use this to test a given addElt() implementation by writing a test such as
  @Test
  public void test1(){
 
    assertTrue(addEltTester(myHeap,5,myHeap.addElt(5)));

  }
Or, you can provide the binary tree "manually", as in
  @Test
  public void test2(){
  
    assertTrue(addEltTester(myHeap,5,myBinTree));

  }
where myHeap and myBinTree are data that you defined. Note that every heap is also a binary tree, so you can use addElt() to generate binary trees from heaps.
Also provide remMinEltTester, which is similar (but tests remMinElt). For this, fill in

  boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {

    ...code to compare hOrig and hRemoved as appropriate...

  }
What should addEltTester() and remMinEltTester() actually do?
Each of these methods checks whether the binary tree is a valid result of performing addElt() or remMinElt() (respectively) on the original heap. A valid result is defined by the following conditions:
The binary tree returned must satisfy the definition of a heap (smallest element on top, left and right subtrees both heaps).
addElt() must retain all elements that were in the original heap, while adding only the new element one time.
remMinElt() must retain all elements that were in the original heap, other than removing one occurrence of the smallest element.
You may assume that running addElt() or remMinElt() on a heap does not modify the heap (this lets you reuse the same heap data in multiple test cases).
For this assignment, heaps may have duplicate elements.

Logistics
Put both of these methods in a new class called HeapChecker.
You do not need to implement addElt() or remMinElt(). We are giving them to you, along with the other heap operations. Here are both a binary tree implementation and an initial correct heap implementation to use in writing your tester. You are getting both files because we build heaps as subclasses of binary trees.

If you need additional methods on Heaps or BinTrees, modify the classes in these files as needed with your additional methods. Do not change the names of the classes, any of the existing methods, or make your own subclasses (that will break the auto-tester). Just edit these classes and/or interfaces by adding your own additional methods.

DO NOT call addElt() in addEltTester() or remMinElt() in remMinEltTester()!!! Doing so undermines the purpose of this assignment.

Testing the Testers
Put your test cases in an Examples class, as usual. Your test cases need only to use addEltTester() and remMinEltTester(). They may use addElt()/remMinElt() if you wish (as shown in test1 above). Limit yourself to no more than six (6) tests for each of the methods. Your job is to check as well as you can within 6 tests whether or not each method functions the way it should.
Note that since your method is in the HeapChecker class, your Examples class will need a HeapChecker object. This means your test cases will look like the following:

  class Examples {

    Examples(){}

    HeapChecker HT = new HeapChecker();

    ...

    @Test
    public void test3(){
        assertTrue(HT.addEltTester(myHeap, 5, myBinTree));
    }   
  }
where myHeap and myBinTree are data defined in your Examples class.
