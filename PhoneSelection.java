/**********************************************************
* Gurumanpreet Singh
* CMSC 255 Section 002
**********************************************************/
import java.util.*;


public class PhoneSelection {
	
    public static void main(String [] args){
		
		/*
		Taking input from user
		*/
        Scanner input = new Scanner(System.in);			
        System.out.println("Enter a single letter, and I will tell you what the corresponding digit is on the telephone");
        String lowerletter = input.nextLine();
		
		/*
		Changing input to uppercase
		*/
		String result = lowerletter.toUpperCase();
		
		/*
		Saving just the first letter from the input string
		*/
        char letter = result.charAt(0);

		/*
		Checking which number should be in the output based on which letter is given as input
		*/
        if ((letter == 'A' || letter == 'B' || letter == 'C')){
            System.out.println("The digit 2 corresponds to the letter " + letter + " on the telephone.");
        } 
        
        else if ((letter == 'D' || letter == 'E' || letter == 'F')){
            System.out.println("The digit 3 corresponds to the letter " + letter + " on the telephone.");
        } 
         else if ((letter == 'G' || letter == 'H' || letter == 'I')){
            System.out.println("The digit 4 corresponds to the letter " + letter + " on the telephone.");
        } 
		 else if ((letter == 'J' || letter == 'K' || letter == 'L')){
            System.out.println("The digit 5 corresponds to the letter " + letter + " on the telephone.");
        } 
		 else if ((letter == 'M' || letter == 'N' || letter == 'O')){
            System.out.println("The digit 6 corresponds to the letter " + letter + " on the telephone.");
        } 
		 else if ((letter == 'P' || letter == 'Q' || letter == 'R' || letter == 'S')){
            System.out.println("The digit 7 corresponds to the letter " + letter + " on the telephone.");
        } 
		 else if ((letter == 'T' || letter == 'U' || letter == 'V')){
            System.out.println("The digit 8 corresponds to the letter " + letter + " on the telephone.");
        } 
		 else if ((letter == 'W' || letter == 'X' || letter == 'Y' || letter == 'Z')){
            System.out.println("The digit 9 corresponds to the letter " + letter + " on the telephone.");
        } 
		else {
			System.out.println("Incorrect input");
		
		}

    }
}