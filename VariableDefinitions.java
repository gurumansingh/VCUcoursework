

public class VariableDefinitions{

	
	public static void main(String[] args) throws InterruptedException{
		System.out.println("Guruman Singh and Victoria Lopez Del Pino");
		
		/*
		Initial declarations and assignments of variables
		*/
		byte numPeople = 3;
		boolean answer = false;
		double price = 32.32;
		char letter = 'a';
		
		/*
		Printing out each variable's starting value
		*/
		System.out.println("The numPeople variable has a value of " + numPeople);
		System.out.println("The boolean variable has a value of " + answer);
		System.out.println("The double variable has a value of " + price);
		System.out.println("The character variable has a value of " + letter);
		
		
		/*
		modifying values for existing variables
		*/
		numPeople = 6;
		answer = true;
		price = price + 10.68;
		letter = 'b';
		
		
		Thread.sleep (2000);
		System.out.println("");
		System.out.println("Modifying values...");
		Thread.sleep(2000);
		System.out.println("3");
		Thread.sleep(500);
		System.out.println("2");
		Thread.sleep(500);
		System.out.println("1");
		Thread.sleep(500);
		System.out.println("Done");
		Thread.sleep(1500);
		System.out.println("");
		
		
		
		System.out.println("The numPeople variable now has a value of " + numPeople);
		Thread.sleep(1000);
		System.out.println("The boolean variable now has a value of " + answer);
		Thread.sleep(1000);
		System.out.println("The double variable now has a value of " + price);
		Thread.sleep(1000);
		System.out.println("The character variable now has a value of " + letter);
		Thread.sleep(2000);
		/*
		Assigning constants now
		*/
		
		final int dontchange = 7;
		final boolean rightanswer = true;
		final double subtotal = 4.22;
		final long distance = 314159979;
			
		System.out.println("");
		System.out.println("");
		
		/*
		Printing constants
		*/
		System.out.println("The final int variable has a value of " + dontchange);
		System.out.println("The final boolean variable has a value of " + answer);
		System.out.println("The final double variable has a value of " + subtotal);
		System.out.println("The final long variable has a value of " + distance);
			
		/*
		Trying new assignments for final constants:
		
		The below line of code causes error - cannot assign a value to final variable
		
		dontchange = dontchange + 1;
		
		*/
		
		
		
	}
	
	
}