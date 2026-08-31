import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://arc090.contest.atcoder.jp/tasks/arc090_b
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Node[] nodes = new Node[N];
		for(int i=0; i<N; i++) nodes[i] = new Node(i);
		int M = sc.nextInt();
		for(int i=0; i<M; i++){
			int l = Integer.parseInt(sc.next())-1;
			int r = Integer.parseInt(sc.next())-1;
			int d = Integer.parseInt(sc.next());
			nodes[l].neighbor.put(nodes[r], d);
		}
		sc.close();
		List<Node> list = topologicalSort(nodes);
		
		String ans = "Yes";
		if(list.size() == N){
			for(Node n:list){
				if(n.x==-1){
					if(!dfs(n,0)){
						ans = "No";
						break;
					}		
				}
			}
		}else{
			ans = "No";
		}
		
		System.out.println(ans);
		
	}
	
	static boolean dfs(Node node, long current){
		node.x = current;
		for(Entry<Node, Integer> n:node.neighbor.entrySet()){
			Node nn = n.getKey();
			int d = n.getValue();
			if(nn.x!=-1){
				if(nn.x != current+d) return false;
			}else{
				if(!dfs(nn, current+d)){
					return false;
				}	
			}
		}
		return true;
	}
	
	static class Node{
		int id;
		long x = -1;
		Map<Node,Integer> neighbor = new HashMap<>();
		int color = -1;
		int status = -1;
		int inDegree = 0;
		Node(int id){
			this.id = id;
		}
	}
	
	static List<Node> topologicalSort(Node[] nodeList){
		List<Node> sortedList = new ArrayList<>();
		for(Node node:nodeList)
			for(Node n:node.neighbor.keySet())
				n.inDegree++;
		for(Node node:nodeList){
			if(node.status!=-1 || node.inDegree>0) continue;
			Queue<Node> que = new ArrayDeque<>();
			node.status=1;
			que.add(node);
			while(!que.isEmpty()){
				Node current = que.remove();
				sortedList.add(current);
				for(Node n:current.neighbor.keySet()){
					if(--n.inDegree==0 && n.status==-1){
						n.status=1;
						que.add(n);
					}
				}
			}
		}
		return sortedList;
	}

}