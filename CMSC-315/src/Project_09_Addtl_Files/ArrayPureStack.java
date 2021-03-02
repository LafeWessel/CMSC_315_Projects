package Project_09_Addtl_Files;

public class ArrayPureStack<E> implements PureStack<E>
{
    	protected E[ ] data;
  
  	protected int top;  // also equals the size of the stack
  
  	/**
	 *  Initializes this ArrayPureStack object to be empty, with an initial
	 *  capacity of 10.
   	 *   
   	 */
  	public ArrayPureStack()
  	{
  	    	final int DEFAULT_INITIAL_CAPACITY = 10;     
 
      		data = (E[ ])new Object [DEFAULT_INITIAL_CAPACITY];
      		top = 0;
  	 } // default constructor

      
  	/**
   	 *  Initializes this ArrayPureStack object to contain a shallow copy of
   	 *  another ArrayPureStack object.
   	 *  The worstTime(n) is O(n), where n is the size of the other ArrayPureStack
   	 *  object.  
   	 *
   	 *  @param otherStack - the ArrayPureStack object to be copied to
   	 *                 this ArrayPureStack object.
   	 *
   	 */
	 public ArrayPureStack (ArrayPureStack<E> otherStack)
  	 {
     		final int CAPACITY = (int)(otherStack.top * 1.10);// allows room for growth
      
      		data = (E[ ])new Object [CAPACITY];
      		top = otherStack.top;
      		System.arraycopy (otherStack.data, 0, data, 0, otherStack.top); 
  	 } // copy constructor
  
  
  	/**
   	 *  Determines the number of elements in this ArrayPureStack object.
   	 *
   	 *  @return the number of elements in this ArrayPureStack object.
   	 *
   	 */
  	public int size() 
  	{ 
		return top; 
  	} // method size
 

 	/**
  	 *  Determines if this ArrayPureStack object has no elements.
  	 *
  	 *  @return true - if this ArrayPureStack object has no elements.
   	 *                     
  	 */
  	public boolean isEmpty() 
  	{ 
		return top == 0; 
  	} // method isEmpty
  
   
 	/**
  	 *  Inserts a specified element on the top of this ArrayPureStack object.
  	 *  The averageTime(n) is constant and worstTime(n) is O(n).
  	 *  
  	 *  @param element - the element to be pushed.
  	 *
  	 */
  	public void push (E element) 
  	{ 
      		if (top == data.length - 1)
      		{
          		E[ ] newData = (E[ ]) new Object [data.length * 2];
          		System.arraycopy (data, 0, newData, 0, top);
          		data = newData;
      		} // if
      		data [top++] = element;  
  	} // method push
 

 	/**
  	 *  Removes the top element from this ArrayPureStack object.
  	 *  
  	 *  @return - the element removed.    
  	 *  @throws NoSuchElementException - if this ArrayPureStack 
  	 *                 object is empty. 
  	 */ 
  	public E pop() 
  	{ 
		return data [--top]; 
  	} // method pop


 	/**
  	 *  Returns the top element on this ArrayPureStack object.
  	 *  
  	 *  @return - the element returned.
  	 *  @throws NoSuchElementException - if this ArrayPureStack object 
  	 *                 is empty.  
  	 *
 	 */  
	public E peek() 
	{ 
		return data [top-1]; 
	} // method peek

 } // class ArrayPureStack
