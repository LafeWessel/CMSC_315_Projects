package Project_06_2;

public class BSTEntry<E>{
	
	 

     public BSTEntry<E> left = null,
                        right = null,
                        parent;
     
     public int size;
     public int height;
     public E element;
     
     public BSTEntry() { 
     	parent = null;
     	size = 1;
     	height = 0;
     	element = null;
     }
     
     public BSTEntry(E elem) {
    	 parent = null;
    	 size = 1;
    	 height = 0;
    	 element = elem;
     }
     
      public BSTEntry (E element, BSTEntry<E> parent) 
      {
          this.element = element;
          this.parent = parent;
          size = 1;
          height = 0;
      } 

     public void print(boolean isLeft, String indent) {

	        String nodeDisplay = element.toString() + "  (" + height + ", " + size + ")";
	        
	        if (isLeft) System.out.println("" + indent + "__" + nodeDisplay);
	        else System.out.println(deleteLastChar(indent) + "|__" + nodeDisplay);
	
	        if (left == null && right == null && !isLeft)
	            System.out.println(deleteLastChar(indent));
	
	        if (left == null && right == null)
	            return;
	
	        if (isLeft) indent += "  |";
	        else indent = deleteLastChar(indent) + "   |";
	
	        if (left == null) System.out.println(indent + "__null");
	        else left.print(true, indent);
	
	        if (right == null) System.out.println(indent + "__null");
	        else right.print(false, indent);
     }



    private static String deleteLastChar(String s) {
	
    	return s.substring(0, s.length()-1);
	
    }
     
   
     // will work because we will only be using string with this class
     public int equals(BSTEntry<E> e) {
    	 return element.toString().compareTo(e.element.toString());
     }
     
     public String toString() {
    	 return element.toString();
     }
     
     public void print() {
    	 System.out.println("(Height, Size)");
    	 this.print(false, " ");
     }
}
