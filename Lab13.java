import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.lang.NumberFormatException;

public class Lab13 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.next();
        System.out.print("Output file: ");
        String outputFileName = console.next();

        File inputFile = new File(inputFileName);
        try {
            Scanner in = new Scanner(inputFile);
            PrintWriter out = new PrintWriter(outputFileName);
            int goal = 0;
            int mingoals = 1000;
            int maxgoals = 0;
            double sumShots = 0;
            String minteam = null;
            String maxteam = null;
            while (in.hasNextLine()){

                String line = in.nextLine();
                String[] tokens = line.split(",");

                try{
                    goal = Integer.parseInt(tokens[1]);
                    if(goal > maxgoals)
                    {
                        maxgoals = goal;
                        maxteam = tokens[0];
                    }
                    if (goal <= mingoals){
                        mingoals = goal;
                        minteam = tokens[0];
                    }
                    sumShots = sumShots + Double.parseDouble(tokens[2]);
                }
                catch(NumberFormatException e){
                    System.out.println("Bad data: " + tokens [0] + tokens[1] + tokens[2]);
                }

            }
            double average = sumShots / 20;
            out.println("Maximum goals Scored: " + maxteam + " " + maxgoals);
            out.println("Minimum goals Scored: " + minteam + " " + mingoals);
            out.println("Average shots per game: " + average);
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}