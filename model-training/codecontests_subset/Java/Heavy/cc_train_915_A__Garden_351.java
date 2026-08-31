import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumSum function below

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int arr[]=new int[a];
        for(int i=0;i<a;i++)
            arr[i]=scanner.nextInt();
        Arrays.sort(arr);
        int max=0;
        for(int i:arr){
            if(b%i==0){
                if(max>b/i||(max==0)){
                    max=b/i;
                }
            }
        }
        System.out.println(max);
    }
}
