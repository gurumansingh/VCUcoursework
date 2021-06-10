/*************************************************************************
 * Flight Analysis Project for CMSC 255
 **************************************************************************
 * This is Project 7 for CMSC 255. The purpose is to find the best priced
 * flights from a large list and output them to a file.
 *_________________________________________________________________________
 * Gurumanpreet Singh
 * Project Version 1.0, November 23rd, 2019
 * CMSC 255 Section 002
 *************************************************************************/
import java.util.*;
import java.io.*;

public class FlightAnalysis {
    //Main Method
    public static void main(String[] args) throws FileNotFoundException{
        /*
        * The following lines of code create the two ArrayLists
        */
        ArrayList<Flight> completeData = new ArrayList<>();
        ArrayList<Flight> removeItems = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        //setting default values for input and output file names
        String inputFileName = null;
        String outputFileName = null;
        int arguments = args.length;
        //checking if arguments for file names are given
        if (arguments == 2){
            inputFileName = args[0];
            outputFileName = args [1];
            try{
                File inputFile = new File("FlightData.txt");
                input = new Scanner(inputFile);
            }catch(FileNotFoundException e){
                System.out.println("Please specify file: ");
                inputFileName = input.nextLine();
            }
        }else{          // if no arguments are given for input and output file names
            System.out.println("Please specify file: ");
            inputFileName = input.nextLine();
            System.out.println("Please specify output file: ");
            outputFileName = input.nextLine();
        }
        input.close();

        //setting input and output files based on input or arguments
        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);

        try{
            completeData = parseData(inputFile);
            System.out.println("Input file correct");

        }catch(FileNotFoundException e){
            System.out.println("Incorrect input filename");
        }

        //setting the data to be removed file
        File dataToRemove = new File("dataToRemove.txt");
        removeItems = parseData(dataToRemove);
        removeData(completeData, removeItems);
        Flight cheapest = calcBestFare(completeData);
        Flight bestAvg = calcBestFarePerMile(completeData);
        //setting output for output file
        completeData.clear();
        completeData.add(cheapest);
        completeData.add(bestAvg);

        try{
            writeOutData(completeData, outputFile);
            System.out.println("Output file correct");
        }catch(FileNotFoundException e){
            System.out.println("Incorrect output filename");
        }

    }
    public static ArrayList<Flight> parseData(File inputFile) throws FileNotFoundException {
        //creating new variables to be set to values found in the complete data array
        ArrayList<Flight> Data = new ArrayList<>();
        Flight nextFlight;
        String year;
        String startCity;
        String endCity;
        double price;
        int distance;

        Scanner input = new Scanner(inputFile);
        //removing the header line from the data file so it doesn't show up in output
        String header = input.nextLine();
        //loop keeps going until reaching the end of the file
            while (input.hasNextLine()){
                String flightInfo = input.nextLine();
                String[] oneFlight = flightInfo.split(";");
                year = oneFlight[0];
                startCity = oneFlight[1];
                endCity = oneFlight[2];
                //sets price to the double value found in the input file
                //if the number isn't a correct double, it is set to 0.00
                try {
                    price = Double.parseDouble(oneFlight[3]);
                    if (Double.parseDouble(oneFlight[3]) < 0) {
                        price = 0.00;
                    }
                }catch (NumberFormatException e) {
                    price = 0.00;
                }
                //sets distance to int value found in the input file
                //if the number isn't a correct int, it is set to 0
                try {
                    distance = Integer.parseInt(oneFlight[4]);
                    if (Integer.parseInt(oneFlight[4]) < 0) {
                        distance = 0;
                    }
                }catch (NumberFormatException e) {
                    distance = 0;
                }

                //creating next flight line
                nextFlight = new Flight(year, startCity, endCity, price, distance);
                //adding each flight to the array that is returned
                Data.add(nextFlight);
            }
        input.close();
        return Data;
    }

    /*
    * The following lines of code remove the data from the dataToRemove file
    * from the input file
    */
    public static void removeData(ArrayList<Flight> completeData, ArrayList<Flight> removeItems){
        completeData.removeAll(removeItems);
    }

    /*
     * The following lines of code find the cheapest flight by checking each
     * entry in the input file
     */
    public static Flight calcBestFare(ArrayList<Flight> completeData){
        double cheapest = 99999.99;
        Flight cheapestFlight = completeData.get(0);
        for (int i=0; i < completeData.size(); i++){
            if (completeData.get(i).getPrice() < cheapest){
                cheapestFlight = completeData.get(i);
                cheapest = completeData.get(i).getPrice();
            }
        }
        return cheapestFlight;
    }

    /*
     * The following lines of code find the best deal flight based on the
     * price and the number of miles being traveled (distance)
     */
    public static Flight calcBestFarePerMile(ArrayList<Flight> completeData){
        double cheapestAvg = 99999.99;
        Flight cheapestFlightAvg = completeData.get(0);
        for (Flight complete : completeData) {
            if ((complete.getPrice()) / (complete.getDistance()) < cheapestAvg) {
                cheapestFlightAvg = complete;
                cheapestAvg = (complete.getPrice()) / (complete.getDistance());
            }
        }
        return cheapestFlightAvg;
    }

    /*
     * The following lines of code output the cheapest flight and the best
     * deal flight to an output file of the user's choice
     */
    public static void writeOutData (ArrayList<Flight> completeData, File outputFile) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(outputFile);
        for (Flight complete : completeData) {
            out.println(complete.toString());
        }
        out.close();
    }
}
