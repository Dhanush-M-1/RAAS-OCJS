import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SONY
 */
public class HelloWorldd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner (System.in);
        int n = input.nextInt();//number of books
        int m = input.nextInt();//number of genres
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++){
            arr.add(input.nextInt());
        }
        int [] repetition = new int [m];
        for (int k = 0; k < n; k++){
            int track = arr.get(k) -1;
            repetition[track] += 1;
        }
        long all = (long)n*(n-1)/2;
        long repeat = 0;
        for (int p = 0; p < m; p++){
            repeat += (long)repetition[p]*(repetition[p]-1)/2;
        }
        long result = all - repeat;
        System.out.print(result);
        return;
    }
}