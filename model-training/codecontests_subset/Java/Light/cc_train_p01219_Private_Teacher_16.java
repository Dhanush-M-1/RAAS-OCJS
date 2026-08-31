import java.util.*;
import static java.lang.Math.*;
public class Main {
	final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		new Main();
	}
	Main(){
		new AOJ2096();
	}
	
	class AOJ2096{
		final long INF=1<<60;
		int N;
		long W;
		AOJ2096(){
			while(true){
				N=sc.nextInt();
				W=sc.nextLong();
				if((N|W)==0)	break;
				solve();
			}
		}
		void solve(){
			HashMap<String, Integer> weeks = new HashMap<String, Integer>();
			weeks.put("Monday", 1);		weeks.put("Tuesday", 2);
			weeks.put("Wednesday", 3);	weeks.put("Thursday", 4);
			weeks.put("Friday", 5);		weeks.put("Saturday", 6);
			weeks.put("Sunday", 7);
			
			final int MAX = N+11;
			long[][] cap=new long[MAX][MAX];
			for(int i=1; i<=7; ++i)	cap[0][i]=W;
			long sum=0;
			for(int i=0; i<N; ++i){
				long t=sc.nextLong();
				int c=sc.nextInt();
				sum+=t;
				for(int j=0; j<c; ++j){
					String week = sc.next();
					cap[weeks.get(week)][10+i] = W;
				}
				cap[10+i][10+N]=t;
			}
			Dinic d = new Dinic(cap, MAX);
			long ret = d.maxFlow(0, 10+N);
//			System.out.println( ret +" "+sum );
			System.out.println(ret==sum? "Yes": "No");
		}
		class Dinic{
			ArrayList<ArrayList<Edge2>> g;
			int[] 	level,
					iter;
			final long INF = 1<<60;
			int V;
			class Edge2{
				int to, rev;
				long cap;
				Edge2(int to,long cap,int rev){
					this.to=to;	this.cap=cap;	this.rev=rev;
				}
			}
			Dinic(long[][] cap,int V){
				this.V = V;
				level = new int[V];
				iter = new int[V];
				g = new ArrayList<ArrayList<Edge2>>(V);
				for(int i=0; i<V; ++i)	g.add(new ArrayList<Edge2>());
				for(int from=0; from<V; ++from)for(int to=0; to<V; ++to){
					if(cap[from][to] > 0){
						g.get(from).add(new Edge2(to, cap[from][to], g.get(to).size()));
						g.get(to).add(new Edge2(from, 0, g.get(from).size()-1));
					}
				}
			}
			long maxFlow(int s,int t){
				long flow = 0;
				while(true){
					bfs(s);
					if(level[t] < 0)	return flow;
					for(int i=0; i<V; ++i)	iter[i]=0;
					long f=0;
					while( (f=dfs(s, t, INF)) > 0)	flow += f;
				}
			}
			void bfs(int s){
				for(int i=0; i<V; ++i)	level[i] = -1;
				LinkedList<Integer> que = new LinkedList<Integer>();
				level[s] = 0;
				que.add(s);
				while(!que.isEmpty()){
					int v = que.poll();
					for(Edge2 e:g.get(v)){
						if(e.cap > 0 && level[e.to] < 0){
							level[e.to]= level[v]+1;
							que.add(e.to);
						}
					}
				}
			}
			long dfs(int v,int t,long f){
				if(v==t)	return f;
				for( ; iter[v]<g.get(v).size(); ++iter[v]){
					Edge2 e = g.get(v).get(iter[v]);
					if(e.cap > 0 && level[v] < level[e.to]){
						long d = dfs(e.to, t, min(f ,e.cap));
						if(d > 0){
							e.cap -= d;
							g.get(e.to).get(e.rev).cap += d;
							return d;
						}
					}
				}
				return 0;
			}
		}
	}
}