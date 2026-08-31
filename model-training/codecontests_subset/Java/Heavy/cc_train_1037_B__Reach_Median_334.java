import java.util.*;
import java.io.*;
public class Codefest18B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        long median = sc.nextInt();

        long arr[] = new long[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = arr[i] - median;
        }
        int mid = n / 2;
        int i = mid+1;
        long right = 0;
        long left = 0;
        while(i < n && arr[i]<0){
            right += Math.abs(arr[i++]);
        }
        i = mid-1;
        while(i>=0 && arr[i] > 0){
            left += arr[i--];
        }
       // pw.println(left+" "+right);
pw.println(left+right+Math.abs(arr[mid]));
        pw.close();
    }
}