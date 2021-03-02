package Project_06_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;


// result =  this.equals(e)
// if result > 0 : this comes after e
// if result == 0 : this is same as e
// if result < 0 : this comes before e




//extends AbstractSet<E>
public class BinaryST<E> {
	
	protected BSTEntry<E> root;
	protected int size;
	public boolean debug;
	
	public BinaryST(){
		root = null;
		size = 0;
		debug = false;
	}

	public Iterator<?> iterator() {
		System.err.println("Can't use this iterator!");
		throw new IllegalArgumentException();
	}

	public int size() {
		return size;
	}
	
	public void insert(E e) {
		add(new BSTEntry<E>(e));
	}
	
	
	public void add(BSTEntry<E> e) {
		if(e == null) {
			System.err.println("E is null!");
			return;
		}
		if(root == null) {
            if (e.element == null) {
            	System.err.println("first Element == null!");
            	return;
            }
			root  = new BSTEntry<E>(e.element);
			size++;
			if(debug) System.out.println("First element added to BST!");
			return;
		}
		
		if(!entryExists(e)) {
            BSTEntry<E> temp = root;

            int comp = 0;

            while (true) {
                comp = temp.equals(e);
                if (comp > 0) {
                	
                    if (temp.left != null)
                        temp = temp.left;
                    else 
                    {
                        temp.left = new BSTEntry<E> (e.element);
                        temp.left.parent = temp;
                        size++;
                        if(debug) System.out.println(e.toString() + " left of " + temp.toString());
                        climbAndRecalc(temp.left);
                        //this.print();
                        rebalance();
                        
                        return;
                    }
                }
                else if( comp < 0) {
                    if (temp.right != null) {
                        temp = temp.right;
                    }
                    else 
                    {
                        temp.right = new BSTEntry<E> (e.element);
                        temp.right.parent = temp;
                        size++;
                        if(debug) System.out.println(e.toString() + " right of " + temp.toString());
                        climbAndRecalc(temp.right);
                        //this.print();
                        rebalance();
                       
                        return;
                    } 
                }
            } 
		}
		else {
			System.err.println(e.element + " already in tree!");
		}
		
	}
	
	public BSTEntry<E> remove(BSTEntry<E> e) {
        if (e == null) {
        	System.err.println("Tried to remove null element");
            return null;
        }
        
        if(!entryExists(e)) {
        	System.err.println(e.element + " not in tree");
        	return null;
        }
        
        BSTEntry<E> r = deleteEntry (e);
        climbAndRecalc(e);
        return r;
	}
	
	//return if entry exists in BST
	public boolean entryExists(BSTEntry<E> e) {
		
		if(find(e) != null) {
			return true;
		}
		return false;
	}
	
	//find an entry, return it if found, return null if not
	public BSTEntry<E> find(BSTEntry<E> e){
		
		if(e == null) {
			System.err.println("E is null!");
			return null;
		}
		
		BSTEntry<E> b = root;
		
		while(b != null) {
			int i = b.equals(e);
			if(i == 0) {
				//if(debug)System.out.println( e.element + " found in BST!");
				return b;
			}
			else if(i > 0) {
				b = b.left;
			}
			else {
				b = b.right;
			}
		}
		return null;
	}
	
	
	
