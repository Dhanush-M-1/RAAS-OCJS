/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader*/
import java.io.*;
import java.io.InputStreamReader;
import java.util.Vector;



// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

   public class TestClassFinal { 
	   
	   public static void main(String args[] ) throws Exception {
 
    	BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
     
        int n,k, ai,bucket=0;
        String [] arr =sc.readLine().split(" ");   
        n=Integer.parseInt(arr[0]);   
        k=Integer.parseInt(arr[1]);//length of the garden
        arr =sc.readLine().split(" ");   
bucket=1;
        for(int i=0;i<n;i++)
        {
        	ai=Integer.parseInt(arr[i]);
        	if ((k%ai==0)&&(ai>bucket))
        		bucket=ai;
        }
        
        System.out.println(k/bucket);
        
sc.close();
    }
}
   