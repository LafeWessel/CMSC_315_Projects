package Project_09_Addtl_Files;
import java.util.*;

public class LinkedListPureQueue<E> implements PureQueue<E>
{
    	protected LinkedList<E> list;


	/**
	 *  Initializes this LinkedListPureQueue object to be empty.
	 *
	 */
	public LinkedListPureQueue() 
	{
        	list = new LinkedList<E>();
    	} // default constructor


	/**
	 *  Initializes this LinkedListPureQueue object to a shallow copy of a specified
	 *  LinkedListPureQueue object.  The worstTime(n) is O(n), where n is the 
	 *  number of elements in the specified LinkedListPureQueue object.
	 *
	 *  @param otherQueue - the specified LinkedListPureQueue object that this
	 *             LinkedListPureQueue object is initialized to a shallow copy of.
	 *
	 */
	public LinkedListPureQueue (LinkedListPureQueue<E> otherQueue) 
	{
        	list = new LinkedList<E> (otherQueue.list);
    	} // copy constructor
    
		
    	/**
	 *  Determines the number of elements in this LinkedListPureQueue object.
	 *
	 *  @return the number of elements in this LinkedListPureQueue object.
	 *
	 */
    	public int size() 
	{
        	return list.size();
	} // method size

	/**
	 *  Determines if this LinkedListPureQueue object has no elements.
	 *
	 *  @return true - if this LinkedListPureQueue object has no elements; 
	 *                          otherwise, return false.
	 *
	 */
	public boolean isEmpty() 
	{
       	 	return list.isEmpty();
    	} // method isEmpty


	/**
	 *  Inserts a specified element at the back of this Linked otherwise,PureQueue		 
	 *  object.  The averageTime(n) is constant and worstTime(n) is O(n).
	 *  
	 *  @param element - the element to be appended.
	 *
	 */
	public void enqueue (E element) 
	{
 		list.addLast (element);
	} // method enqueue


	/**
	 *  Removes the front element from this LinkedListPureQueue object.
	 *  
	 *  @return - the element removed.
	 *  
	 *  @throws NoSuchElementException - if this LinkedListPureQueue object is		 
	 *                 empty.
	  *
	 */ 
	public E dequeue() 
	{
        	return list.removeFirst();
	} // method dequeue

	
	/**
	 *  Returns the front element from this LinkedPureQueue object.
	 *  
	 *  @return - the element returned.
	 *  
	 *  @throws NoSuchElementException - if this LinkedListPureQueue object is		 
 	 *                 empty.
	 *
	 */				
	public E front() 
	{
        	return list.getFirst( );
	} // method front

} // LinkedListPureQueue class
