import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		ABCompilationErrors res = new ABCompilationErrors();
		res.resolve();
	}
	
	static class ABCompilationErrors {

		public void resolve () {
			Scanner scan = new Scanner (System.in);
			
			int n = scan.nextInt();
			
			HashMap<Integer, Node> map = new HashMap<>();
			int v;
			for (int i = 0; i < n; i++) {
				v = scan.nextInt();
				if (!map.containsKey(v))
					map.put(v, new Node(v, 2));
				else {
					map.get(v).times += 2;
					map.get(v).appeared += 1;
				}	
			}
			
			for (int i = 0; i < n - 1; i++) {
				v = scan.nextInt();
				map.get(v).times -= 1;
			}
			
			List<Node> list = new ArrayList<>(map.values());
			
			for (Node node: list) {
				if (node.appeared * 2 - node.appeared != node.times) {
					System.out.println(node.num);
					node.times -= 2;
				}
			}
			
			for (int i = 0; i < n - 2; i++) {
				v = scan.nextInt();
				map.get(v).times -= 1;
			}
			
			list = new ArrayList<>(map.values());
			
			for (Node node: list) {
				if (node.times != 0) {
					System.out.println(node.num);	
				}
			}
			
			scan.close();
		}
		
		class Node {
			public int appeared = 0;
			public int times = 0;
			public int num;
			
			public Node (int num, int times) {
				this.num = num;
				this.times = times;
				appeared = 1;
			}
		}
	}
}
