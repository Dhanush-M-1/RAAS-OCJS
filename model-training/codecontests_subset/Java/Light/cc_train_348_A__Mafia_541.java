import java.util.*;
import java.io.*;

public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(rd.readLine());
		StringTokenizer st = new StringTokenizer(rd.readLine());
		long s = 0, max = 0;
		for(int i=0; i<n; i++){
			int cur = Integer.parseInt(st.nextToken());
			s+= cur;
			max = Math.max(max, cur);
		}
		long x = s / (n-1);
		while(x*(n-1)<s) x++;
		System.out.println(Math.max(x, max));
	}

}
