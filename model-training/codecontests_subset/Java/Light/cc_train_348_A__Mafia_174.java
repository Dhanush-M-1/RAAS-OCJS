import java.util.*;
import java.io.*;

public class Mafia{
	public static void main(String[]args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		String[] g = in.readLine().split(" ");
		long total = 0;
		long max = 0;
		for(int i=0; i<n; i++) {
			long temp = Long.parseLong(g[i]);
			total+=temp;
			if(max<temp) max = temp;
		}
		long ans = (long) Math.ceil(total/(n-1.0));
		System.out.println(Math.max(ans,max));
	}
}