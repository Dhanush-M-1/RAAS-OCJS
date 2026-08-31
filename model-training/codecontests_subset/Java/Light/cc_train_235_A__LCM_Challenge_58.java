//https://codeforces.com/problemset/problem/235/A
//A. LCM Challenge
import java.util.*;
import java.io.*;
public class LCM_Challenge{
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine().trim());

		long ans = 0;
		if(n==1)
			ans = 1;
		else if(n==2)
			ans = 2;
		else if (n==3)
			ans = 3*2;
		else if(n%2==0){
			if(n%3==0)
				ans = Math.max(((long)n*(n-1)*(n-2))/2,((long)n*(n-1)*(n-3))/3);
			else
				ans = (long)n*(n-1)*(n-3);
			ans = Math.max((long)(n-1)*(n-2)*(n-3),ans);
		}
		else
			ans = (long)n*(n-1)*(n-2);

		pw.print(ans);
		pw.flush();
		pw.close();
	}
}