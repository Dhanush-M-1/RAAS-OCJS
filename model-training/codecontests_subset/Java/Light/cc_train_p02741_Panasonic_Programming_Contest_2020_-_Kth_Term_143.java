import java.util.*;


public class Main {
    public static void main(String[] args){

        int[] term = {1, 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14, 1, 5, 1, 5, 2, 2, 1, 15, 2, 2, 5, 4, 1, 4, 1, 51};

        Scanner s = new Scanner(System.in);
        
        int a = s.nextInt();

        System.out.println(term[a-1]);
    }
}