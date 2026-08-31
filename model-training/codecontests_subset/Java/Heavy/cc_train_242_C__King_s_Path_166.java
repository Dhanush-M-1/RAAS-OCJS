/*
 * Remember a 7.0 student can know more than a 10.0 student.
 * Grades don't determine intelligence, they test obedience. 
 * I Never Give Up.
 */
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.text.*;

import static java.lang.System.out;
import static java.util.Arrays.*;
import static java.lang.Math.*;
public class ContestMain {
	private static Reader in=new Reader();
	private static StringBuilder ans=new StringBuilder();
	private static long MOD=1000000007;//10^9+7 
	private static final int N=100000+7; //10^5
//	private static final int LIM=26;
//	private static final double PI=3.1415;
//	private static ArrayList<Integer> v[]=new ArrayList[N];
//	private static int color[]=new int[N];
//	private static boolean mark[]=new boolean[N];
//	private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//	private static void dfs(int node){mark[node]=true;for(int x:v[node]){if(!mark[x]){dfs(x);}}}
	private static long powmod(long x,long n,long m){
		if(n==0)return 1;
		else if(n%2==0)return(powmod((x*x)%m,n/2,m));
		else return (x*(powmod((x*x)%m,(n-1)/2,m)))%m;
	}
//	private static void shuffle(long [] arr) {
//		for (int i = arr.length - 1; i >= 2; i--) {
//			int x = new Random().nextInt(i - 1);
//	        long temp = arr[x];
//	        arr[x] = arr[i];
//	        arr[i] = temp;
//	    }
//	 }
	private static long gcd(long a, long b){
		if(b==0)return a;
		return gcd(b,a%b);
	}
//	private static boolean check(int x,int y){
//		if((x>=0&&x<n)&&(y>=0&&y<m)&&mat[x][y]!='X'&&!visited[x][y])return true;
//		return false;
//	}
	static class Node{
		int x,y,c;
		Node(int x,int y,int c){
			this.x=x;
			this.y=y;
			this.c=c;
		}
	}
	public static void main(String[] args) throws IOException{
		int sx=in.nextInt();
		int sy=in.nextInt();
		int ex=in.nextInt();
		int ey=in.nextInt();
		int n=in.nextInt();
		HashSet<String> set=new HashSet();
		int r,a,b;
		while(n-->0){
			r=in.nextInt();
			a=in.nextInt();
			b=in.nextInt();
			for(int i=a;i<=b;i++)
				set.add(r+""+i);
		}
		Queue<Node> queue=new LinkedList();
		queue.add(new Node(sx,sy,0));
		Node temp,node;
		int lim=1000000000;
		set.remove(sx+""+sy);
		while(!queue.isEmpty()){
			temp=queue.poll();
			if(temp.x==ex&&temp.y==ey){
				out.println(temp.c);
				return;
			}
			if(temp.x+1<=lim&&set.contains((temp.x+1)+""+temp.y)){
				set.remove((temp.x+1)+""+temp.y);
				node=new Node(temp.x+1,temp.y,temp.c+1);
				queue.add(node);
			}
			if(temp.x-1>=1&&set.contains((temp.x-1)+""+temp.y)){
				set.remove(set.contains((temp.x+1)+""+temp.y));
				node=new Node(temp.x-1,temp.y,temp.c+1);
				queue.add(node);
			}
			if(temp.y+1<=lim&&set.contains(temp.x+""+(temp.y+1))){
				set.remove(temp.x+""+(temp.y+1));
				node=new Node(temp.x,temp.y+1,temp.c+1);
				queue.add(node);
			}
			if(temp.y-1>=1&&set.contains(temp.x+""+(temp.y-1))){
				set.remove(temp.x+""+(temp.y-1));
				node=new Node(temp.x,temp.y-1,temp.c+1);
				queue.add(node);
			}
			if(temp.x-1>=1&&temp.y-1>=1&&set.contains((temp.x-1)+""+(temp.y-1))){
				set.remove((temp.x-1)+""+(temp.y-1));
				node=new Node(temp.x-1,temp.y-1,temp.c+1);
				queue.add(node);
			}
			if(temp.x-1>=1&&temp.y+1<=lim&&set.contains((temp.x-1)+""+(temp.y+1))){
				set.remove((temp.x-1)+""+(temp.y+1));
				node=new Node(temp.x-1,temp.y+1,temp.c+1);
				queue.add(node);
			}
			if(temp.x+1<=lim&&temp.y-1>=1&&set.contains((temp.x+1)+""+(temp.y-1))){
				set.remove((temp.x+1)+""+(temp.y-1));
				node=new Node(temp.x+1,temp.y-1,temp.c+1);
				queue.add(node);
			}
			if(temp.x+1<=lim&&temp.y+1<=lim&&set.contains((temp.x+1)+""+(temp.y+1))){
				set.remove((temp.x+1)+""+(temp.y+1));
				node=new Node(temp.x+1,temp.y+1,temp.c+1);
				queue.add(node);
			}
		}
		out.println(-1);
	}
	static class Pair<T> implements Comparable<Pair>{
		int l;
		int r;
		Pair(){
			l=0;
			r=0;
		}
		Pair(int k,int v){
			l=k;
			r=v;
		}
		@Override
		public int compareTo(Pair o) {
			if(o.l!=l)return (int) (l-o.l);
			else return (r-o.r);
		}
		
	}
	static class Reader{
        BufferedReader br;
        StringTokenizer st;
        public Reader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
     
                	st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}