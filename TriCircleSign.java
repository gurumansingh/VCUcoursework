/*************************************************************************
* Tri Circle Sign Cost Project for CMSC 255 
**************************************************************************
* This is Project 3 for CMSC 255. The purpose is to determine the cost of
* a custom-made sign that is in the shape of a circle with a triangle 
* inside of it; the user picks the size of the triangle and what should be
* written on the sign.
*_________________________________________________________________________
* Gurumanpreet Singh
* Project Version 1.0, September 26th, 2019
* CMSC 255 Section 002
*************************************************************************/

import java.util.Scanner;		

public class TriCircleSign {

	public static void main(String[] args) {
        
		String choice = "";
        
		Scanner input = new Scanner(System.in);

		/*
		* The following line of code creates the while loop that will run until the user
		* inputs "quit". 
		*/
        while (!choice.equals("quit")){			


			/*
			* The following lines of code ask for user input and store the input into a double.
			* The double stored is named "length" (one side of the inscribed triangle).
			*/
		
            System.out.println("Enter the length of a side of your triangle:");
            double length = input.nextInt();
            input.nextLine();
			
			
			/*
			* The following lines of code ask for user input and store the input into a string.
			* The string stored is named "words" (what the user wants on the sign).
			*/
			
            System.out.println("Enter the string you would like on your sign:");
            String words = input.nextLine();
            
			
            /*
			* The following lines of code find the length of the user-inputed string.
			* The ".replace(" ", "")" part of the code removes any spaces in the string
			* The length is stored into an int named "wordlength" and then multipled by 1.45
			* This gives the cost of just the words printed on the sign
			*/
			
            int wordlength = words.replace(" ", "").length();
            double wordscost = wordlength * 1.45;
			
			
			/*
			* The following lines of code perform the mathematical operations to get the area
			* of the circle given the length of one side of the inscribed equilateral triangle
			* The formula comes from the cosine of the adjacent angle to any side of the triangle
			* Since cosine(60) = sqrt(3)/2, this can be used to find the altitude and then radius
			* of the circle. The radius is used to the find the area of the circle.
			*/
			
            double halflength = length/2;
            
            double radius = halflength / Math.sqrt(3) * 2;
            
            double area = Math.PI * Math.pow(radius, 2);
        
		
			/*
			* The following line of code finds the cost based on the area of the circle.
			* The calculated area is multipled by 2.35 and stored in a double called "sizecost".
			*/
			
            double sizecost = area * 2.35;
            
			
			/*
			* The following lines of code print out the total cost of the sign
			* The cost from the words and the cost based on size are added together.
			* Both values are doubles, they are formatted to only print up to 2 decimal places.
			*/
            System.out.printf("$" + "%.2f", sizecost + wordscost);
            System.out.println("");
            
			
			/*
			* The following lines of code ask the user if he/she would like to create a new sign
			* If the user inputs "quit", the while loop ends, ending the program.
			*/
            
            System.out.println("Would you like to create another sign? Enter quit to exit.");
			
            choice = input.nextLine().trim();
            
        } 
		input.close();		//stops further input from the scanner
			
    }
}