import java.io.*;
import java.util.*;
import java.lang.System;
public class Solution{
	static PrintStream out=System.out;
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	static Scanner sc=new Scanner(System.in);
	



	static void Task(){
		int r1=ni(); int r2=ni();
		int c1=ni(); int c2=ni();
		int d1=ni(); int d2=ni();
		int x=0,y=0,p=0,q=0;
		for(int i=1;i<10;i++){
			x=i; y=r1-x; p=c1-x; q=c2-y;
			if(d1!=x+q || d2!=y+p || r2!=p+q)continue;
			if(y>=10 || y<1 || p>=10 || p<1 || q>=10 || q<1)continue;
			if(x==y || x==p || x==q || y==p || y==q || p==q)continue;
			out.println(x+" "+y);
			out.println(p+" "+q);
			return;
		}	
		out.println("-1");
	}







	public static void main(String args[]){
		Task();
	}
	static int ni(){
		return Integer.parseInt(ns());
	}
	static long nl(){
		 return Long.parseLong(ns());
	}
	static double nd(){
		return Double.parseDouble(ns());
	}
	static String ns(){
		while (st == null || !st.hasMoreElements()){
			try{
				st = new StringTokenizer(br.readLine());
			}catch (IOException  e){
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}
	static int[] nia(int n){
		int[] arr=new int[n];
		for(int i=0;i<n;i++)arr[i]=ni();
		return arr;
	}
	static long[] nla(int n){
		long[] arr=new long[n];
		for(int i=0;i<n;i++)arr[i]=nl();
		return arr;
	}
	static String nline(){
		String str = "";
        try{
            str = br.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        return str;
	}
	static ArrayList<Integer>[] nAdjList(int n,int k){
		ArrayList<Integer>[] al=new ArrayList[n];
		for(int i=0;i<k;i++){
			al[ni()].add(ni());
		}
		return al;
	}
}