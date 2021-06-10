/*************************************************************************
 * Temperature Conversion Project for CMSC 255
 **************************************************************************
 * This is Project 4 for CMSC 255. The purpose is to convert a given
 * temperature in a particular unit to the equivalent temperature of
 * another user-chosen unit. The program outputs the converted
 * equivalent temperature
 *_________________________________________________________________________
 * Gurumanpreet Singh
 * Project Version 1.0, October 11th, 2019
 * CMSC 255 Section 002
 *************************************************************************/

import java.util.*;
public class TempConvert {
    //Main method
    public static void main(String[] args) {
        processData();
    }

    public static void processData(){
        String choice = "";
        Scanner input = new Scanner(System.in);
        /*
        * The following line of code creates the while loop that will run until the user
        * inputs "quit".
        */
        while (!choice.equals("quit")){
            /*
            * The following lines of code ask for user input and store the input into a double.
            * The double stored is named "temperature" (starting temperature).
            */
            System.out.println("Enter the temperature to convert:");
            double temperature = input.nextDouble();
            input.nextLine();
            /*
            * The following lines of code ask for user input and store the input into a string.
            * The string stored is named "current" (starting temperature unit).
            */
            System.out.println("Enter the current scale of the temperature:");
            String current = input.nextLine();
            /*
            * The following lines of code ask for user input and store the input into a string.
            * The string stored is named "wanted" (the converted temperature unit).
            */
            System.out.println("Enter the scale you want to convert the temperature to:");
            String wanted = input.nextLine();
            /*
            * The following lines of code set the returned boolean value from the
            * checkValidity method and store it in a boolean called "decision".
            */
            boolean decision = checkValidity(temperature, current);
            /*
            * The following lines of code check if the checkValidity method returned
            * true and perform actions based on that
            */
            if (decision == true) {
                /*
                * The following lines of code convert a Fahrenheit temperature to Celsius
                * The output temperature is rounded to 2 decimal places
                */
                if (current.equalsIgnoreCase("Fahrenheit") && wanted.equalsIgnoreCase("Celsius")){
                    convertFahtoCel(temperature);
                    double converted = convertFahtoCel(temperature);
                    System.out.printf("%.2f", temperature);
                    System.out.print(" degrees " + current + " is ");
                    System.out.printf("%.2f", converted);
                    System.out.print(" degrees " + wanted);
                    System.out.println("");
                }
                /*
                * The following lines of code convert a Fahrenheit temperature to Kelvin
                * The output temperature is rounded to 2 decimal places
                */
                else if (current.equalsIgnoreCase("Fahrenheit") && wanted.equalsIgnoreCase("Kelvin")){
                    convertFahtoKel(temperature);
                    double converted = convertFahtoKel(temperature);
                    System.out.printf("%.2f", temperature);
                    System.out.print(" degrees " + current + " is ");
                    System.out.printf("%.2f", converted);
                    System.out.print(" degrees " + wanted);
                    System.out.println("");
                }
                /*
                * The following lines of code convert a Celsius temperature to Fahrenheit
                * The output temperature is rounded to 2 decimal places
                */
                else if (current.equalsIgnoreCase("Celsius") && wanted.equalsIgnoreCase("Fahrenheit")){
                    convertCeltoFah(temperature);
                    double converted = convertCeltoFah(temperature);
                    System.out.printf("%.2f", temperature);
                    System.out.print(" degrees " + current + " is ");
                    System.out.printf("%.2f", converted);
                    System.out.print(" degrees " + wanted);
                    System.out.println("");
                }
                /*
                * The following lines of code convert a Celsius temperature to Kelvin
                * The output temperature is rounded to 2 decimal places
                */
                else if (current.equalsIgnoreCase("Celsius") && wanted.equalsIgnoreCase("Kelvin")){
                    convertCeltoKel(temperature);
                    double converted = convertCeltoKel(temperature);
                    System.out.printf("%.2f", temperature);
                    System.out.print(" degrees " + current + " is ");
                    System.out.printf("%.2f", converted);
                    System.out.print(" degrees " + wanted);
                    System.out.println("");
                }
                /*
                * The following lines of code convert a Kelvin temperature to Celsius
                * The output temperature is rounded to 2 decimal places
                */
                else if (current.equalsIgnoreCase("Kelvin") && wanted.equalsIgnoreCase("Celsius")){
                    convertKeltoCel(temperature);
                    double converted = convertKeltoCel(temperature);
                    System.out.printf("%.2f", temperature);
                    System.out.print(" degrees " + current + " is ");
                    System.out.printf("%.2f", converted);
                    System.out.print(" degrees " + wanted);
                    System.out.println("");
                }
                /*
                * The following lines of code convert a Kelvin temperature to Fahrenheit
                * The output temperature is rounded to 2 decimal places
                */
                else if (current.equalsIgnoreCase("Kelvin") && wanted.equalsIgnoreCase("Fahrenheit")){
                    convertKeltoFah(temperature);
                    double converted = convertKeltoFah(temperature);
                    System.out.printf("%.2f", temperature);
                    System.out.print(" degrees " + current + " is ");
                    System.out.printf("%.2f", converted);
                    System.out.print(" degrees " + wanted);
                    System.out.println("");
                }
                /*
                * The following lines of code don't perform a conversion
                * If the wanted unit matches the current temperature unit
                * The output temperature is rounded to 2 decimal places
                */
                else if (current.equalsIgnoreCase(wanted)){
                    System.out.printf("%.2f", temperature);
                    System.out.print(" degrees " + current + " is ");
                    System.out.printf("%.2f", temperature);
                    System.out.print(" degrees " + wanted);
                    System.out.println("");
                }
            }
            /*
            * The following lines of code are run when the user-inputted
            * temperature fails to pass the checkValidity method
            * (if the inputted temperature is out of the valid range
            */
            else if(decision == false){
                System.out.println(temperature + " degrees " + current + " is not a valid temperature");
            }
            /*
            * The following lines of code ask if the user would like to
            * convert another temperature. The program ends iff the user
            * inputs "quit".
            */
            System.out.println("Would you like to convert another temperature? Enter quit to exit.");
            choice = input.nextLine();
        }
    }
    /*
    * The following checkValidity method checks to see if the user
    * inputted temperature is in the valid range
    * The method returns true if it is, false if it's not
    */
    public static boolean checkValidity(double temp, String scale){
        boolean value = false;
        if (scale.equalsIgnoreCase("Fahrenheit")){
            if (temp >= -459.40 && temp <= 1000){
                value = true;
            }
        }
        else if (scale.equalsIgnoreCase("Celsius")){
            if (temp >= -273 && temp <= 1000) {
                value = true;
            }
        }
        else if (scale.equalsIgnoreCase("Kelvin")){
            if (temp >= 0 && temp <= 1000){
                value = true;
            }
        }
        return value;
    }
    /*
    * The following method converts Fahrenheit to Celsius
    * The method returns the converted temperature
    */
    public static double convertFahtoCel(double temp){
        double newtemp = ((temp-32)*5/9);
        return newtemp;
    }
    /*
    * The following method converts Fahrenheit to Kelvin
    * The method returns the converted temperature
    */
    public static double convertFahtoKel(double temp){
        double temporarytemp = ((temp-32)*5/9);
        double newtemp = temporarytemp + 273;
        return newtemp;
    }
    /*
    * The following method converts Celsius to Fahrenheit
    * The method returns the converted temperature
    */
    public static double convertCeltoFah(double temp){
        double newtemp = (temp * 9/5) + 32;
        return newtemp;
    }
    /*
    * The following method converts Celsius to Kelvin
    * The method returns the converted temperature
    */
    public static double convertCeltoKel (double temp){
        double newtemp = temp + 273;
        return newtemp;
    }
    /*
    * The following method converts Kelvin to Celsius
    * The method returns the converted temperature
    */
    public static double convertKeltoCel(double temp){
        double newtemp = temp - 273;
        return newtemp;
    }
    /*
    * The following method converts Kelvin to Fahrenheit
    * The method returns the converted temperature
    */
    public static double convertKeltoFah(double temp){
        double temporarytemp = temp - 273;
        double newtemp = (temporarytemp * 9/5) + 32;
        return newtemp;
    }
}


