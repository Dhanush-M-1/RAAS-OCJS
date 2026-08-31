import java.io.IOException; 
import java.io.InputStream; 
import java.io.PrintWriter;
import java.util.*;

public class e{ 
	static List<Edge> edges[];
	static int[] esize;
	static boolean[] stay;
	static boolean[] used;
	static int k;
	static int[] u,v;
	static int bfs(int id){
		int res =0;
		esize[u[id]]--;esize[v[id]]--;
		used[id]=true;
		Deque<Integer> que = new ArrayDeque<>();
		if(esize[u[id]]<k){
			que.add(u[id]);
			stay[u[id]]=true;
			++res;
		}
		if(esize[v[id]]<k){
			que.add(v[id]);
			stay[v[id]]=true;
			++res;
		}
		while(!que.isEmpty()){
			int p = que.poll();
			esize[p]=0;
			for(Edge e: edges[p])if(!used[e.id] && !stay[e.to]){
				used[e.id]=true;
				esize[e.to]--;
				if(esize[e.to]<k){
					que.add(e.to);stay[e.to]=true;
					++res;
				}
			}
		}
		return res;
	}

	static class Edge{
		int to, id;
		Edge(int to, int id){this.to=to;this.id=id;}
	}

	static void solve(){
		int n =ni(), m=ni();
		k=ni();
		u = new int[m];
		v = new int[m];
		edges = new List[n];
		used = new boolean[m];
		for(int i=0;i<n;++i)edges[i]=new ArrayList<>();
		for(int i=0;i<m;++i){
			u[i]=ni()-1;
			v[i]=ni()-1;
			edges[u[i]].add(new Edge(v[i], i));
			edges[v[i]].add(new Edge(u[i], i));
		}

		int remain = n;

		esize= new int[n];
		for(int i=0;i<n;++i)esize[i]=edges[i].size();
		stay = new boolean[n];
		Deque<Integer> que = new ArrayDeque<>();
		for(int i=0;i<n;++i)if(esize[i]<k){
			que.add(i);
			stay[i]=true;
			--remain;
		}

		while(!que.isEmpty()){
			int p = que.poll();
			esize[p]=0;
			for(Edge e: edges[p])if(!used[e.id] && !stay[e.to]){
				esize[e.to]--;
				used[e.id]=true;
				if(esize[e.to]<k){
					que.add(e.to);stay[e.to]=true;
					--remain;
				}
			}
		}

		int[] ans = new int[m];
		ans[m-1]=remain;
		for(int i=m-2;i>=0;--i){
			if(!stay[u[i+1]]&&!stay[v[i+1]]){
				remain -= bfs(i+1);
			}
			ans[i]=remain;
		}
		for(int a: ans)out.println(a);

	} 
 
 
 
 
	public static void main(String[] args){ 
		 solve(); 
		 out.flush(); 
	 } 
	 private static InputStream in = System.in; 
	 private static PrintWriter out = new PrintWriter(System.out); 
 
	 private static final byte[] buffer = new byte[1<<15]; 
	 private static int ptr = 0; 
	 private static int buflen = 0; 
	 private static boolean hasNextByte(){ 
		 if(ptr<buflen)return true; 
		 ptr = 0; 
		 try{ 
			 buflen = in.read(buffer); 
		 } catch (IOException e){ 
			 e.printStackTrace(); 
		 } 
		 return buflen>0; 
	 } 
	 private static int readByte(){ if(hasNextByte()) return buffer[ptr++]; else return -1;} 
	 private static boolean isSpaceChar(int c){ return !(33<=c && c<=126);} 
	 private static int skip(){int res; while((res=readByte())!=-1 && isSpaceChar(res)); return res;} 
 
	 private static double nd(){ return Double.parseDouble(ns()); } 
	 private static char nc(){ return (char)skip(); } 
	 private static String ns(){ 
		 StringBuilder sb = new StringBuilder(); 
		 for(int b=skip();!isSpaceChar(b);b=readByte())sb.append((char)b); 
		 return sb.toString(); 
	 } 
	 private static int[] nia(int n){ 
		 int[] res = new int[n]; 
		 for(int i=0;i<n;++i)res[i]=ni(); 
		 return res; 
	 } 
	 private static long[] nla(int n){ 
		 long[] res = new long[n]; 
		 for(int i=0;i<n;++i)res[i]=nl(); 
		 return res; 
	 } 
	 private static int ni(){ 
		 int res=0,b; 
		 boolean minus=false; 
		 while((b=readByte())!=-1 && !((b>='0'&&b<='9') || b=='-')); 
		 if(b=='-'){ 
			 minus=true; 
			 b=readByte(); 
		 } 
		 for(;'0'<=b&&b<='9';b=readByte())res=res*10+(b-'0'); 
		 return minus ? -res:res; 
	 } 
	 private static long nl(){ 
		 long res=0,b; 
		 boolean minus=false; 
		 while((b=readByte())!=-1 && !((b>='0'&&b<='9') || b=='-')); 
		 if(b=='-'){ 
			 minus=true; 
			 b=readByte(); 
		 } 
		 for(;'0'<=b&&b<='9';b=readByte())res=res*10+(b-'0'); 
		 return minus ? -res:res; 
	} 
} 

