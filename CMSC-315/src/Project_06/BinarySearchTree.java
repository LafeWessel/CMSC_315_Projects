//package Project_06;
//import java.util.*;
//
//public class BinarySearchTree<E> extends AbstractSet<E> 
//{
    //protected Entry<E> root;

//    protected int size;        
    

//    public BinarySearchTree() 
//    {
//        root = null;
//        size = 0;  
//    } // default constructor



//    public BinarySearchTree (BinarySearchTree<? extends E> otherTree)
//    {
//         root = copy (otherTree.root, null);
//         size = otherTree.size;  
//    } // copy constructor
        

//    protected Entry<E> copy (Entry<? extends E> p, Entry<E> parent)
//    {
//        if (p != null)
//        {
//            Entry<E> q = new Entry<E> (p.element, parent);
//            q.left = copy (p.left, q);
//            q.right = copy (p.right, q);
//            return q;
//        } // if
//        return null;
//    } // method copy
        
//    public boolean equals (Object obj)
//    {
//        if (!(obj instanceof BinarySearchTree))
//            return false;
//        return equals (root, ((BinarySearchTree<? extends E>)obj).root);
//    } // method 1-parameter equals
//    
//    public boolean equals (Entry<E> p, Entry<? extends E> q)
//    {
//       if (p == null || q == null)
//           return p == q;      
//       if (!p.element.equals (q.element))
//           return false;
//       if (equals (p.left, q.left) && equals (p.right, q.right) )
//           return true;            
//       return false;     
//    } // method 2-parameter equals
    

//    public int size( )
//    {
//        return size;
//    } // method size()
  
    
//    public void print() {
//
//    if (root == null)
//
//         System.out.println("--Empty tree--");
//
//   
//
//     root.print(false, " ");
//
//    }
//    

//    public Iterator<E> iterator()
//    {
//         return new TreeIterator();
//    } // method iterator


//    public boolean contains (Object obj) 
//    {
//        return getEntry (obj) != null;
//    } // method contains

 

//    public boolean add (E element)  
//    {
//    	//If there are no elements in the BST
//        if (root == null) 
//        {
//            if (element == null)
//                throw new NullPointerException();
//            root = new Entry<E> (element, null);
//            size++;
//            return true;
//        } // empty tree
//        else 
//        {
//            Entry<E> temp = root;
//
//            int comp;
//
//            while (true) 
//            {
//                comp =  ((Comparable)element).compareTo (temp.element);
//                if (comp == 0)
//                    return false;
//                if (comp < 0)
//                    if (temp.left != null)
//                        temp = temp.left;
//                    else 
//                    {
//                        temp.left = new Entry<E> (element, temp);
//                        size++; 
//                        //Climb tree and recalculate sizes and heights
//                        climbAndRecalc(temp.left);
//                        return true;
//                    } // temp.left == null
//                    else if (temp.right != null)
//                        temp = temp.right;
//                    else 
//                    {
//                        temp.right = new Entry<E> (element, temp);
//                        size++;
//                        climbAndRecalc(temp.right);
//                        return true;
//                    } 
//                // temp.right == null
//            } // while
//        } // root not null
//    } // method add
    
    
    //Climb tree from a given point and recalculate heights and sizes
//    private void climbAndRecalc(Entry<E> newEntry) {
//    	Entry<E> temp = newEntry.parent;
//    	
//    	int r = 0;
//    	int l = 0;
//    	
//    	while(temp != null) {
//    		
//    		//calc height
//    		l = (temp.left != null ? temp.left.height : -1);
//    		r = (temp.right != null ? temp.right.height : -1);
//    		temp.height = (l > r ? l + 1 : r + 1);
//    		//calc size
//    		l = (temp.left != null ? temp.left.size : -1);
//    		r = (temp.right != null ? temp.right.size : -1);
//    		temp.size = (l > r ? l + 1 : r + 1);
//    		
//    		//climb up
//    		temp = temp.parent;
//    	}
//    }
    
    
    
//    //Check to see if rebalancing is necessary
//    private Entry<E> rebalance(Entry<E> currentNode){ 
//    	
//    	if(currentNode.left != null && currentNode.right != null) {
//    		//Return if the two subtrees have height less than or equal to 3
//    		if(currentNode.left.height < 4 && currentNode.right.height < 4) {
//    			return null;
//    		}
//    		
//    		//Need to rebalance if the tree is lopsided and has significant height
//    		if((currentNode.left.height >= 2 * currentNode.right.height) ||
//    				currentNode.right.height >= 2 * currentNode.left.height) {
//    			
//    			//need to rebalance
//    			
//    		}
//    		
//    		
//    	}
//    	// if left not null and right is null
//    	if(currentNode.left != null && currentNode.right == null) {
//    		if(currentNode.left.height > 2) {
//    			// need to rebalance
//    		}
//    	}
//    	// if right not null and left is null
//    	if(currentNode.right != null && currentNode.left == null) {
//    		if(currentNode.right.height > 2) {
//    			// need to rebalance
//    		}
//    	}
//
//    	return null;
//    }
//    
    
