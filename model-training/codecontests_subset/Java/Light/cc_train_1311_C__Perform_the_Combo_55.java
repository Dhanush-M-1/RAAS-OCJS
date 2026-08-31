import java.io.*;
import java.util.*;

public class TestClass {

	static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) throws IOException{
 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for(int i=0;i<t;i++) {
			String s[] = in.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			String str = in.readLine();
			String s2[] = in.readLine().split(" ");
			int a[] = new int[m];
			int cnt[] = new int[n];
			for(int j=0;j<m;j++) {
				a[j] = Integer.parseInt(s2[j])-1;
				cnt[a[j]]++;
			}
			for(int j=n-2;j>=0;j--) {
				cnt[j] = cnt[j] + cnt[j+1];
			}
			for(int j=0;j<n;j++) {
				cnt[j]++;
			}
			int ans[] = new int[26];
			for(int j=0;j<n;j++) {
				int c = str.charAt(j)-'a';
				ans[c] += cnt[j];
			}
			for(int j=0;j<26;j++) {
				out.print(ans[j]+" ");
			}
			out.println();
		}
		
		
        out.close();
	}
}