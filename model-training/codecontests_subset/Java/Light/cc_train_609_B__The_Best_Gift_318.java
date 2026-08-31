import java.lang.*;
import java.util.*;
public class Main {
    public static int[] n;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        long[] genres = new long[m+1];
        for(int i=0; i<n; i++){
            genres[sc.nextInt()]++;
        }
        long count=0;
        for(int i=1; i<m+1; i++){
           for(int j=i+1; j<m+1; j++) {
               count+=(genres[i]*genres[j]);
           }
        }
        System.out.println(count);
    }
}