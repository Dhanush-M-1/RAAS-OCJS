import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long s = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long[] a = new long[n];
		for(int i=0;i<n;i++) {
			a[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(a);
		int k = (n/2);
		long cost = 0;
		cost+=Math.abs(a[k]-s);
		for(int i=k+1;i<n;i++) {
			if(a[i]<s) {
				cost+=s-a[i];
			}
			else {
				break;
			}
		}
		for(int i=k-1;i>=0;i--) {
			if(a[i]>s) {
				cost+=a[i]-s;
			}
			else {
				break;
			}
		}
		System.out.println(cost);
		br.close();
	}
}