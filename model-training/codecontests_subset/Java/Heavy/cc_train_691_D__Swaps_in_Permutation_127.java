import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
// start: 17:50h
public class problem_0691d {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader
				(new InputStreamReader(System.in));
		String[] line;
		
		line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		
		line = br.readLine().split(" ");
		int[] perm = new int[N];
		for(int n = 0; n < N; n++){
			perm[n] = Integer.parseInt(line[n])-1;
		}
		
		ArrayList<Integer>[] edges = new ArrayList[N];
		for(int n = 0; n < N; n++){
			edges[n] = new ArrayList<>(1);
		}
		for(int m = 0; m < M; m++){
			line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0])-1;
			int b = Integer.parseInt(line[1])-1;
			edges[a].add(b);
			edges[b].add(a);
		}
		
		int[] sets = markMoveSets(N,edges);
		PriorityQueue<Integer>[] pqarr = new PriorityQueue[amtSets];
		for(int i = 0; i < amtSets; i++){
			pqarr[i] = new PriorityQueue<>();
		}
		for(int n = 0; n < N; n++){
			pqarr[sets[n]].offer(-perm[n]);
		}
		int[] arr = new int[N];
		for(int n = 0; n < N; n++){
			arr[n] = -pqarr[sets[n]].poll().intValue();
		}
		StringBuilder sb = new StringBuilder();
		for(int n = 0; n < N; n++){
			if(n>0) sb.append(' ');
			sb.append(""+(arr[n]+1));
		}
		System.out.println(sb);
	}
	static int amtSets;
	static int[] markMoveSets(int N, ArrayList<Integer>[] edges){
		int[] sets = new int[N];
		Arrays.fill(sets, -1);
		amtSets = 0;
		for(int i = 0; i < N; i++){
			if(sets[i] == -1){
				dfsMark(sets, i, edges);
				amtSets++;
			}
		}
		return sets;
	}
	static void dfsMark(int[] sets, int i, ArrayList<Integer>[] edges){
		ArrayDeque<Integer> q = new ArrayDeque<>();
		sets[i] = amtSets;
		q.add(i);
		while(!q.isEmpty()){
			int poll = q.poll().intValue();
			for(int j = 0; j < edges[poll].size(); j++){
				int next = edges[poll].get(j);
				if(sets[next] == -1){
					sets[next] = amtSets;
					q.offer(next);
				}
			}
		}
	}
}
