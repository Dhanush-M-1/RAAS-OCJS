import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException 
	{ 
		FastScanner f = new FastScanner(); 
		int t=1;
//		t=f.nextInt();
		PrintWriter out=new PrintWriter(System.out);
		for(int tt=0;tt<t;tt++) {
			int n= f.nextInt();
			int k= f.nextInt();
			ArrayList<Integer> alice=new ArrayList<Integer>();
			ArrayList<Integer> bob=new ArrayList<Integer>();
			ArrayList<Integer> both=new ArrayList<Integer>();
			for(int i=0;i<n;i++) {
				int a=f.nextInt();
				int b=f.nextInt();
				int c=f.nextInt();
				if(b==1 && c==1) both.add(a);
				if(b==1 && c==0) alice.add(a);
				if(b==0 && c==1) bob.add(a);
			}
			Collections.sort(alice);
			Collections.sort(bob);
			Collections.sort(both);
			int[] alices=new int[alice.size()+1];
			int[] boths=new int[both.size()+1];
			int[] bobs=new int[bob.size()+1];
			for(int i=1;i<alices.length;i++) {
				alices[i]=alices[i-1]+alice.get(i-1);
			}
			for(int i=1;i<bobs.length;i++) {
				bobs[i]=bobs[i-1]+bob.get(i-1);
			}
			for(int i=1;i<boths.length;i++) {
				boths[i]=boths[i-1]+both.get(i-1);
//				System.out.println(boths[i]);
			}
			long ans=Integer.MAX_VALUE;
			for(int i=0;i<boths.length;i++) {
				int temp=boths[i];
				int rest=k-i;
				if(rest>-1 && bobs.length>rest && alices.length>rest) {
					temp+=bobs[rest];
					temp+=alices[rest];
					ans=Math.min(ans, temp);
				}
				
			}
			if(ans==Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(ans);
		}
		out.close();
	} 
	static void sort(long[] p) {
        ArrayList<Integer> q = new ArrayList<>();
        for (long i: p) q.add((int) i);
        Collections.sort(q);
        for (int i = 0; i < p.length; i++) p[i] = q.get(i);
    }
    
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		long[] readLongArray(int n) {
			long[] a=new long[n];
			for (int i=0; i<n; i++) a[i]=nextLong();
			return a;
		}
	}
} 	
//Some things to notice
//Check for the overflow
//Binary Search
//Bitmask
//runtime error most of the time is due to array index out of range