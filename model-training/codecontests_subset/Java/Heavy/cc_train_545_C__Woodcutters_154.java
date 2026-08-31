import java.util.*;
import java.io.*;
import java.lang.*;
import java.lang.Math;

public class C{
	public static class tree implements Comparable<tree>{
		public int x,h;
		public tree(int tx,int th){
			this.x=tx; this.h=th;
		}
		@Override
		public int compareTo(tree T) {
			if (this.x==T.x)
				return 0;
			return (this.x-T.x);
		}
	};
	static tree []a;
	static int n,res;
	static int u[],v[];
	public static void main(String[] args)throws Exception{
		n=reader.nextInt(); a=new tree[n];
		if (n<=2){
			System.out.println(n);
			System.exit(0);
		}
		int i,j,L,R;
		for (i=0;i<n;i++)
			a[i]=new tree(reader.nextInt(),reader.nextInt());
		Arrays.sort(a);
		res=0;
		u=new int[n];		v=new int[n];
		for (i=0;i<n;i++){
			u[i]=a[i].x;
			v[i]=a[i].x;
//			System.out.println(a[i].x+" "+a[i].h);
		}
		
		L=Integer.MIN_VALUE;

	//	System.out.println(L);
		for (i=0;i<n;i++){
			if (L<(a[i].x - a[i].h)){
				res++;
				v[i]=a[i].x - a[i].h;
			}
			L=a[i].x;
		}
		R=Integer.MAX_VALUE;
		for (j=n-1;j>=0;j--){
			if ((a[j].h+a[j].x)<R){
				if (v[j]==u[j]) res++;
				v[j]=a[j].x;
			}
			R=Math.min(v[j],R);
		}
		System.out.print(res);
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
