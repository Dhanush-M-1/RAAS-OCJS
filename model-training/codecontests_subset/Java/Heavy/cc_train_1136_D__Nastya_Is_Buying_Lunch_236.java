//http://codeforces.com/contest/1136/problem/D

import java.util.*;
import java.io.*;

public class Lunch{
	static ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>();
	static int vis[]=new int[300002];
	static int ara[]=new int[300002];
	public static void main(String args[])
	{
		TreeSet<Integer> b=new TreeSet<Integer>();
		Reader rd=new Reader();
		int n=rd.nextInt();
		int m=rd.nextInt();
		Arrays.fill(vis,0);
		for(int i=0;i<=n;i++){
			a.add(new ArrayList<Integer>());
		}
		for(int i=1;i<=n;i++){
			ara[i]=rd.nextInt();
		}
		for(int i=1;i<=m;i++){
			int x=rd.nextInt();
			int y=rd.nextInt();
			a.get(x).add(y);
			if(y==ara[n]) vis[x]=1;
		}
		for(int i=1;i<=n;i++){
			if(a.get(i).isEmpty()==false){
				Collections.sort(a.get(i));
			}
		}
		int cnt=0;
		for(int i=n-1;i>=1;i--){
			if(vis[ara[i]]==0){
				b.add(ara[i]);
			}
			else{
				boolean ck=false;
				Iterator<Integer> it = b.iterator();
				int j=0;
				int y=-1;
				while(it.hasNext()){
					int x=it.next();
					while(j<a.get(ara[i]).size() && y<x){
						y=a.get(ara[i]).get(j);
						j++;
					}
					//rd.pf(x+" "+y+"\n");
					if(y!=x){
						ck=true;
						break;
					}
				}
				if(ck){
					if(!b.isEmpty()){
						b.add(ara[i]);
					}
				}
				else{
					cnt++;
				}
			}
		}
		rd.pf(cnt);
	}
	static class Reader {
		static BufferedReader br;
		static StringTokenizer st;
		public Reader() {
			this.br = new BufferedReader(new InputStreamReader(System.in));
		}
		public int[] na(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}
		public int nextInt() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return Integer.parseInt(st.nextToken());
		}
		public double nextDouble() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return Double.parseDouble(st.nextToken());
		}
		public Long nextLong() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return Long.parseLong(st.nextToken());
		}
		public String next() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return st.nextToken();
		}
		public String nextLine() {
			String s="";
			try{
				s=br.readLine();
			}catch(Exception e){}
			return s;
		}
		public void pf(Object p)
		{
			System.out.print(p);
		}
		private static void readLine() {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
			}
		}
	}
}