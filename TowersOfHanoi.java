import java.util.*;

class TowersOfHanoi 
{ 
    // Java recursive function to solve tower of hanoi puzzle 
   /* static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) 
    { 
        if (n == 1) 
        { 
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod); 
            return; 
        } 
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod); 
        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod); 
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod); 
    } 
      
    //  Driver method 
    public static void main(String args[]) 
    { 
        Scanner input = new Scanner(System.in);
		System.out.println("How many rings do you want?");
		int n = input.nextInt();
		//int n = 4; // Number of disks 
        towerOfHanoi(n, 'A', 'C', 'B');  // A, B and C are names of rods 
    } 
	*/
	
	 public void solve(int n, String start, String auxiliary, String end) {
       if (n == 1) {
           System.out.println(start + " -> " + end);
       } else {
           solve(n - 1, start, end, auxiliary);
           System.out.println(start + " -> " + end);
           solve(n - 1, auxiliary, start, end);
       }
   }

   public static void main(String[] args) {
       TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
       System.out.print("Enter number of discs: ");
       Scanner scanner = new Scanner(System.in);
       int discs = scanner.nextInt();
       towersOfHanoi.solve(discs, "A", "B", "C");
   }
} 

