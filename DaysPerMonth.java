
/******************************************************************************
 *   DaysPerMonth
 *   VCU - Computer Science Department
 *   A program that prompts the user for a month and year (both as integers)
 *   then displays the number of days in that month.
 ******************************************************************************/
import java.io.*;
import java.util.*;

public class DaysPerMonth {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        File inputFile = null;
        boolean processFile = false;
        int arguments = args.length;
        if (arguments != 1) {
            while (!processFile) {
                System.out.print("Please enter a filename: ");
                inputFile = new File(input.nextLine());
                if (inputFile.exists()) {
                    processFile = true;
                }
            }
        }else {
            inputFile = new File(args[0]);
            if (inputFile.exists()) {
                processFile = true;
            }
            while (!processFile) {
                System.out.print("Please enter a filename: ");
                inputFile = new File(input.nextLine());
                if (inputFile.exists()) {
                    processFile = true;
                }
            }
        }
        input = new Scanner(inputFile);
		int month = 1;
        int year = 2000;
        while (input.hasNextLine()) {
            
            try {
                String[] line = input.nextLine().split(",");
                month = Integer.parseInt(line[0]);
                year = Integer.parseInt(line[1]);
                if(month<1 || month > 12) {
                    System.out.println("Month must be between 1 and 12");
                    continue;
                }
                if(year < 0) {
                    System.out.println("Year cannot be negative");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Not an Integer");
            }
            int numDays = getDays(month, year);
            System.out.println("There are " + numDays + " days in this month.");
        }
    }// end main

    /************************************************************
     * method to determine the days for the given month and year
     ************************************************************/
    private static int getDays(int mon, int yr) {
        int numDays = 0;

        switch(mon) {
            case 2: // February
                numDays = 28;
                if (yr % 4 == 0) {
                    numDays = 29;
                    if (yr % 100 == 0 && yr % 400 != 0) {
                        numDays = 28;
                    }
                }
                break;

            case 4:   //April
            case 6:   // June
            case 9:   // September
            case 11:  // November
                numDays = 30;
                break;

            default: numDays = 31;  // all the rest
        }
        return numDays;
    }

}
