import java.util.*;
import java.io.*;
import java.lang.*;

public class B{
	
	static String a,b,c;
	static int A[],B[],C[]; static StringBuilder res;
	static void MainMethod()throws Exception{
		a=reader.readNextLine();
		b=reader.readNextLine();
		c=reader.readNextLine();
		A=new int[256];B=new int[256];C=new int[256];
		Arrays.fill(A, 0);Arrays.fill(B, 0);Arrays.fill(C, 0);
		int i,j,u,v,x,y;
		for (i=0;i<a.length();i++)A[a.charAt(i)]++;
		for (i=0;i<b.length();i++)B[b.charAt(i)]++;
		for (i=0;i<c.length();i++)C[c.charAt(i)]++;
		u=0; v=0; boolean ok; x=0;y=0;
		for (x=0;x<=(a.length()/b.length());x++){
			ok=true;
			y=(a.length()-(b.length()*x))/c.length();
			for (j='a';j<='z';j++){
				if ((B[j]*x)>A[j]){
					ok=false;
				}
				if (C[j]>0){
					y=Math.min(y, (A[j]-(B[j]*x))/C[j]);
				}
			}
			if (ok==true){
				if ((x+y)>(u+v)){
					u=x; v=y;
				}
			}
		}
		res=new StringBuilder("");
		for (i=0;i<u;i++)res.append(b);
		for (i=0;i<v;i++)res.append(c);
		for (i='a';i<='z';i++) {
			A[i]-=((B[i]*u)+(C[i]*v));
			for (j=0;j<A[i];j++)res.append((char)i);
		}
		
		printer.println(res);
	}
	public static void main(String[] args)throws Exception{
		MainMethod();
		printer.close();
	}
	static void halt(){
		printer.close();
		System.exit(0);
	}
	static PrintWriter printer=new PrintWriter(new OutputStreamWriter(System.out));
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
