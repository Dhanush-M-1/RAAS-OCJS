import java.io.*;
import java.math.*;
import java.util.*;


public class Main {

	public static class pair implements Comparable<pair>
	{
		int a;
		int b;
		public pair(int pa, int pb)
		{
			a = pa; b= pb;
		}
		@Override
		public int compareTo(pair o) {
			if(this.a < o.a)
				return -1;
			if(this.a > o.a)
				return 1;
			return Integer.compare(o.b, this.b);
		}
	}


	//int n = Integer.parseInt(in.readLine());
	//int n = Integer.parseInt(spl[0]);
	//String[] spl = in.readLine().split(" ");
	
	public static void main (String[] args) throws Exception
	{	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		boolean[] plat = new boolean[n];
		String s = in.readLine();
		for (int i = 0; i < n; i++) {
			if(s.charAt(i)=='*')
				plat[i]=true;
		}
		boolean found = false;
		for (int i = 0; i < n && !found; i++) {
			a: for (int j = i+1; j < n && !found; j++) {
				if(!plat[i] || !plat[j])
					continue;
				int diff = j-i;
				int cur = j;
				for (int k = 0; k < 3; k++) {
					if(cur + diff >= n || !plat[cur+diff])
						continue a;
					cur = cur + diff;
				}
				found = true;
			}
		}
		if(found)
			System.out.println("yes");
		else System.out.println("no");
	}

}