//    private void toArray(ArrayList<Entry<E>> list, Entry<E> currentNode) {
//    	
//    	list.add(currentNode);
//    	if(currentNode.left != null) {
//    		toArray(list, currentNode.left);
//    	}
//    	
//    	if(currentNode.right != null) {
//    		toArray(list, currentNode.right);
//    	}
//    	
//    	return;
//    }
    
//     
//    //Rebalance tree based on node
//    private void rebalanceTree(Entry<E> node) {
//    	
//    	Entry<E> temp = node;
//    	
//    	//Convert subtree from node into an array
//    	ArrayList<Entry<E>> entries = new ArrayList<Entry<E>>();
//    	toArray(entries, node);
//    	//Sort subtree from node
//    	Collections.sort(entries, new EntryComparator());
//    	
//    	//pick new middle
//    	Entry<E> mid = entries.get(entries.size() / 2);
//    	
//    	//generate new tree
//    	
//    	
//    	
//    }
    
//    //Generate new tree from node and list
//    private void newTree(ArrayList<Entry<E>> list, Entry<E> middle) {
//    	if(list.size() < 2) {
//    		return;
//    	}
//    	
//    	
//    	
//    }


//    public boolean remove (Object obj)
//    {
//        Entry<E> e = getEntry (obj);
//        if (e == null)
//            return false;
//        deleteEntry (e);
//        climbAndRecalc(e);
//        return true;
//    } 


    /**
     *  Finds the Entry object that houses a specified element, if there is such an Entry.
     *  The worstTime(n) is O(n), and averageTime(n) is O(log n).
     *
     *  @param obj - the element whose Entry is sought.
     *
     *  @return the Entry object that houses obj - if there is such an Entry;
     *                otherwise, return null.  
     *
     *  @throws ClassCastException - if obj is not comparable to the elements
     *                  already in this BinarySearchTree object.
     *  @throws NullPointerException - if obj is null.
     *
     */
//    protected Entry<E> getEntry (Object obj) 
//    {
//        int comp;
//
//        if (obj == null)
//           throw new NullPointerException();
//        Entry<E> e = root;
//        while (e != null) 
//        {
//            comp = ((Comparable)obj).compareTo(e.element);
//            if (comp == 0)
//                return e;
//            else if (comp < 0)
//                e = e.left;
//            else
//                e = e.right;
//        } // while
//        return null;
//    } // method getEntry
    
  

     /**
      *  Deletes the element in a specified Entry object from this BinarySearchTree.
      *  
      *  @param p – the Entry object whose element is to be deleted from this
      *                 BinarySearchTree object.
      *
      *  @return the Entry object that was actually deleted from this BinarySearchTree
      *                object. 
      *
      */
//    protected Entry<E> deleteEntry (Entry<E> p) 
//    {
//        size--;
//
//        // If p has two children, replace p's element with p's successor's
//        // element, then make p reference that successor.
//        if (p.left != null && p.right != null) 
//        {
//            Entry<E> s = successor (p);
//            p.element = s.element;
//            p = s;
//        } // p had two children
//
//
//        // At this point, p has either no children or one child.
//
//        Entry<E> replacement;
//         
//        if (p.left != null)
//            replacement = p.left;
//        else
//            replacement = p.right;
//
//        // If p has at least one child, link replacement to p.parent.
//        if (replacement != null) 
//        {
//            replacement.parent = p.parent;
//            if (p.parent == null)
//                root = replacement;
//            else if (p == p.parent.left)
//                p.parent.left  = replacement;
//            else
//                p.parent.right = replacement;
//        } // p has at least one child  
//        else if (p.parent == null)
//            root = null;
//        else 
//        {
//            if (p == p.parent.left)
//                p.parent.left = null;
//            else
//                p.parent.right = null;        
//        } // p has a parent but no children
//        return p;
//    } // method deleteEntry


    /**
     *  Finds the successor of a specified Entry object in this BinarySearchTree.
     *  The worstTime(n) is O(n) and averageTime(n) is constant.
     *
     *  @param e - the Entry object whose successor is to be found.
     *
     *  @return the successor of e, if e has a successor; otherwise, return null.
     *
     */
//    protected Entry<E> successor (Entry<E> e) 
//    {
//        if (e == null)
//            return null;
//        else if (e.right != null) 
//        {
//            // successor is leftmost Entry in right subtree of e
//            Entry<E> p = e.right;
//            while (p.left != null)
//                p = p.left;
//            return p;
//
//        } // e has a right child
//        else 
//        {
//
//            // go up the tree to the left as far as possible, then go up
//            // to the right.
//            Entry<E> p = e.parent;
//            Entry<E> ch = e;
//            while (p != null && ch == p.right) 
//            {
//                ch = p;
//                p = p.parent;
//            } // while
//            return p;
//        } // e has no right child
//    } // method successor
    
//    public int getNodeCount() {
//    	if (root == null)
//    		return 0;
//    	return root.getNodeCount();
//    }
//    
//    public int getHeight() {
//    	if (root == null)
//    		return -1;
//    	return root.getHeight();
//    }
    
