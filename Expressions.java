
public class Expressions {
  public static void main(String[] args){
    int a = 3;
    int b = 4;
    int c = 5;
    int d = 17;
    
    /**********************************************************
     * 3 and 4 are added with sum 7       
     * 7 is divided by 5 with 1 the result of integer division
     * The value displayed is 1
     ***********************************************************/
    System.out.println((a + b) / c);   
    
	
	
    /**********************************************************
     * Because division has higher precedence, 4 is divided by 5 with 0 the result of integer division       
     * 3 is added to 0 with sum 3
     *  The value displayed is 3
     ***********************************************************/
    System.out.println(a + b / c);       
    
	
	
	/********************************************
	* The increment operator (++) increases the value of the given variable by 1
	* 1 is added to the existing value for a (3 + 1)
	* The value displayed is 4
	*********************************************/
    System.out.println(++a);       
	
	
	
	/****************************************************
	* The decrement operator (--) decreases the value of the given variable by 1
	* 1 is subtracted from the existing value for a (4 - 1)
	* The value displayed is 3
	****************************************************/
    System.out.println(--a);
	
	
	
	/********************************************
	* The increment operator (++) increases the value of the given variable by 1
	* However, the existing value for a is printed before adding 1
	* The value displayed is 3
	*********************************************/
    System.out.println(a++);       
	
	
	
	/********************************************
	* The decrement operator (--) decreases the value of the given variable by 1
	* However, the existing value for a is printed before subtracting 1
	* The value displayed is 4
	*********************************************/
    System.out.println(a--);
	
	
	
	/********************************************
	* The addition operator (+) adds a second value to the existing variable value
	* However, the existing value for a is printed before adding 1
	* The value displayed is 4
	*********************************************/
    System.out.println(a + 1);    



	/********************************************
	* The modulus operator (%) gives the remainder after dividing first value by second
	* 17 is divided by 5, giving 3 with a remainder of 2
	* The value displayed is 2
	*********************************************/
    System.out.println(d % c);     



	/********************************************
	* The division operator (/) divides the first value by second, ignoring remainder
	* 17 is divided by 5, giving 3 with a remainder of 2
	* The value displayed is 3
	*********************************************/
    System.out.println(d / c);



	/********************************************
	* The modulus operator (%) gives the remainder after dividing first value by second
	* 17 is divided by 4, giving 4 with a remainder of 1
	* The value displayed is 1
	*********************************************/
    System.out.println(d % b);       
	
	
	
	/********************************************
	* The division operator (/) divides first value by second value, ignoring remainder
	* 17 is divided by 4, giving 4 with a remainder of 1
	* The value displayed is 4
	*********************************************/
    System.out.println(d / b);       
	
	
	
	/********************************************
	* The division operator (/) is given precedence, a/d = 0
	* d and b are added to 0, 0 + 17 + 4 
	* The value displayed is 21
	*********************************************/	
    System.out.println(d + a / d + b);       
	
	
	
	
	/********************************************
	* The parentheses are given precedence (d + a) is done and (d+b)
	* d+a=23, d+b=21, 23/21=0 
	* The value displayed is 0
	*********************************************/
    System.out.println((d + a) / (d + b));  



	/********************************************
	* Square root of b is square root of 4
	* Sqrt(4) = 2
	* The value displayed is 2
	*********************************************/
    System.out.println(Math.sqrt(b));   


	
	/********************************************
	* The math.pow operator performs an exponent operator
	* 3^4 = 81
	* The value displayed is 81.
	*********************************************/
    System.out.println(Math.pow(a, b));  


	
	/********************************************
	* The absolute value of a negative number is positive
	* Absolute value of -a = absolute value of -3
	* The value displayed is 3
	*********************************************/
    System.out.println(Math.abs(-a));
	
	
	
	/********************************************
	* Math.max gives the larger number between the two choices
	* 4 is larger than 3
	* The value displayed is 4
	*********************************************/
    System.out.println(Math.max(a, b));    
  } 
} 
