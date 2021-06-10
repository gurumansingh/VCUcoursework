/*************************************************************************
* NameArt Project for CMSC 255 
**************************************************************************
* This is Project 1 for CMSC 255. The purpose is to output my name in a 
* multi-line format. 
__________________________________________________________________________
* My name is Gurumanpreet Singh
* This is Version 1.0 submitted on 8/29/19
* Course CMSC 255, Section 002
*************************************************************************/

public class NameArt {
	
	public static void main(String [] args) throws InterruptedException{
		
		System.out.println("Gurumanpreet Singh");
		Thread.sleep(1000);            // This adds a 1 second delay before printing the next line
		
		System.out.println("Project 1 - Name in Code");
		Thread.sleep(1000);

		System.out.println("This project outputs my name in a unique way on the display screen");
		Thread.sleep(1000);
		
		System.out.println("August 29th, 2019");
		Thread.sleep(1000);
		
		System.out.println("CMSC 255 Section 002");
		Thread.sleep(1000);
		
		System.out.println("");      //These two lines will add some space to make the output look better
		System.out.println("");	
		
		
		// Everything after this outputs my name in multiple lines with 1/2 second delay in between each line
		System.out.println("   GGGGG     U       U   RRRRRR    U       U   MM       MM      AA      NN        N ");
			Thread.sleep(500);
		System.out.println("  G     G    U       U   R     R   U       U   M M     M M     A  A     N N       N ");
			Thread.sleep(500);
		System.out.println(" G           U       U   R     R   U       U   M  M   M  M    A    A    N  N      N ");
			Thread.sleep(500);
		System.out.println(" G           U       U   R     R   U       U   M   M M   M   A      A   N   N     N ");
			Thread.sleep(500);
		System.out.println(" G           U       U   RRRRRR    U       U   M    M    M   AAAAAAAA   N    N    N ");
			Thread.sleep(500);
		System.out.println(" G   GGGGG   U       U   R R       U       U   M         M   A      A   N     N   N ");
			Thread.sleep(500);
		System.out.println(" G       G   U       U   R  R      U       U   M         M   A      A   N      N  N ");
			Thread.sleep(500);
		System.out.println("  G     G    U       U   R   R     U       U   M         M   A      A   N       N N ");
			Thread.sleep(500);
		System.out.println("   GGGGG      UUUUUUU    R    R     UUUUUUU    M         M   A      A   N        NN ");
		
	}
	
}
