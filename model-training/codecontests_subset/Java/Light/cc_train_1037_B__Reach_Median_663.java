/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        
        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(input2[i]);
        }
        
        Arrays.sort(arr);

        int medianIndex = n/2;
        long ans = 0;
    
        if(arr[medianIndex] < s){
            while(medianIndex<n && arr[medianIndex] < s){
                ans+= s-arr[medianIndex];
                medianIndex++;
            }
            
            // System.out.println(ans);
        }
        else if(arr[medianIndex] > s){
            while(medianIndex >=0 && arr[medianIndex] > s){
                ans+=arr[medianIndex] - s;
                medianIndex--;
            }
            
            
        }
        
        System.out.println(ans);
    }
}
