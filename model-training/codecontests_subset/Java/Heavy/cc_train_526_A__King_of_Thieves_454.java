import java.util.*;
import java.io.*;
import java.lang.*;
import java.lang.Math;

public class A{
	static int n; static String s;
	public static void main(String[] args)throws Exception{
		n=Integer.parseInt(reader.readNextLine());
		s=reader.readNextLine();
		int i,j,k;
		for (k=1;k<n;k++) for (i=0;i<n;i++){
			for (j=0;j<5;j++){
				if ((i+(k*j))>=n) break;
				if (s.charAt(i+(k*j))=='.') break;
			}
			if (j>=5) {
				System.out.println("yes");
				System.exit(0);
			}
		}
		System.out.println("no");
	}
	
	static class reader{
		static BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer token=new StringTokenizer("");
		static String readNextLine() throws Exception{
			return bReader.readLine();
		}
		static String next() throws Exception{
			while (token.hasMoreTokens()==false){
				token=new StringTokenizer(bReader.readLine());
			}
			return token.nextToken();
		}
		static int nextInt()throws Exception{
			while (token.hasMoreTokens()==false){
				token=new StringTokenizer(bReader.readLine());
			}
			return Integer.parseInt(token.nextToken());
		}
		static long nextLong()throws Exception{
			while (token.hasMoreTokens()==false){
				token=new StringTokenizer(bReader.readLine());
			}
			return Long.parseLong(token.nextToken());
		}
		static double nextDouble()throws Exception{
			while (token.hasMoreTokens()==false){
				token=new StringTokenizer(bReader.readLine());
			}
			return Double.parseDouble(token.nextToken());
		}
	}
}
