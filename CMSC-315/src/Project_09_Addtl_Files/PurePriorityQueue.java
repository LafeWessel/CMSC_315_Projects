package Project_09_Addtl_Files;
public interface PurePriorityQueue<E> // Note: does not extend Collection<E>
{
	/** 
	 *  Returns the number of elements in this PurePriorityQueue object.
 	 *
	 *  @return the number of elements in this PurePriorityQueue object.
 	 *
	 */           
	int size();


	/** 
	 *  Determines if this PurePriorityQueue object has no elements.
	 *
	 *  @return true - if this PurePriorityQueue object has no elements;
	 *                otherwise, return false;
	 *
	 */
	boolean isEmpty();


	/**
	 *  Inserts a specified element into this PurePriorityQueue object.
	 *  The worstTime(n) is O(n).
	 *
	 *  @param element - the element to be inserted into this PurePriorityQueue
	 *                 object.
	 *
	 */ 
    	void add (E element);


	/** 
  	 *  Returns the highest-priority element in this PurePriorityQueue object.
  	 *  The worstTime(n) is O(log n).
  	 *  
  	 *  @return the highest-priority element in this PurePriorityQueue object.
  	 *
  	 *  @throws NoSuchElementException - if this PurePriorityQueue object is empty.
  	 *
  	 */    	 
	E getMin();


	/** 
  	 *  Removes the highest-priority element from this PurePriorityQueue object.
  	 *  The worstTime(n) is O(log n).
  	 *  
  	 *  @return the element removed.
  	 *
  	 *  @throws NoSuchElementException - if this PurePriorityQueue object is empty.
  	 *
  	 */                         	 
    	E removeMin();

} // interface PurePriorityQueue
