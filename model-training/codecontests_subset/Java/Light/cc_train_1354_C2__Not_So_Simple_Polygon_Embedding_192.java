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
			
			out.println(getSide(n));
		}
		
		out.flush();
		out.close();
	}
	public static double getSide(int n)
	{
	    n*=2;
        double a=90.0/(n);
        a=a*0.0174533;
        double ans=(1.0/(2.0*Math.sin(a)));
		return ans;
	}
}