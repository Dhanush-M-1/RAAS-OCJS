import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter (new BufferedOutputStream(System.out));
        String[] z = br.readLine().split(" ");
        int n = Integer.parseInt(z[0]);
        int c = Integer.parseInt(z[1]);
        int diff = 0 ;
        int[] arr = new int[n];
        z = br.readLine().split(" ");
        arr[0] = Integer.parseInt(z[0]);
        for(int i = 1;i<n;i++){
            arr[i] = Integer.parseInt(z[i]);
        }
        for(int i = 0;i<n-1;i++){
            if(arr[i]-arr[i+1]>diff){
                diff = arr[i]-arr[i+1];
            }
        }
        diff = diff-c;
        if(diff>0){
            pw.println(diff);
        }
        else{
            pw.println(0);
        }
        pw.close();
    }
}