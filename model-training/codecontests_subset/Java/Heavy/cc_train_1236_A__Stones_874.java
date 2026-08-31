import java.util.*;
import java.io.*;
public class A {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		int n=Integer.parseInt(br.readLine());
		while(n-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int x=solve1(a,b,c);
			int y=solve2(a,b,c);
			int max=Math.max(x, y);
			pw.append(max+"\n");
			//pw.println(max);
		}
		
		pw.flush();
		br.close();
		pw.close();
	}
	public static int solve1(int a,int b,int c) {
		int max=0;
		int op=Math.min(b/2,a);
		a-=op;
		b-=op*2;
		max+=3*op;
		op=Math.min(c/2,b);
		b-=op;
		c-=op*2;
		max+=3*op;
		return max;
	}
	public static int solve2(int a,int b,int c) {
		int max=0;
		int op=Math.min(c/2,b);
		b-=op;
		c-=op*2;
		max+=3*op;
		op=Math.min(b/2,a);
		a-=op;
		b-=op*2;
		max+=3*op;
		return max;
	}
}