import java.io.*;
import java.util.*;

public class kstring {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		long k=in.nextLong();
		int[] f=new int[26];
		String s=in.next();
		for(int i=0; i<s.length(); i++) {
			f[s.charAt(i)-'a']++;
		}
		for(int i=0; i<26; i++) {
			if(f[i]%k!=0) {
				System.out.println(-1);
				return;
			}
		}
		
		String p="";
		for(int j=0; j<26; j++) {
			for(int l=0; l<f[j]/k; l++)
				p+=(char)(j+'a');
		}
		for(int i=0; i<k; i++)
			System.out.print(p);
		System.out.println();
	}
	
	static class MyScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String next() {
			while(st==null||!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}