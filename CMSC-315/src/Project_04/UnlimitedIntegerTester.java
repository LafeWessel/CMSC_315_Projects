package Project_04;

import java.math.BigInteger;
import java.util.Random;

public class UnlimitedIntegerTester {
	public static void main(String[] args) {

		UnlimitedInteger a;
		UnlimitedInteger b;
		UnlimitedInteger c;

		
		System.out.println("Testing with small numbers:");
		
		a = new UnlimitedInteger("12"); System.out.println("A is " + a);
		b = new UnlimitedInteger("7"); System.out.println("B is " + b);
		
		c = (a.add(b));
		System.out.print("According to you," + a + " + " + b + " = " + c);
		if (c.toString().equals("19")) System.out.println("  Correct");	else System.out.println("  Wrong!");

		c = (a.subtract(b));
		System.out.print("According to you, " + a + " - " + b + " = " + c);
		if (c.toString().equals("5")) System.out.println("  Correct"); else System.out.println("  Wrong!");

		c = (a.multiply(b));
		System.out.print("According to you, " + a + " * " + b + " = " + c);
		if (c.toString().equals("84")) System.out.println("  Correct");  else System.out.println("  Wrong!");

		c = (a.pow(2));
		System.out.print("According to you, " + a + " ^ " + 2 + " = " + c);
		if (c.toString().equals("144")) System.out.println("  Correct"); else System.out.println("  Wrong!");

		c = (new UnlimitedInteger("5")).factorial();
		System.out.print("According to you, 5! = " + c);
		if (c.toString().equals("120")) System.out.println("  Correct"); else System.out.println("  Wrong!");


		
		//////////////////////////////////////////////////////////
		System.out.println("---------------------------");
		System.out.println("Testing with medium numbers:");
		
		a = new UnlimitedInteger("487652"); System.out.println("A is " + a);
		b = new UnlimitedInteger("365396"); System.out.println("B is " + b);
		
		c = (a.add(b));
		System.out.print("According to you," + a + " + " + b + " = " + c);
		if (c.toString().equals("853048")) System.out.println("  Correct");	else System.out.println("  Wrong!");

		c = (a.subtract(b));
		System.out.print("According to you, " + a + " - " + b + " = " + c);
		if (c.toString().equals("122256")) System.out.println("  Correct"); else System.out.println("  Wrong!");

		c = (a.multiply(b));
		System.out.print("According to you, " + a + " * " + b + " = " + c);
		if (c.toString().equals("178186090192")) System.out.println("  Correct");  else System.out.println("  Wrong!");

		c = (a.pow(7));
		System.out.println("According to you, " + a + " ^ " + 7 + " = " + c);
		if (c.toString().equals("6557979700838660104333950213065903587328")) System.out.println("  Correct"); else System.out.println("  Wrong!");

		c = (new UnlimitedInteger("22")).factorial();
		System.out.print("According to you, 22! = " + c);
		if (c.toString().equals("1124000727777607680000")) System.out.println("  Correct"); else System.out.println("  Wrong!");

		//////////////////////////////////////////////////////////
		System.out.println("---------------------------");
		System.out.println("\n\nAnd now for something a bit harder...");
		int num_of_probs_to_check = 3;
		int num_of_bits_per_number = 128;
		
		Random rnd = new Random();
		// Addition
		System.out.println("------------------ Addition ------------------");
		for (int i = 0; i < num_of_probs_to_check; i++) {
			BigInteger x = new BigInteger(num_of_bits_per_number, rnd); 
			BigInteger y = new BigInteger(num_of_bits_per_number, rnd);
						
			a = new UnlimitedInteger(x.toString());
			b = new UnlimitedInteger(y.toString());
			c = a.add(b);
			System.out.println(a + "\n + \n" + b + "\n = \n" + c);
			if (c.toString().equals(x.add(y).toString())) {
				System.out.println("That is correct.\n");
			} else {
				System.out.println("That is wrong.\n");
			}
		}
		
		// Subtraction
		System.out.println("------------------ Subtraction ------------------");
		for (int i = 0; i < num_of_probs_to_check; i++) {
			BigInteger x = new BigInteger(num_of_bits_per_number, rnd); 
			BigInteger y = new BigInteger(num_of_bits_per_number, rnd);
								
			a = new UnlimitedInteger(x.toString());
			b = new UnlimitedInteger(y.toString());
			c = a.subtract(b);
			System.out.println(a + "\n - \n" + b + "\n = \n" + c);
			if (c.toString().equals(x.subtract(y).toString())) {
				System.out.println("That is correct.\n");
			} else {
				System.out.println("That is wrong.\n");
			}
		}

		// Multiplication
		System.out.println("------------------ Multiplication ------------------");
		for (int i = 0; i < num_of_probs_to_check; i++) {
			BigInteger x = new BigInteger(num_of_bits_per_number, rnd); 
			BigInteger y = new BigInteger(num_of_bits_per_number, rnd);
								
			a = new UnlimitedInteger(x.toString());
			b = new UnlimitedInteger(y.toString());
			c = a.multiply(b);
			System.out.println(a + "\n x \n" + b + "\n = \n" + c);
			if (c.toString().equals(x.multiply(y).toString())) {
				System.out.println("That is correct.\n");
			} else {
				System.out.println("That is wrong.\n");
			}
		}

		// Exponents
		System.out.println("------------------ Exponents ------------------");
		for (int i = 0; i < num_of_probs_to_check; i++) {
			BigInteger x = new BigInteger(num_of_bits_per_number, rnd); 
			int y = rnd.nextInt(10)+5;
								
			a = new UnlimitedInteger(x.toString());
			c = a.pow(y);
			System.out.println(a + " ^ " + y + " = " + c);
			if (c.toString().equals(x.pow(y).toString())) {
				System.out.println("That is correct.\n");
			} else {
				System.out.println("That is wrong.\n");
			}
		}

		// Factorial
		System.out.println("------------------ Factorial ------------------");
		for (int i = 0; i < num_of_probs_to_check; i++) {
			int temp = rnd.nextInt(100)+50;
			BigInteger x = new BigInteger(Integer.toString(temp,10));
								
			a = new UnlimitedInteger(Integer.toString(temp, 10));
			c = a.factorial();
			System.out.println(a + "! = " + c);
			if (c.toString().equals(bigIntFactorial(x).toString())) {
				System.out.println("That is correct.\n");
			} else {
				System.out.println("That is wrong.\n");
			}
		}
	}
	
	private static BigInteger bigIntFactorial(BigInteger x) {
		if (x.equals(BigInteger.ONE))
			return BigInteger.ONE;
		
		return x.multiply(bigIntFactorial(x.subtract(BigInteger.ONE)));
	}
}

