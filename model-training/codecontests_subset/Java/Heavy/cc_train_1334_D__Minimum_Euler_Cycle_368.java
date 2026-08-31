
import java.util.*;
import java.io.*;

public class MinimumEulerCycle {

	// https://codeforces.com/contest/1334/problem/D
	
	// WRONg
	public static void main(String[] args) throws IOException, FileNotFoundException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader in = new BufferedReader(new FileReader("MinimumEulerCycle"));

		int t = Integer.parseInt(in.readLine());
		while (t --> 0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			long n = Integer.parseInt(st.nextToken());
			long l = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			long curnum = 1;
			long cursum=1;
			while (cursum + (n-curnum)*2 < l) {
				cursum += (n-curnum)*2;
				curnum++;
			}
			
			StringBuilder sb = new StringBuilder();
			while (cursum <= r) {
				if (cursum == n*(n-1)+1) break;
				for (long i=curnum+1; i<=n; i++) {
					if (cursum >= l && cursum <= r) {
						sb.append(curnum + " ");
					}
					cursum++;
					if (cursum >= l && cursum <= r) {
						sb.append(i + " ");
					}
					cursum++;
				}
				curnum++;
			}
			if (cursum <= r) sb.append("1 ");
			
			System.out.println(sb);
		}
	}
}