//    protected class TreeIterator implements Iterator<E>
//    {
//
//        protected Entry<E> lastReturned = null,
//                           next;               
//
//        /**
//         *  Positions this TreeIterator to the smallest element, according to the Comparable
//         *  interface, in the BinarySearchTree object.
//         *  The worstTime(n) is O(n) and averageTime(n) is O(log n).
//         *
//         */
//        protected TreeIterator() 
//        {             
//            next = root;
//            if (next != null)
//                while (next.left != null)
//                    next = next.left;
//        } // default constructor
//
//
//        /**
//         *  Determines if there are still some elements, in the BinarySearchTree object this
//         *  TreeIterator object is iterating over, that have not been accessed by this
//         *  TreeIterator object.
//         *
//         *  @return true - if there are still some elements that have not been accessed by
//         *                this TreeIterator object; otherwise, return false.
//         *
//         */ 
//        public boolean hasNext() 
//        {
//            return next != null;
//        } // method hasNext
//
//
//        /**
//         *  Returns the element in the Entry this TreeIterator object was positioned at 
//         *  before this call, and advances this TreeIterator object.
//         *  The worstTime(n) is O(n) and averageTime(n) is constant.
//         *
//         *  @return the element this TreeIterator object was positioned at before this call.
//         *
//         *  @throws NoSuchElementException - if this TreeIterator object was not 
//         *                 positioned at an Entry before this call.
//         *
//         */
//        public E next() 
//        {
//            if (next == null)
//                throw new NoSuchElementException();
//            lastReturned = next;
//            next = successor (next);             
//            return lastReturned.element;
//        } // method next
//
//        /**
//         *  Removes the element returned by the most recent call to this TreeIterator
//         *  object’s next() method.
//         *  The worstTime(n) is O(n) and averageTime(n) is constant.
//         *
//         *  @throws IllegalStateException - if this TreeIterator’s next() method was not
//         *                called before this call, or if this TreeIterator’s remove() method was
//         *                called between the call to the next() method and this call.
//         *
//         */ 
//        public void remove() 
//        {
//            if (lastReturned == null)
//                throw new IllegalStateException();
// 
//            if (lastReturned.left != null && lastReturned.right != null)
//                next = lastReturned;
//            deleteEntry(lastReturned);
//            lastReturned = null; 
//        } // method remove     
//
//    } // class TreeIterator

//    protected static class Entry<E> 
//    {
//        protected E element;
//
//        protected Entry<E> left = null,
//                           right = null,
//                           parent;
//        
//        protected int size;
//        protected int height;
//        
//        /**
//         *  Initializes this Entry object.
//         *
//         *  This default constructor is defined for the sake of subclasses of
//         *  the BinarySearchTree class. 
//         */
//        public Entry() { 
//        	
//        	size = 1;
//        	height = 0;
//        }
//
//        protected void print(boolean isLeft, String indent) {
//
//	        String nodeDisplay = element.toString() + "  (" + height + ", " + size + ")";
//	
//	        if (isLeft) System.out.println("" + indent + "__" + nodeDisplay);
//	        else System.out.println(deleteLastChar(indent) + "|__" + nodeDisplay);
//	
//	        if (left == null && right == null && !isLeft)
//	            System.out.println(deleteLastChar(indent));
//	
//	        if (left == null && right == null)
//	            return;
//	
//	        if (isLeft) indent += "  |";
//	        else indent = deleteLastChar(indent) + "   |";
//	
//	        if (left == null) System.out.println(indent + "__null");
//	        else left.print(true, indent);
//	
//	        if (right == null) System.out.println(indent + "__null");
//	        else right.print(false, indent);
//        }
//
//   
//
//	    public static String deleteLastChar(String s) {
//	
//	    	return s.substring(0, s.length()-1);
//	
//	    }
//        
//        
//
//        public int getNodeCount() {
//			if (left != null && right != null)
//				return 1 + left.getNodeCount() + right.getNodeCount();
//			else if (left != null)
//				return 1 + left.getNodeCount();
//			else if (right != null)
//				return 1 + right.getNodeCount();
//			else
//				return 1;
//		}
//        
//        public int getHeight() {
//        	int a, b;
//        	if (left != null && right != null)
//        		return 1 + ( (a = left.getHeight()) > (b = right.getHeight()) ? a : b);
//        	else if (left != null)
//        		return 1 + left.getHeight();
//        	else if (right != null)
//        		return 1 + right.getHeight();
//        	else
//        		return 0;
//        }
//
//
//		/**
//         *  Initializes this Entry object from element and parent.
//         *
//         */ 
//         public Entry (E element, Entry<E> parent) 
//         {
//             this.element = element;
//             this.parent = parent;
//         } // constructor

 //   } // class Entry
    
    
//    //Comparator class for comparing Entries
//    protected class EntryComparator implements Comparator<Entry<E>>{
//
//    	@Override
//    	public int compare(Entry<E> o1, Entry<E> o2) {
//    		return o1.element.toString().compareTo(o2.element.toString());
//    	}
//    	
//    }

//} // class BinarySearchTree

