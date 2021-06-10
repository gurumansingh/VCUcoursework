//Gurumanpreet Singh
import java.util.*;
import java.util.regex.*;

public class cmsc401 {
    public static void main(String[] args){
        //create new table to store the values
        HashMap<String, Integer> valuesTable = new HashMap<>();
        //create scanner for reading input lines
        Scanner scan = new Scanner(System.in);
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);

        //while loop keeps reading input lines unless there is a mistake or QUIT is inputted
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            //split the input line into 'tokens' at each space
            String[] tokens = line.split(" ");
            //set integer for number of tokens found in the line
            int length = tokens.length;

            //if input is the word QUIT, length is 1, so do this
            if (length == 1){
                //if the first and only token found is "QUIT", exit the program
                //no need to check for other one word inputs like "quit" etc.
                if(tokens[0].equals("QUIT")){
                    //exit the program
                    break;
                }
            }

            //if input line is of the format (x# = #)
            //length of tokens will be 3 because there's 2 spaces
            if (length == 3){
                //check if the first variable has already been assigned a value
                //e.g. x1 cannot be assigned two different values in the same run
                if (valuesTable.containsKey(tokens[0])){
                    System.out.println("ERROR");
                    //exit the program
                    break;
                }
                //if the first variable hasn't shown up before, do this
                else{
                    Matcher match = pattern.matcher((tokens[2]));
                    //the variable after the '=' is being assigned to an int value
                    if (match.matches()){
                        int value = Integer.parseInt((tokens[2]));
                        //add this value and its key to the created table
                        valuesTable.put(tokens[0], value);
                        //print out the value that was just assigned
                        System.out.println(tokens[2]);
                    }
                    else{
                        //assign the value if the variable exists already
                        if(valuesTable.containsKey(tokens[2])){
                            int i = valuesTable.get(tokens[2]);
                            //add this value and its key to the created table
                            valuesTable.put(tokens[0],i);
                            //print out the value that was just assigned
                            System.out.println(i);
                        }
                        //if the variable hasn't been assigned a value but user is trying to use it
                        //e.g. if x2 hasn't been assigned a value yet, but input line says x3 = x2
                        else {
                            System.out.println("ERROR");
                            break;
                        }
                    }
                }
            }

            //next if the input line is of the format (x# = x# (+/-/*) x#)
            //length of tokens will by 5 because there's 4 spaces
            else if (length == 5){
                //boolean checks for the correct input
                boolean check = false;
                //if a variable already has an assigned value and is trying to assign a new value to it
                if(valuesTable.containsKey(tokens[0])){
                    System.out.println("ERROR");
                    //exit the program
                    break;
                }
                else{
                    //initializing 2 integers for the 2 variables on right side of equation
                    int one = 0;
                    int two = 0;
                    //check if the input line contains a second variable, assign it to int one
                    if(valuesTable.containsKey(tokens[2])){
                        one = valuesTable.get(tokens[2]);
                    }
                    else{
                        Matcher match = pattern.matcher((tokens[2]));
                        //second variable is being assigned to an int value
                        if (match.matches()){
                            one = Integer.parseInt(tokens[2]);
                        }
                        //otherwise the variable is unknown or incorrect type
                        else {
                            //reverse the boolean so an error will be thrown
                            check = true;
                        }
                    }
                    //check if the input line contains a third variable after the +,-,* operator
                    if (valuesTable.containsKey(tokens[4])){
                        //assign the third variable to int two
                        two = valuesTable.get(tokens[4]);
                    }
                    else{
                        Matcher match = pattern.matcher(tokens[4]);
                        //if an integer is found in the third variable
                        if (match.matches()) {
                            two = Integer.parseInt(tokens[4]);
                        }
                        //otherwise this variable is unknown or incorrect type
                        else{
                            //set check = true so an error will be thrown for incorrect input
                            check = true;
                        }
                    }
                    int output = 0;
                    //if check is true, then the input line isn't the right format
                    if (check){
                        System.out.println("ERROR");
                        //flip check back to false
                        check = false;
                        //exit the program
                        break;
                    }
                    //if input line is correct format and all variables are correct
                    //check for +,-,* operation and complete it
                    //first check for + operation
                    if(tokens[3].equals("+")){
                        //the output integer will be the sum of the two right side integers
                        output = one + two;
                    }
                    //or check for - operation
                    else if (tokens[3].equals("-")) {
                        //the output integer will be the difference of the two right side integers
                        output = one - two;
                    }
                    //or check for * operation
                    else if (tokens[3].equals("*")) {
                        //the output integer will be the multiplication of the two right side integers
                        output = one * two;
                    }
                    //store the value of output as the value of the input line's leftmost variable
                    valuesTable.put(tokens[0], output);
                    //print out the newly found output value
                    System.out.println(output);
                }
            }
        }
    }
}