	private void rebalance() {
		
		root = rebalanceSubTree(root);
		
	}
	
	
	//returns root/middle of new tree/subtree, checks to see if we need to rebalance a tree based on e
	private BSTEntry<E> rebalanceSubTree(BSTEntry<E> e){ 

		if(e == null) {
			System.err.println("Entry e is null!");
			return null;
		}
		if(e.left == null && e.right == null) {
			System.err.println("Both children of Entry e are null!");
			return e;
		}
		
		
		 //if the tree is small enough, don't rebalance
		if(e.height < 4) {
			if(debug)System.err.println("Subtree height < 4");
			return e;
		}
		// determine if the trees are imbalanced enough
		
		int leftHeight = 0;
		int rightHeight = 0;
		if(e.left != null) {
			leftHeight = e.left.height;
		}
		if(e.right != null) {
			rightHeight = e.right.height;
		}
		
		if(debug) System.out.println("LH: " + leftHeight + " RH: " + rightHeight);
		
		int greaterHeight = ((leftHeight - rightHeight > 0) ? leftHeight : rightHeight);
		int lesserHeight =  ((leftHeight - rightHeight < 0) ? leftHeight : rightHeight);
		
		if( greaterHeight >= 2 * lesserHeight) {
			
			// tree needs to be balanced
			//System.err.println("Need to rebalance tree!");
			ArrayList<BSTEntry<E>> subTree = new ArrayList<BSTEntry<E>>();
			arrayFromTree(subTree, e);

			if(debug) System.out.println(subTree.toString());
			
			
			e = balance(subTree, e, 0, subTree.size()-1 );
			
			if(e.parent != null) {
				if(e.parent.equals(e) > 0) {
					// know e is left of parent
					e.parent.left = e;
					//System.out.println("");
				}else if(e.parent.equals(e) < 0){
					//know e is right of parent
					e.parent.right = e;
				}else {				
					System.err.println("Somehow e and parent are equal");
				}
			}


			
//			System.out.println("ePar: " + ePar.toString());
//			System.out.println("ePar.left: " + ePar.left.toString());
//			System.out.println("ePar.right: " + ePar.right.toString());
			

			

			
			recount(e);
			//e.print();
			return e;
		}
		
		//Keep looking down tree to see if it needs to be rebalanced anywhere else
		if(e.left != null) {
			if(debug)System.out.println("rebalancing left");
			rebalanceSubTree(e.left);
		}
		if(e.right != null) {
			if(debug)System.out.println("rebalancing right");
			rebalanceSubTree(e.right);
		}
		return e;
	}
	
	
	private BSTEntry<E> balance(ArrayList<BSTEntry<E>> a, BSTEntry<E> e, int lowBound, int upBound) {

		if(e == null) {
			System.err.println("Entry E was null!");
			return null;
		}
		
		if(lowBound > upBound) {
			System.err.println("Bounds crossed!");
			System.exit(0);
		}
		
		//System.out.println("Entry e: " + e.toString());
		
		
		int midPt = (upBound + lowBound + 1) / 2;
		BSTEntry<E> mid = a.get(midPt);
		
		//System.out.println("Entry mid: " + mid.toString());
		
		mid.parent = e.parent;
		e = mid;
		
//		System.out.println("Size of array: " + a.size());
//		System.out.println(a.toString());
//		System.out.println("LowBound: " + lowBound);
//		System.out.println("UpBound: " + upBound);
		
		//Are only 1-3 elements in a
		if(upBound - lowBound <= 2) {
			switch(upBound - lowBound) {
			case 0:
				//System.out.println("Case 0");
				e.height = 0;
				e.size = 1;
				e.right = null;
				e.left = null;
				//e.print();
				return e;
			case 1:
				//System.out.println("Case 1");
				e.left = a.get(lowBound);
				e.left.parent = e;
				e.left.size = 1;
				e.left.height = 0;
				e.left.left = null;
				e.left.right = null;
				e.right = null;
				e.size = 2;
				e.height = 1;
				//e.print();
				return e;
			case 2:
				//System.out.println("Case 2");
				e.left = a.get(lowBound);
				e.left.parent = e;
				e.right = a.get(upBound);
				e.right.parent = e;
				e.left.size = 1;
				e.left.height = 0;
				e.right.size = 1;
				e.right.height = 0;
				e.right.right = null;
				e.right.left = null;
				e.left.right = null;
				e.left.left = null;
				e.size = 3;
				e.height = 1;
				//e.print();
				return e;
			default:
				System.err.println("Something went wrong: " +  (upBound - lowBound));	
			}
		}

		
		//a has 3+ elements
		
		
		if(debug) System.out.println("A size: " + a.size());
		//if(debug) System.out.println("Middle: " + e.toString());
		
		e.left = balance(a, e, lowBound, midPt-1);
		e.left.parent = e;
		e.right = balance(a, e, midPt+1, upBound);
		e.right.parent = e;
		return e;
	}
	
