import java.util.*;
import java.io.*;
 
public class Solution{
	static PrintWriter out=new PrintWriter(System.out);
	public static void main (String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] input=br.readLine().trim().split(" ");
		
		int numTestCases=Integer.parseInt(input[0]);
		while(numTestCases-->0) {
			input=br.readLine().trim().split(" ");
			int n=Integer.parseInt(input[0]);
			int m=Integer.parseInt(input[1]);
			int[] arr1=new int[n];
			input=br.readLine().trim().split(" ");
			for(int i=0;i<n;i++) {
				arr1[i]=Integer.parseInt(input[i]);
			}
			
			int[] arr2=new int[m];
			input=br.readLine().trim().split(" ");
			for(int i=0;i<m;i++) {
				arr2[i]=Integer.parseInt(input[i]);
			}
			printArray(arr1,arr2);
		}
		out.flush();
		out.close();
	}	
	public static void printArray(int[]arr1,int[] arr2)
	{
		int n=arr1.length;
		int m=arr2.length;
		HashMap<Integer,Boolean> hash=new HashMap<>();
		for(int i=0;i<n;i++) {
			hash.put(arr1[i], true);
		}
		for(int i=0;i<m;i++) {
			if(hash.containsKey(arr2[i]))
			{
				out.println("YES");
				out.println("1 "+arr2[i]);
				return;
			}
		}
		out.println("NO");
	}
}