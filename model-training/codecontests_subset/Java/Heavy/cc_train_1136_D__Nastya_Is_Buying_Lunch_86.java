import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class cf {
	public static void main(String[] args) {
		FS scan = new FS(System.in);
		int N = scan.nextInt(), M = scan.nextInt();
		
		int[] list = new int[N], rev = new int[N];
		for(int i=0;i<N;i++){
			list[i] = scan.nextInt()-1;
			rev[list[i]] = i;
		}
		
		HashSet<Integer> jumpers = new HashSet<>();
		ArrayDeque<Integer>[] adj = new ArrayDeque[N],
				backProp = new ArrayDeque[N];
		for(int i=0;i<N;i++){
			adj[i] = new ArrayDeque<>();
			backProp[i] = new ArrayDeque<>();
		}
		for(int i=0;i<M;i++){
			int u = scan.nextInt()-1, v = scan.nextInt()-1;
			adj[u].add(v);
			if(v==list[N-1])
				jumpers.add(u);
		}
		
		
		for(int i : jumpers) {
			for(int j : adj[i]) {
				if(rev[j] > rev[i]) {
					backProp[j].add(i);
				}
			}
		}
		
		int[] countToRight = new int[N];
		boolean[] canJump = new boolean[N];
		for(int i : jumpers) {
			canJump[rev[i]] = true;
			for(int j : adj[i]){
				if(j==list[N-1])continue;
				if(rev[j] > rev[i] && !jumpers.contains(j)) countToRight[i]++;
			}
		}
//		System.out.println(jumpers);
//		System.out.println(Arrays.toString(canJump));
		int sum = 0, sol = 0;
		int[] add = new int[N];
		for(int i=N-2;i>=0;i--){
			if(canJump[i]){
//				System.out.println(i+" "+sum+" "+(countToRight[list[i]]+add[i]));
				if(sum==countToRight[list[i]]+add[i])
					sol++;
				else {
					sum++;
					for(int j : backProp[list[i]])
						add[rev[j]]++;
				}
			} else{
				sum++;
			}
		}
		System.out.println(sol);
	}
	
	private static class FS {
		BufferedReader br;
		StringTokenizer st;
		public FS(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}
		String next(){
			while(st==null||!st.hasMoreElements()){
				try{st = new StringTokenizer(br.readLine());}
				catch(IOException e){e.printStackTrace();}
			}
			return st.nextToken();
		}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() { return Double.parseDouble(next());}
	}
}
