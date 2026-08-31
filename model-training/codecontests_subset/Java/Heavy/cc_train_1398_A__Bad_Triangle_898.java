import java.util.*;
import java.io.*;
 
public class Solution{
	static PrintWriter out=new PrintWriter(System.out);
	public static void main (String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] input=br.readLine().trim().split(" ");
		
		int numTestCases=Integer.parseInt(input[0]);
		while(numTestCases-->0){
		    input=br.readLine().trim().split(" ");
		    int n=Integer.parseInt(input[0]);
    		int[] arr=new int[n];
    		input=br.readLine().trim().split(" ");
    		for(int i=0;i<n;i++){
    		    arr[i]=Integer.parseInt(input[i]);
    		}
    		printIndices(arr);
		}
		
		out.flush();
		out.close();
	}	
	public static void printIndices(int[] arr)
	{
	    int n=arr.length;
	    int a=arr[0];
	    int b=arr[1];
	    int c=arr[n-1];
	    if(a+b<=c)
	    {
	        out.println("1 2 "+(n));
	    }
	    else{
	        out.println(-1);
	    }
	}
	
	
	
	
}