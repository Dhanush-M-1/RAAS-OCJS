import java.io.*;
import java.util.*;

public class Div2_350_B {
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(bis));
		PrintWriter out = new PrintWriter(System.out);
		String line;
		StringTokenizer st;
		while ((line = br.readLine()) != null && !line.equals("")) {
			st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int [] IDs = new int[n];
			for (int i = 0; i < IDs.length; i++) {
				IDs[i] = Integer.parseInt(st.nextToken());
			}
			long start = 1, last = 1000000001, mid;
			while(start < last) {
				mid = (start+last+1)/2;
				long num = 1+(mid*1l*(mid-1)/2);
				if(num > k)
					last = mid-1;
				else if(num <= k)
					start = mid;
			}
			int ans = (int)(k-start*1l*(start-1)/2-1);
			out.println(IDs[ans]);
		}
		out.close();
	}
}