import java.io.IOException;
import java.util.*;

public class Main{

    public static void main (String args[]) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), c = scan.nextInt();
        int arr[] = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            if(arr[i] - arr[i+1] > max)max = arr[i] - arr[i+1];
        }
        System.out.println(max-c>0?max-c:"0");
    }
}