import java.util.*;

public class Lab7 {
    public static void main(String[] args) {
        // variable declarations for part 1
        String title;
        String firstName;
        String lastName;
        Scanner in = new Scanner(System.in);

        // prompt for input for part 1
        System.out.print("Enter a title:");
        title = in.next();
        System.out.print("Enter your first name:");
        firstName = in.next();
        System.out.print("Enter a your last name:");
        lastName = in.next();

        // call the method for part 1
        greeting(title, firstName, lastName);

        // variable declarations for part 2
        int number1;
        int number2;

        // user prompts for part 2
        System.out.print("Enter first number:");
        number1 = in.nextInt();
        System.out.print("Enter second number:");
        number2 = in.nextInt();

        // call the methods max and sumTo inside the println statement
        System.out.println("The largest number is " + max(number1, number2));
        System.out.println("The sum of the numbers is " + sumTo(number1, number2));
    } // end of main method

    public static void greeting(String title, String firstName, String lastName) {
        System.out.println();
        System.out.println("Dear " + title + " " + firstName + " " + lastName + ",");
        System.out.println();
    }

    public static int max(int number1, int number2) {
        if (number1 > number2) {
            return number1;
        } else if (number2 > number1) {
            //System.out.println(number2);
            return number2;
        } else {
            Random random = new Random();
            boolean check = random.nextBoolean();
            if (check = true) return number1;
            else return number2;
        }
    }

    public static int sumTo(int number1, int number2) {
        if (number1 > number2) {
            int sum = 0;
            for (int count=number2; count <= number1; count++) {
                sum += count;
                return count;
            }
        }

        if (number2 > number1) {
            int sum = 0;
            for (int count=number1; count <= number2; count++) {
                sum += count;
                return count;
            }
        }
        return number1;
    }

}
