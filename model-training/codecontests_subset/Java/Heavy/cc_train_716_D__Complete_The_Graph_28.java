import java.io.*;
import java.util.*;
public class div372Dx
{
	BufferedReader in;
	PrintWriter ob;
	StringTokenizer st;
	int n,m,L,u[],v[],w[],source,dest;
	long cost[][];
	long dist1[],dist2[];
	boolean vis1[],vis2[];
	ArrayList<Integer> gr[];
	public static void main(String[] args) throws IOException {
		new div372Dx().run();
	}
	void run() throws IOException {
		//in=new BufferedReader(new FileReader("input.txt"));
		in=new BufferedReader(new InputStreamReader(System.in));
		ob=new PrintWriter(System.out);
		solve();
		ob.flush();
	}
	@SuppressWarnings("unchecked")
	void solve() throws IOException {
		n=ni();
		m=ni();
		L=ni();
		source=ni();
		dest=ni();
		cost=new long[n][n];
		u=new int[m];
		v=new int[m];
		w=new int[m];
		gr=new ArrayList[n];
		for (int i=0; i<n ; i++ ) {
			gr[i]=new ArrayList<Integer>();
		}
		for (int i=0; i<m ; i++ ) {
			u[i]=ni();
			v[i]=ni();
			w[i]=ni();
			gr[u[i]].add(v[i]);
			gr[v[i]].add(u[i]);
			cost[u[i]][v[i]]=(w[i]==0)?-1:w[i];
			cost[v[i]][u[i]]=(w[i]==0)?-1:w[i];
		}
		dijkstra(dest,source);
		/*for (int i=0; i<n ; i++ ) {
			ob.println("dijkstra "+i+" "+dist1[i]);
		}*/
		dijkstraS(source,dest);
		/*for (int i=0; i<n ; i++ ) {
			ob.println("dijkstra2 "+i+" "+dist2[i]);
		}*/
		if(dist2[dest]!=L) {
			ob.println("NO");
		}
		else {
			ob.println("YES");
			for (int i=0; i<m ; i++ ) {
			    if(cost[u[i]][v[i]]==-1)
				ob.println(u[i]+" "+v[i]+" 1000000000000");
				else
				ob.println(u[i]+" "+v[i]+" "+cost[u[i]][v[i]]);
			}
		}
	}

	void dijkstraS(int source,int dest) {
		TreeSet<Template> pq=new TreeSet<Template>(new Comparator<Template>(){
			public int compare(Template x, Template y) {
			if(x.p!=y.p)
				return Long.compare(x.p,y.p);
				else
				return x.i-y.i;
			}
		});
		dist2=new long[n];
		Arrays.fill(dist2,Long.MAX_VALUE);
		dist2[source]=0;
		vis2=new boolean[n];
		Template start=new Template();
		start.i=source;
		start.p=0;
		pq.add(start);
		while(!pq.isEmpty()) {
			Template polled=pq.first();
			int ele=polled.i;
			long p=polled.p;
			pq.remove(polled);
			vis2[ele]=true;
			for(int x : gr[ele]) {
				if(!vis2[x]) {
					long weight=(cost[ele][x]==-1)?Math.max(1,L-p-dist1[x]):cost[ele][x];
					if(p+weight<=dist2[x]) {
						cost[ele][x]=weight;
						cost[x][ele]=weight;
						dist2[x]=p+weight;
						Template next=new Template();
						next.i=x;
						next.p=dist2[x];
						pq.add(next);
					}
				}
			}		
		}
	}
	
	void dijkstra(int source,int dest) {
		TreeSet<Template> pq=new TreeSet<Template>(new Comparator<Template>(){
			public int compare(Template x, Template y) {
			if(x.p!=y.p)
				return Long.compare(x.p,y.p);
				else
				return x.i-y.i;
			}
		});
		dist1=new long[n];
		Arrays.fill(dist1,Long.MAX_VALUE);
		dist1[source]=0;
		vis1=new boolean[n];
		Template start=new Template();
		start.i=source;
		start.p=0;
		pq.add(start);
		while(pq.isEmpty()==false) {
			Template polled=pq.first();
			int ele=polled.i;
			long p=polled.p;
			pq.remove(polled);
			vis1[ele]=true;
			for(int x : gr[ele]) {
				if(!vis1[x]) {
					long weight=(cost[ele][x]==-1)?1:cost[ele][x];
					if(p+weight<=dist1[x]) {
						dist1[x]=p+weight;
						Template next=new Template();
						next.i=x;
						next.p=dist1[x];
						pq.add(next);
					}
				}
			}		
		}
	}
	int ni() throws IOException {
		return Integer.parseInt(nextToken());
	}
	String nextToken() throws IOException {
		if(st==null || !st.hasMoreTokens())
			st=new StringTokenizer(in.readLine());
		return st.nextToken();
	}
}
class Template {
	int i;
	long p;
}