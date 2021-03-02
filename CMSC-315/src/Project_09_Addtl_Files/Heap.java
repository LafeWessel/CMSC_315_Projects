package Project_09_Addtl_Files;
import java.util.*;

public class Heap<E> implements PurePriorityQueue<E>
{
	protected static final int DEFAULT_INITIAL_CAPACITY = 11;

	protected ArrayList<E> list;

	protected Comparator<E> comparator;

            
	/**
 	 *  Initializes this Heap object to be empty, with a given initial capacity, and elements
 	 *  ordered by the given Comparator object.
 	 *
 	 *  @param initialCapacity - the initial capacity of this Heap object.
 	 *  @param comp - the Comparator object.
 	 *
 	 */
	public Heap (int initialCapacity, Comparator<E> comp) 
        {
		list = new ArrayList<E> (initialCapacity);
		comparator = comp;
	} // constructor with initial capacity


        /** 
 	 *  Initializes this Heap object to be empty, with a default initial capacity and with
 	 *  elements in a class that implements the Comparable interface.
 	 *
         */                                 
	public Heap() 
    	{
		this (DEFAULT_INITIAL_CAPACITY, null);
    	} // default constructor


	/**
 	 *  Initializes this Heap object to be empty, with a given initial capacity and with
 	 *  elements in a class that implements the Comparable interface.
 	 *
 	 *  @param initialCapacity - the initial capacity of this Heap object.
 	 *
 	 */
	public Heap (int initialCapacity)
	{
		this (initialCapacity, null);
	} // constructor with initial capacity


        /** 
 	 *  Initializes this Heap object to be empty, with a default initial capacity and
 	 *  with elements compared according to the Comparator object comp.
 	 *
 	 *  @param comp - the Comparator object used for comparing elements in
	 *                 this Heap object.
	 *
 	 */
    	public Heap (Comparator<E> comp) 
	{
      	 	this (DEFAULT_INITIAL_CAPACITY, comp);
      	} // constructor with Comparator parameter


     	/**  
 	 *  Initializes this Heap object to a shallow copy of a specified Heap object.
 	 *  The elements in this Heap object will be compared as in the specified
	 *  Heap object.
 	 *  The worstTime(n) is O(n), where n is the number of elements in 
 	 *  the specified Heap object.
 	 *
 	 *  @param otherHeap - the specified Heap object to be copied to 
 	 *                 this Heap object.   
 	 *
 	 */
    	public Heap (Heap<E> otherHeap)
    	{
     		list = new ArrayList<E> (otherHeap.list);
     		comparator = otherHeap.comparator;
    	} // copy constructor


	/** 
	 *  Returns the number of elements in this PurePriorityQueue object.
 	 *
	 *  @return the number of elements in this PurePriorityQueue object.
 	 *
	 */           
	public int size()
	{
		return list.size();
	} // method size


	/** 
	 *  Determines if this PurePriorityQueue object has no elements.
	 *
	 *  @return true - if this PurePriorityQueue object has no elements;
	 *                otherwise, return false;
	 *
	 */
	public boolean isEmpty()
	{
		return list.isEmpty();
	} // method isEmpty


	/**
	 *  Inserts a specified element into this Heap object.
	 *  The worstTime(n) is O(n) and averageTime(n) is constant.
	 *
	 *  @param element - the element to be inserted into this PurePriorityQueue
	 *                 object.
	 *
	 */ 
	public void add (E element)
	{
        	list.add (element);
        	percolateUp();
	} // method add


	/**
	 *  Restores the heap properties to this Heap object, which was a heap, except,
	 *  possibly, at index size() - 1.
	 *  The worstTime(n) is O(log n), and averageTime(n) is constant.
	 *
	 */
    	protected void percolateUp()
    	{
        	int child = list.size() - 1,
                    parent;

       		while (child > 0)
        	{
            		parent = (child - 1) >> 1;  // >>1 is slightly faster than / 2
            		if (compare (list.get (child), list.get (parent)) >= 0)
            			break;
            		swap (parent, child);
            		child = parent;
        	} // while
    	} // method percolateUp


	/** 
 	 *  Compares two specified elements according to Comparable or a Comparator
 	 *  object.
 	 *
 	 *  @param element1 - one of the specified elements.
 	 *  @param element2 - the other specified element.
 	 *
 	 *  @return a negative integer, 0, or a positive integer, depending on whether
	 *  element1 is less than, equal to or greater than element2.
	 *
	 */
	@SuppressWarnings("unchecked")
	protected int compare (E element1, E element2) 
	{
		return (comparator == null ? ((Comparable<E>)element1).compareTo(element2)
				           : comparator.compare (element1, element2));
	} // method compare


	/** 
    	 *  Swaps a specifed parent and child in this Heap object.
 	 *
	 *  @param parent - the position of the parent element.
	 *  @param child - the position of the child element.
	 *
	 */	
    	protected void swap (int parent, int child)
    	{
        	E temp = list.get (parent);
        	list.set (parent, list.get (child));
       		list.set (child, temp);
    	} // method swap


      	/** 
 	 *  Returns the smallest-valued element in this Heap object.
 	 *  
 	 *  @return the smallest-valued element in this Heap object.
 	 *
 	 *  @throws NoSuchElementException - if this Heap object is empty.
 	 *
       	 */              
	public E getMin()
    	{
	      	return list.get (0);
    	} // method getMin


       	/** 
    	 *  Removes the smallest-valued element from this Heap object.
  	 *  The worstTime(n) is O(log n).
  	 * 
  	 *  @return the element removed.
  	 *
  	 *  @throws NoSuchElementException - if this Heap object is empty.
  	 *
         */                   	
    	public E removeMin()
    	{
       		E minElem = list.get (0);
       		list.set (0, list.get (list.size() - 1));
       		list.remove (list.size() - 1);
       		percolateDown (0);
       		return minElem;
    	} // method removeMin


	/** 
	 *  Restores the heap properties to this Heap object, which is a heap except,
	 *  possibly, at a specified position.
	 *  The worstTime(n) is O(log n).
	 *
	 *  @param start - the specified position where the restoration of the heap 
	 *                 will begin.
       	 *
	 */                     	
    	protected void percolateDown (int start)
    	{
       		int parent = start,
         	    child = (parent << 1) + 1;  // parent << 1 is slightly faster than parent * 2

        	while (child < list.size())
        	{
            		if (child < list.size() -1 &&
                 		compare (list.get (child), list.get (child+1)) > 0)
            		child++; // child indexes smallest child
            		if (compare (list.get (child), list.get (parent)) >= 0)
            			break;
            		swap (parent, child);
            		parent = child;
            		child = (parent << 1) + 1;
        	} // while
    	} // method percolateDown

} // class Heap


