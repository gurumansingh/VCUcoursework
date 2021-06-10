/*************************************************************************
 * Flight Analysis Project for CMSC 255
 **************************************************************************
 * This is the Flight class for Project 7 for CMSC 255. The purpose is to
 * find the best priced flights from a large list and output them to a file.
 *_________________________________________________________________________
 * Gurumanpreet Singh
 * Project Version 1.0, November 23rd, 2019
 * CMSC 255 Section 002
 *************************************************************************/
public class Flight {
    /*
    * The following lines of code initialize the instance variables
    */
    private String year;
    private String startCity;
    private String endCity;
    private double price;
    private int distance;

    public Flight(String year, String startCity, String endCity, double price, int distance) {
        /*
        * The following lines of code set the starting values in a
        * parameterized constructor
        */
        this.year = year;
        this.startCity = startCity;
        this.endCity = endCity;
        this.price = price;
        this.distance = distance;
    }

    public Flight() {
        /*
        * The following lines of code set the default values in a
        * default constructor
        */
        year = "1970";
        startCity = "Boston";
        endCity = "Richmond";
        price = 40.0;
        distance = 900;
    }

    //getters
    public String getYear(){
        return this.year;
    }
    public String getStartCity(){
        return startCity;
    }
    public String getEndCity(){
        return endCity;
    }
    public double getPrice(){
        return price;
    }
    public int getDistance(){
        return distance;
    }

    //setters
    public void setYear(String year){
        this.year = year;
    }
    public void setStartCity(String startCity){
        this.startCity = startCity;
    }
    public void setEndCity(String endCity){
        this.endCity = endCity;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setDistance(int distance){
        this.distance = distance;
    }

    /*
    * The following lines of code return the flight information in a String
    */
    @Override
    public String toString(){
        return (getYear() + " " + getStartCity() + " " + getEndCity() + " " + getPrice() + " " + getDistance());
    }

    /*
    * The following method returns the boolean value based on if each instance variable
    * is equal to the Flight object’s instance variables passed in
    */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Flight) {
            Flight plane = (Flight) obj;
            return this.year.equals(plane.year) && this.startCity.equals(plane.startCity)
                    && this.endCity.equals(plane.endCity) && this.price == plane.price
                    && this.distance == plane.distance;
        }
        return false;
    }
}