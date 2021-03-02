package Project_04;
public class UnlimitedInteger
{
	
	public UIntEntry head;
	public UIntEntry tail;
	public boolean negative = false;
	
    public UnlimitedInteger() {
    	head = null;
    	tail = null;
    	negative = false;
    }
    
    public UnlimitedInteger(String y) {
    	negative = false;
    	for(int i = y.length()-1; i >= 0; i--) {
    		addItem(new UIntEntry(Integer.parseInt(String.valueOf(y.charAt(i)))));
    	}
    }
    
    //Adds this and y
	public UnlimitedInteger add(UnlimitedInteger y) {
        UnlimitedInteger u = new UnlimitedInteger();
		
		// Start at ones place and add onwards
        //ct : cursor this
        //cy : cursor y
        UIntEntry ct = new UIntEntry(head.val, head.next, null);
		UIntEntry cy = new UIntEntry(y.head.val, y.head.next, null);
		int carry = 0;
		int sum = 0;
		int ctv = 0;
		int cyv = 0;
		
		
		while(ct != null || cy != null) {
		
			if(ct == null) {
				ctv = 0;
			}
			else {
				ctv = ct.val;
			}
			
			if(cy == null) {
				cyv = 0;
			}
			else {
				cyv = cy.val;
			}
			
			sum = (cyv + ctv + carry) % 10;
			carry = (cyv + ctv + carry) / 10;
			
			u.addItem(new UIntEntry(sum));
			
			
			if(ct != null) {
				ct = ct.next;
			}
			if(cy != null) {
				cy = cy.next;
			}
			
		}
		if(carry > 0) {
			u.addItem(new UIntEntry(carry));
		}
		
		return u;
    }

    public UnlimitedInteger subtract(UnlimitedInteger y) {
        
    	UnlimitedInteger u = new UnlimitedInteger();
    	
        //Determine which is greater
        //count the digits
        UIntEntry ct = this.tail;
        UIntEntry cy = y.tail;
        int countThis = 0;
        int countY = 0;
        
        //count digits
        while(ct != null) {
        	++countThis;
        	ct = ct.prev;
        }
        while(cy != null) {
        	++countY;
        	cy = cy.prev;
        }
        
        //determine which is larger
        //This is larger
        if( countThis > countY ) {
        	ct = this.head;
        	cy = y.head;
        } else if( countThis < countY ) { //Y is larger
        	u.negative = true;
        	ct = y.head;
        	cy = this.head;
        }else { // this and y have same number of digits
        	ct = this.tail;
        	cy = y.tail;
        	
        	while(ct != null && cy != null) { //loop through each digit
        		if(ct.val > cy.val) {
                	ct = this.head;
                	cy = y.head;
                	break;
        		} else if(ct.val < cy.val) {
        			u.negative = true;
                	ct = y.head;
                	cy = this.head;
                	break;
        		} else {
        			//Are same number
        			if(ct.prev == null && cy.prev == null)
        			{        			
        				return new UnlimitedInteger("0");
        			}
        			ct = ct.prev;
        			cy = cy.prev;	
        		}

        	}
        	
        }
		
		int carry = 0;
		int sum = 0;
		int ctv = 0;
		int cyv = 0;
		
		while(ct != null) {
		
			ctv = ct.val;
			ctv += carry;
			
			//Get bottom value
			if(cy == null) {
				cyv = 0;
			} else {
				cyv = cy.val;
			}
			
			//Get top value
			if(ctv < cyv) {
				ctv += 10;
				carry = -1;
			} else {
				carry = 0;
			}
			
			sum = ctv - cyv;
			u.addItem(new UIntEntry(sum));
			
			ct = ct.next;
			if(cy!= null) {
				cy= cy.next;
			}
			
		}
    	
    	return u;
    }
   
    public UnlimitedInteger multiply(UnlimitedInteger y) {
    	
        //Build new Unlimited Integer for each digit
    	UnlimitedInteger total = new UnlimitedInteger("0");
    	UnlimitedInteger digit = new UnlimitedInteger("0");
    	
        UIntEntry ct = this.head;
		UIntEntry cy = y.head;
		
		int offset1 = 0;
		int offset2 = 0;
		
		UnlimitedInteger d1 = new UnlimitedInteger();
		UnlimitedInteger d2 = new UnlimitedInteger();
		
		
		//First digit times all of multiplier then next digit
		while(ct != null) {
			while(cy != null) {		

				d1 = new UnlimitedInteger(String.valueOf(cy.val));
				d2 = new UnlimitedInteger(String.valueOf(ct.val));
				digit = new UnlimitedInteger("0");
				
				while(d1.greaterThanZero()) {
					
					digit = digit.add(d2);
					d1 = d1.subtract(new UnlimitedInteger("1"));
				}
				for(int i = 0; i < offset1; i++) {
					digit.addFront(new UIntEntry(0));
				}
				for(int i = 0; i < offset2; i++) {
					digit.addFront(new UIntEntry(0));
				}
				total = total.add(digit);
				cy = cy.next;
				offset1 +=1;
			}
			offset1 = 0;
			offset2 += 1;
			cy = y.head;
			
			ct = ct.next;
		}
		
    	return total;
    }
    
    public UnlimitedInteger pow(int y) {
        //Build new Unlimited Integer for each digit
    	UnlimitedInteger total = new UnlimitedInteger("0");
    	UnlimitedInteger n = new UnlimitedInteger("0");
    	
    	n = this.multiply(this);
    	total = total.add(n);
    	for(int i = 2; i < y; i++) {
    		n = n.multiply(this);
    	}
    	

    	return n;
    }
    
    public UnlimitedInteger factorial() {
    	return fact(this,new UnlimitedInteger("1"));

    }
    
    public UnlimitedInteger fact(UnlimitedInteger u, UnlimitedInteger tot) {
    	if(u.subtract(new UnlimitedInteger("1")).greaterThanZero()) {
    		return fact(u.subtract(new UnlimitedInteger("1")), tot.multiply(u));
    	}

    	return tot;
    }
    
    //Work backwards to print out the number
     public String toString() {
    	
    	String s = "";
    	UIntEntry u = tail;  
    	
    	if(negative) {
    		s += "-";
    	}
    	
    	//Remove leading 0s
    	while(u != head && u.val == 0) {
    		u = u.prev;
    	}
    	
    	s += u.val;
    	while(u != head){
    		u = u.prev;
    		s += u.val;
    		
    	}

        return s;
    }
    
    //Add to the end of the list
    public void addItem(UIntEntry u) {
    	if(head == null) {
    		head = u;
    		tail = u;
    		u.prev = null;
    		u.next = null;
    	}
    	
    	else {
    		u.prev = tail;
    		tail.next = u;
    		u.next = null;
    		tail = u;
    	}
    	
    }
    //add to front of the list
    public void addFront(UIntEntry u) {
    	if(head == null) {
    		head = u;
    		tail = u;
    		u.prev = null;
    		u.next = null;
    	}
    	
    	else {
    		u.prev = null;
    		head.prev = u;
    		u.next = head;
    		head = u;
    	}
    }
    
    //return true if the list is greater than 0
    public boolean greaterThanZero() {
    	
    	UIntEntry e = this.head;
    	
    	while(e != null) {
    		if(e.val > 0) {
    			return true;
    		}
    		
    		e = e.next;
    	}
    	
    	return false;
    }
}
