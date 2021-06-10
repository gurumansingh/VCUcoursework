package cmsc256;
import java.util.Calendar;

public class AlgorithmAnalysis{

  public static void main(String[] args){
    // pass the value of n as a command line argument
    long n = Long.parseLong(args[0]);

    // counter for output
    int fragNum = 1;
    
    // get current time
    long startTime = System.nanoTime();
    // Fragment 1
    long sum = 0;
    for (int i = 0; i < n; i++) {
    	for (int j = 0; j < n * n; j++) {
    		for (int k = 0; k < j; k++) {
            sum++;
    		}
        }
    
        try{
            Thread.sleep(1);
        }
        catch(InterruptedException ie){
            System.out.println("Unable to sleep.");
        }

    }
    /*
     * // Fragment 1

for (int i = 0; i < n; i++)

    sum++;

 

// Fragment 2

for (int i = 0; i < n; i += 2)

    sum++;

 

// Fragment 3

for (int i = 0; i < n; i++)

    for (int j = 0; j < n; j++)

        sum++;

 

// Fragment 4

for (int i = 0; i < n; i++)

    sum++;

for (int j = 0; j < n; j++)

    sum++;

 

// Fragment 5

for (int i = 0; i < n; i++)

    for (int j = 0; j < n * n; j++)

        sum++;

 

// Fragment 6

for (int i = 0; i < n; i++)

    for (int j = 0; j < i; j++)

        sum++;

 

// Fragment 7

for (int i = 0; i < n; i++)

    for (int j = 0; j < n * n; j++)

        for (int k = 0; k < j; k++)

            sum++;

 

// Fragment 8

for (int i = 1; i < n; i = i * 2)

    sum++;


     */
    // get stop time and calculate actual run time
    long endTime = System.nanoTime();
    long diff = endTime - startTime;
    System.out.println("Time to compute Fragment " + fragNum++ + " was " + diff + " nanoseconds."); 
  
    // continue in the same way for the remaining code fragments

  }

}