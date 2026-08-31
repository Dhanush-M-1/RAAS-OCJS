/*
 * Remember a 7.0 student can know more than a 9.8 student.
 * Grades don't determine intelligence, they test obedience. 
 * I Never Give Up.
 */
import java.util.*;
import java.io.*;
import java.util.Comparator.*;
 
import static java.lang.System.out;
import static java.util.Arrays.sort;
import static java.lang.Math.pow;
//import static java.lang.Math.sqrt;
//import static java.lang.Math.ceil;
//import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.max;
//import static java.lang.Math.floor;
public class ContestMain {
	private static long MOD=1000000007;//10^9+7 
	private static final int N=(int)200005;
//	private static ArrayList<Integer> v[]=new ArrayList[N];
//	private static long color[]=new long[2]; //For Graph Coloring
//	private static boolean mark[]=new boolean [N];
//	static int choice=Integer.MAX_VALUE,trav=Integer.MAX_VALUE;
//	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//	public static void dfs(int node){mark[node]=true;for(int x:v[node]){if(!mark[x]){dfs(x);}}}
	static Reader in=new Reader();
	public static void solve(long ar[],int n,long d){
		long maxv=Long.MIN_VALUE,curr=0;
		int cnt=0;
		int i=0,ind=0;
		LinkedList<Integer> ll=new LinkedList();
		long dept[]=new long[n];
		for(i=0;i<n;i++){
			if(ar[i]>maxv)maxv=ar[i];
			if(ar[i]==0&&curr<0){
				if(ll.isEmpty()){
					ll.add(i);
					curr=0;
					cnt++;
				}
				else if(dept[ll.peek()]+(-curr)<=d&&-curr+maxv<=d){
					dept[ll.peek()]+=-curr;
					curr=0;
				}
				else{
					ll.addFirst(i);
					curr=0;
					maxv=Long.MIN_VALUE;
					cnt++;
				}
			}
			else{
				curr+=ar[i];
				if(curr>d)break;
			}
		}
		if(i<n)out.println(-1);
		else out.println(cnt);
	}
	
	public static void main(String[] args) throws IOException{
		int n=in.nextInt();
		long d=in.nextLong();
		long ar[]=new long[n];
		for(int i=0;i<n;i++)
			ar[i]=in.nextLong();
		solve(ar,n,d);
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