import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class GBC {
	public static void main(String[] args) {
		LinkedList<Pair> arr = new LinkedList<Pair>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		HashMap <Integer , Pair> map = new HashMap<Integer , Pair>(); 
		for(int i = 1 ; i <= n ; i++){
			map.put(i, new Pair(i, in.nextInt()));
		}
		boolean [] vis = new boolean [n+1];
		int ans = 0;
		for(int i = 0 ; i < m ; i++){
			int u = in.nextInt();
			if(!vis[u]){
				vis[u] = true;
				for(Pair t : arr){
					ans+=t.weight;
				}
				arr.addFirst(map.get(u));
			}else{
				for(Pair t : arr){
					if(t==map.get(u))break;
					ans+=t.weight;
				}
				arr.remove(map.get(u));
				arr.addFirst(map.get(u));
			}
		}
		System.out.println(ans);
		
	}
	public static class  Pair{
		int num;
		int weight;
		public Pair(int n , int w) {
			// TODO Auto-generated constructor stub
			num = n;
			weight = w;
		}
	}
}
