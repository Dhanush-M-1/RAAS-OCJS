import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String []arg) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();



       int [] a = new int[n];

       for(int i = 0; i < n; ++ i) {
           a[i] = sc.nextInt();
       }

       int []arr = new int [11];

       for(int i =0; i < a.length;++i) {
           ++arr[a[i]];
       }


       int sum =0;
       int r = 0;
       for(int i = arr.length-1; i>=0; --i) {
           r+=arr[i]*sum;
           sum+=arr[i];
       }

       System.out.println(r);






    }

}