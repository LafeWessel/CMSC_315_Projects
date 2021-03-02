package Project_09_Addtl_Files;
public interface PureQueue< E >   // Note: does not extend Collection<E>
{

	/**
	 *  Determines the number of elements in this PureQueue object.
	 *
	 *  @return the number of elements in this PureQueue object.
	 *
	 */
	int size();


	/**
	 *  Determines if this PureQueue object has no elements.
	 *
	 *  @return true - if this PureQueue object has no elements; otherwise,
	 *                          return false.
	 *
	 */
	boolean isEmpty();
		
		 
	/**
	 *  Inserts a specified element at the back of this PureQueue object.
	 *  The averageTime(n) is constant and worstTime(n) is O(n).
	 *  
	 *  @param element - the element to be appended.
	 *
	 */
        void enqueue (E element);


	/**
	 *  Removes the front element from this PureQueue object.
	 *  
	 *  @return - the element removed.
	 *  
	 *  @throws NoSuchElementException - if this PureQueue object is empty.
	 *
	 */ 
	E dequeue();


	/**
	 *  Returns the front element in this PureQueue object.
	 *  
	 *  @return - the element returned.
	 *  
	 *  @throws NoSuchElementException - if this PureQueue object is empty.
	 *
	 */		
	E front();

} // interface PureQueue