	//recursively iterate through tree and fix sizes from top down
	private void recount(BSTEntry<E> e) {
		if(e == null) {
			return;
		}

		e.height = 0;
		e.size = 1;
		if(e.left != null) {
			recount(e.left);
			e.height = e.left.height +1;
			e.size += e.left.size;
		}
		if(e.right != null) {
			recount(e.right);
			if(e.right.height >= e.height) { //compare heights
				e.height = e.right.height +1;
			}
			e.size += e.right.size;
		}
		
		//System.out.println(e.toString() + " sz: " + e.size + " h: " + e.height);
		//climbAndRecalc(e);
	}
	
	//Create an ArrayList from a tree
	public void arrayFromTree(ArrayList<BSTEntry<E>> a, BSTEntry<E> e){
		
		if(e == null) {
			System.err.println("Entry e is null!");
			return;
		}

		if(e.left != null) {
			arrayFromTree(a,e.left);
		}
		a.add(e);
		if(e.right != null) {
			arrayFromTree(a,e.right);
		}

	}
	
	
	public void print() {
	    if (root == null)
	         System.err.println("--Empty tree--");
	    
	     root.print(false, " ");
	}
	
	
	private BSTEntry<E> deleteEntry(BSTEntry<E> e) {
		
		if(debug) System.out.println("Removing " + e.toString());
        size--;

        // If e has two children, replace e's element with e's successor's
        // element, then make e reference that successor.
        if (e.left != null && e.right != null) 
        {
        	if(debug) System.out.println("E has 2 children");
            BSTEntry<E> s = successor(e);
            e.element = s.element;
            e = s;
            return e;
        }


        // At this point, p has either no children or one child.

        BSTEntry<E> replacement;
         
        if (e.left != null)
            replacement = e.left;
        else
            replacement = e.right;

        // If p has at least one child, link replacement to p.parent.
        if (replacement != null) 
        {
            replacement.parent = e.parent;
            if (e.parent == null)
                root = replacement;
            else if (e == e.parent.left)
                e.parent.left  = replacement;
            else
                e.parent.right = replacement;
        } 
        //p has no children and no parent
        else if (e.parent == null)
            root = null;
        else // p has parent and no children
        {
            if (e == e.parent.left)
                e.parent.left = null;
            else
                e.parent.right = null;        
        } // p has a parent but no children
        
        System.out.println("Removed " + e.element);
        return e;
	}
	
    private BSTEntry<E> successor (BSTEntry<E> e) 
    {
        if (e == null)
            return null;
        else if (e.right != null) //e has right child
        {
            // successor is leftmost Entry in right subtree of e
            BSTEntry<E> p = e.right;
            while (p.left != null)
                p = p.left;
            if(debug) System.out.println(p.element + " is successor to " + e.element);
            return p;

        }
        else //e has left or no children
        {

            // go up the tree to the left as far as possible, then go up
            // to the right.
            BSTEntry<E> p = e.parent;
            BSTEntry<E> ch = e;
            while (p != null && ch == p.right) 
            {
                ch = p;
                p = p.parent;
            } // while
            if(debug)  System.out.println(p.element + " is successor to " + e.element);
            return p;
        } // e has no right child
    }
	
    //Goes up the tree from e and updates sizes/heights
	private void climbAndRecalc(BSTEntry<E> e) {
    	BSTEntry<E> temp = e.parent;
    	
    	int r = 0;
    	int l = 0;
    	
    	while(temp != null) {
    		
    		//calc height
    		l = (temp.left != null ? temp.left.height : -1);
    		r = (temp.right != null ? temp.right.height : -1);
    		temp.height = (l > r ? l + 1 : r + 1);
    		//calc size
    		l = (temp.left != null ? temp.left.size : 0);
    		r = (temp.right != null ? temp.right.size : 0);
    		temp.size = l+r+1;
    		
    		//climb up
    		temp = temp.parent;
    	}
	}
	
}


