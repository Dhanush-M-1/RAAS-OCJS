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
			
			out.println(minSteps(n));
		}
		out.flush();
		out.close();
	}		
	public static long minSteps(int n)
	{
		int num2s=0;
		int num3s=0;
		while(n%2==0) {
			n/=2;
			num2s++;
		}
		while(n%3==0)
		{
			n/=3;
			num3s++;
		}
		
		if(n>1) {
			return -1;
		}
		
		if(num2s>num3s)
		{
			return -1;
		}
		
		long ans=(num3s-num2s)+(num3s);
		return ans;
	}
}