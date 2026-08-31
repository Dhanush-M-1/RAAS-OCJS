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
		if(n<3)
			ans = n;
		else if(n%2==0){
			if(n%3==0)
				ans = (long)(n-1)*(n-2)*(n-3);
			else
				ans = (long)n*(n-1)*(n-3);
		}
		else
			ans = (long)n*(n-1)*(n-2);

		pw.print(ans);
		pw.flush();
		pw.close();
	}
}