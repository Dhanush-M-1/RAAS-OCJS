import java.io.*;
import java.util.*;

public class Main{

	static List<Integer>[] list;
	static DisjointSet set;
	static int[] degree;

	public static void main(String[] args){
		Scan scan = new Scan();
		int n = scan.nextInt();
		int m = scan.nextInt();
		int q = scan.nextInt();
		list = new List[n];
		for(int i=0;i<n;i++) list[i] = new ArrayList<Integer>();
		degree = new int[n];
		set = new DisjointSet(n);
		for(int i=0;i<m;i++){
			int a = scan.nextInt()-1;
			int b = scan.nextInt()-1;
			degree[a]++;
			degree[b]++;
			list[a].add(b);
			list[b].add(a);
			set.union(a,b, false);
		}

//		for(int i=0;i<n;i++) System.out.println((i+1)+" : "+set.dset[i]);

		initialize(n);

//		for(int i=0;i<n;i++) System.out.println((i+1)+" : "+set.dset[i]);

		StringBuilder sb = new StringBuilder(500000);
		for(int i=1;i<=q;i++){
			int type = scan.nextInt();
			if(type == 1){
				//				System.out.println(-1*set.dset[set.find(scan.nextInt()-1)] - 1);
				sb.append((-set.dset[set.find(scan.nextInt()-1)] - 1)+"\n");
			}
			if(type == 2){
				set.union(scan.nextInt()-1, scan.nextInt()-1, true);
			}
		}
		System.out.println(sb);
//		for(int i=0;i<n;i++) System.out.println((i+1)+" : "+set.dset[i]);
	}

	static int end;
	static int max;

	static void initialize(int n){
		boolean[] used = new boolean[n];
		for(int i=0;i<n;i++){
			if(set.dset[i] < 0){
				max = 0;
				dfs(i, used, 1);
				dfs(end, used, 1);
				set.dset[i] = -max;
//				System.out.println("set "+i+", "+(-max));
			}
		}
	}

	static void dfs(int now, boolean[] used, int depth){
		used[now] = true;
		boolean leaf = true;
		for(Integer i : list[now]){
			int next = i;
			if(!used[next]){
				leaf = false;
				dfs(next, used, depth+1);
			}
		}

		if(leaf && max < depth){
			max = depth;
			end = now;
		}
		used[now] = false;
	}

//	static void initialize(int n){
//
//		boolean[] dead = new boolean[n];
//		Queue<Integer> qNow = new ArrayDeque<Integer>();
//		Queue<Integer> qNext = new ArrayDeque<Integer>();
//		for(int i=0;i<n;i++){
//			if(degree[i] == 1) qNow.add(i);
//		}
//
//		int depth = 0;
//		while(!qNow.isEmpty()){
//			depth++;
//			while(!qNow.isEmpty()){
//				int now = qNow.poll();
//				dead[now] = true;
//				//				System.out.println((now+1)+" is depth "+depth+", degree "+degree[now]);
//				if(degree[now] == 0) set.dset[set.find(now)] = -(depth<<1) + 1;
//				//				if(degree[now] == -1) set.dset[set.find(now)]++;
//				for(Integer o : list[now]){
//					int next = o;
//					if(dead[next]) set.dset[set.find(now)]--;
//					if(--degree[next] == 1) qNext.add(next);
//				}
//			}
//			Queue<Integer> temp = qNow;
//			temp.clear();
//			qNow = qNext;
//			qNext = temp;
//			dead = new boolean[n];
//		}
//	}

	static class DisjointSet{

		int[] dset;

		DisjointSet(int n){
			dset = new int[n];
			Arrays.fill(dset, -1);
		}

		int find(int x){
			if(dset[x] < 0) return x;
			return dset[x] = find(dset[x]);
		}

		void union(int a, int b, boolean maintain){
			int rootA = find(a);
			int rootB = find(b);
			if(rootA == rootB) return;
			if(maintain){
				int original = (dset[rootA]<dset[rootB]) ? dset[rootA] : dset[rootB];
				int merge = -(((-dset[rootA])>>1)+((-dset[rootB])>>1)+2);
				dset[rootA] = original<merge ? original : merge;
			}
			dset[rootB] = rootA;
//			System.out.println((a+1)+" + "+(b+1)+" = " + ((-dset[rootA])) );
		}
	}

}


class Scan implements Iterator<String>{

	BufferedReader buffer;
	StringTokenizer tok;

	Scan(){
		buffer = new BufferedReader(new InputStreamReader(System.in));
	}


	@Override
	public boolean hasNext(){
		while(tok==null || !tok.hasMoreElements()){
			try{
				tok = new StringTokenizer(buffer.readLine());
			}catch(Exception e){
				return false;
			}
		}
		return true;
	}

	@Override
	public String next(){
		if(hasNext()) return tok.nextToken();
		return null;
	}

	@Override
	public void remove(){
		throw new UnsupportedOperationException();
	}

	int nextInt(){
		return Integer.parseInt(next());
	}

	String nextLine(){
		if(hasNext()) return tok.nextToken("\n");
		return null;
	}
}