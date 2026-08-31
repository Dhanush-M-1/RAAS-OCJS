
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Div2_242C {

	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String nmkt[]=bf.readLine().split(" ");
		int x=Integer.parseInt(nmkt[0]);
		int y=Integer.parseInt(nmkt[1]);
		int x2=Integer.parseInt(nmkt[2]);
		int y2=Integer.parseInt(nmkt[3]);

		int n = Integer.parseInt(bf.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for (int i= 0 ; i<n ; ++i) {
			String rij[]=bf.readLine().split(" ");
			int r=Integer.parseInt(rij[0]);
			int xi=Integer.parseInt(rij[1]);
			int yj=Integer.parseInt(rij[2]);
			while (xi<=yj) {
				map.put(r+","+xi, -1);
				++xi;
			}
		}
		bfs(map, x, y, x2, y2);
		System.out.println(map.get(x2+","+y2));
	}
	
	static void bfs (HashMap<String, Integer> map , int x  , int y , int x2 , int y2) {
		Queue<String> q = new LinkedList<>();
		q.add(x+","+y);
		map.put(x+","+y, 0);
		while (!q.isEmpty()) {
			String parent = q.remove();
			String rc[]=parent.split(",");
			int r=Integer.parseInt(rc[0]) ,c=Integer.parseInt(rc[1]);
			for (int i = -1 ; i < 2 ; ++i) {
				int newr=i+r;
				for (int j=-1 ; j<2 ; ++j) {
					if (i==0&&j==0)
						continue;
					int newc=c+j;
					if (map.get(newr+","+newc)==null || map.get(newr+","+newc)!=-1)
						continue;
					q.add(newr+","+newc);
//					System.out.println(newr+","+newc);
					map.put(newr+","+newc , map.get(parent)+1);
				}
			}
		}
	} 
	
	
	static void addEdges(HashMap<String, ArrayList<Integer>> map , int r , int c) {
		if (map.get((r+","+c))==null) {
			map.put((r+","+c), new ArrayList<>());
		}
		
		for (int i = -1 ; i < 2 ; ++i) {
			int newr=i+r;
			for (int j=-1 ; j<2 ; ++j) {
				if (i==0&&j==0)
					continue;
				int newc=c+j;
				
			}
			
//			if (map.get((newr+","+newc))==null) {
//				map.put((r+","+c), new ArrayList<>());
//			}
			
		}
	}

}
