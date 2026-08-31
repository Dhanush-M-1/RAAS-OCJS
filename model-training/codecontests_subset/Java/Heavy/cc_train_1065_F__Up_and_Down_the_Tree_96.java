/*
 ID: tommatt1
 LANG: JAVA
 TASK: 
*/
//JMJ+
import java.util.*;
import java.io.*;
public class cf1065f {
static int[] dp,add,h;
static ArrayList<Integer>[] adj;
static int k;
	public static void main(String[] args)throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(bf.readLine());
		dp=new int[n];
		add=new int[n];
		h=new int[n];
		Arrays.fill(h, (int)Math.pow(10, 9));
		adj=new ArrayList[n];
		for(int i=0;i<n;i++) {
			adj[i]=new ArrayList<Integer>();
		}
		for(int i=1;i<n;i++) {
			int a1=Integer.parseInt(st.nextToken())-1;
			adj[a1].add(i);
		}
		LinkedList<Integer> dfs=new LinkedList<>();
		dfs.add(0);
		int back=-1;
		while(!dfs.isEmpty()) {
			int cur=dfs.getLast();
			if(back!=-1) {
			h[cur]=Math.min(h[cur], h[back]+1);
			add[cur]+=add[back];
			dp[cur]=Math.max(dp[cur], dp[back]-add[back]);
			}
			if(!adj[cur].isEmpty()) {
				dfs.add(adj[cur].remove(adj[cur].size()-1));
				back=-1;
				continue;
			}
			dp[cur]+=add[cur];
			if(h[cur]==(int)Math.pow(10, 9)) {
				h[cur]=0;
				dp[cur]=add[cur]=1;
			}
			if(h[cur]>=k) {
				add[cur]=0;
			}
			back=dfs.removeLast();
		}
		out.println(dp[0]);
		out.close();
	}
	
}
