import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class E {
	public static final long MOD = 998244353l;
	public static class Pair{
		int l;
		int r;
		Pair(int a,int b){
			l=a;
			r=b;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = (int) Long.parseLong(st.nextToken());
		int m = (int) Long.parseLong(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<TreeSet<Integer>> graph = new ArrayList<TreeSet<Integer>>();
		for(int i=0;i<n;++i){
			graph.add(new TreeSet<Integer>());
		}
		Pair[] edges = new Pair[m];
		int[] ecs = new int[n];
		for(int j=0;j<m;++j){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph.get(a).add(b);
			graph.get(b).add(a);
			++ecs[a];
			++ecs[b];
			edges[j] = new Pair(a,b);
		}
		
		//boolean cleared = false;
		Queue<Integer> toClear = new ArrayDeque<Integer>();
		//boolean[] valid = new boolean[n];
		//int inGru=0;
		boolean[] inQ = new boolean[n];
		
		for(int i=0;i<n;++i){
			if(graph.get(i).size()<k){
				toClear.add(i);
				//valid[i]=false;
				inQ[i]=true;
			}
		}
		while(!toClear.isEmpty()){
			int x = toClear.poll();
			ecs[x]=0;
			if(graph.get(x)==null)continue;
			for(int y : graph.get(x)){
				graph.get(y).remove(x);
				--ecs[y];
				if(ecs[y]<k){
					if(!inQ[y]){
						toClear.add(y);
						inQ[y]=true;
					}
				}
			}
			graph.set(x, null);
			//System.err.println("BYE "+x);
		}
		int valid = 0;
		for(int j=0;j<n;++j){
			if(ecs[j]>=k){
				++valid;
			}
			else if(ecs[j]!=0){
				//System.err.println("FUU");
				//we failed
			}
		}
		int[] max = new int[m+1];
		max[m]= valid; 
		for(int i=m-1;i>0;--i){
			int l = edges[i].l;
			int r = edges[i].r;
			if(graph.get(l)!=null && graph.get(r)!=null){
				--ecs[l];
				--ecs[r];
				graph.get(l).remove(r);
				graph.get(r).remove(l);
				if(ecs[l]<k){
					toClear.add(l);
				}
				if(ecs[r]<k){
					toClear.add(r);
				}
				while(!toClear.isEmpty()){
					
					
					int x = toClear.poll();
					if(graph.get(x)==null)continue;
					--valid;
					ecs[x]=0;
					//System.err.println("Removing " + x);
					for(int y : graph.get(x)){
						graph.get(y).remove(x);
						--ecs[y];
						if(ecs[y]<k){
							if(!inQ[y]){
								toClear.add(y);
								inQ[y]=true;
							}
						}
					}
					graph.set(x, null);
				}
			}
			max[i]=valid;
		}
		for(int j=1;j<=m;++j){
			bw.write(max[j]+"\n");
		}
		bw.flush();


	}
}
