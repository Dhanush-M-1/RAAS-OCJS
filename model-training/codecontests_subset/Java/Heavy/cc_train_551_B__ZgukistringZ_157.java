import java.io.*;
import java.util.*;
public class A {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		String [] a=new String [3];
		a[0]=sc.next();
		a[1]=sc.next();
		a[2]=sc.next();
		int [][] cnt=new int [3][26];
		for(int i=0;i<3;i++)
			for(char c : a[i].toCharArray())
				cnt[i][c-'a']++;
		int xx=0;
		int yy=0;
		toto : for(int i=0;i<=a[0].length()/a[1].length();i++){
			int other=(int)1e8;
			for(int j=0;j<26;j++){
				int x=cnt[0][j]-i*cnt[1][j];
				if(x<0)
					continue toto;
				else
					if(cnt[2][j]>0)
						other=Math.min(other, x/cnt[2][j]);
			}
			if(other+i>xx+yy){
				xx=i;
				yy=other;
			}
		}
		for(int i=0;i<xx;i++)
			pw.print(a[1]);
		for(int i=0;i<yy;i++)
			pw.print(a[2]);
		for(int i=0;i<26;i++){
			cnt[0][i]-=(xx*cnt[1][i]+yy*cnt[2][i]);
			while(cnt[0][i]-->0)
				pw.print((char)('a'+i));
		}
		
		pw.flush();
		pw.close();
	}
	
	static void shuffle(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			int tmp = a[i];
			a[i] = a[r];
			a[r] = tmp;
		}
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {br = new BufferedReader(new InputStreamReader(System.in));}
		String next() {while (st == null || !st.hasMoreElements()) {
			try {st = new StringTokenizer(br.readLine());}
			catch (IOException e) {e.printStackTrace();}}
		return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine(){String str = "";
		try {str = br.readLine();}
		catch (IOException e) {e.printStackTrace();}
		return str;}
	}
}