// Gurumanpreet Singh
import java.util.*;

public class Citizens {
    private static final Scanner scanner = new Scanner(System.in);
    int numOfCitizens;
    int[] rank;
    int[] parent;

    public Citizens(int n){
        rank = new int[n];
        parent = new int[n];
        this.numOfCitizens = n;
        MakeSet();
    }
    // Please use these methods to take inputs and write outputs.
    private static Integer readInt() {
        return scanner.nextInt();
    }

    private static String readString() {
        return scanner.next();
    }

    private static Integer[] readIntegerArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = readInt();
        }
        return array;
    }

    private static void printInt(int a) {
        System.out.println(a);
    }

    private static void printString(String s) {
        System.out.println(s);
    }
    int FindSet (int x){
        if (x != parent[x]){
            parent[x] = FindSet(parent[x]);
        }
        return parent[x];
    }

    void MakeSet(){
        for (int i=0; i<numOfCitizens; i++){
            parent[i] = i;
        }
    }
    //union the set that contains x and the set that contains y
    void Union(int x, int y){
        //find the root of each set
        int rootOfx = FindSet(x);
        int rootOfy = FindSet(y);

        //if both elements are already in the same set, do nothing
        if(rootOfx == rootOfy){
            return;
        }else if(rank[rootOfx] < rank[rootOfy]){
            parent[rootOfx] = rootOfy;
        }else if(rank[rootOfx] > rank[rootOfy]) {
            parent[rootOfy] = rootOfx;
        }else if (rank[rootOfx] == rank[rootOfy]) {
            parent[rootOfy] = rootOfx;
            rank[rootOfx] = rank[rootOfx] + 1;
        }
    }

    public static void main(String[] args) {
        Integer numLines = readInt();
        Integer numOfCitizens = readInt();
        Citizens byteLand = new Citizens(numOfCitizens);
        for (int i=0; i<numLines; i++){
            Integer[] input = readIntegerArray(3);
            if(input[0] == 0) {
                byteLand.Union(input[1], input[2]);
            }else if(input[0]==1){
                if(byteLand.FindSet(input[1]) == byteLand.FindSet(input[2])){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }
            }
        }
    }
}