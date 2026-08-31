import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E {
	static BufferedReader br;
	static StringTokenizer st;
	static Set<Integer>[] list;
	static TreeSet<Integer> unvisited = new TreeSet<>();
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = nextInt();
		int m = nextInt();
		
		list = new HashSet[n+1];
		for(int i=1;i<=n;i++){
			list[i] = new HashSet<Integer>();
			list[i].add(0);
		}
		
		for(int i=1;i<=n;i++){
			unvisited.add(i);
		}
		
		for(int i=0;i<m;i++){
			int a = nextInt();
			int b = nextInt();
			
			list[a].add(b);
			list[b].add(a);
		}
		
		ArrayList<Integer> com = new ArrayList<>();
		while(!unvisited.isEmpty()){
			com.add(dfs(unvisited.first()));
		}
		
		Collections.sort(com);
		System.out.println(com.size());
		for(int i:com)
			System.out.print(i+" ");
	}
	public static int dfs(Integer cur) {
		unvisited.remove(cur);
		int cnt = 1;
		for(int i : list[cur]){
			while(true){
				Integer next = unvisited.higher(i);
				if(next == null || list[cur].contains(next)){
					break;
				}
				cnt += dfs(next);
			}
			
			if(unvisited.isEmpty())
				break;
		}
		
		return cnt;
	}
	public static String nextToken() throws IOException{
		while(st == null || !st.hasMoreTokens()){
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}
	
	public static int nextInt() throws IOException{
		return Integer.parseInt(nextToken());
	}
}
