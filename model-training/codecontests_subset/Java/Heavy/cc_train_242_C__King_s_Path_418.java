import java.util.*;
import java.io.*;

public class Solution {
    private static class Node {
		int row;
		int col;
		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ins = br.readLine().trim().split(" ");
        int x1 = Integer.parseInt(ins[0]);
        int y1 = Integer.parseInt(ins[1]);
        int x2 = Integer.parseInt(ins[2]);
        int y2 = Integer.parseInt(ins[3]);
        int n = Integer.parseInt(br.readLine().trim());
        HashMap<Integer, LinkedList<int[]>> map = new HashMap<Integer, LinkedList<int[]>>(); 
        for (int i = 0; i < n; i++) {
            ins = br.readLine().trim().split(" ");
            int r = Integer.parseInt(ins[0]);
            int c1 = Integer.parseInt(ins[1]);
            int c2 = Integer.parseInt(ins[2]);
            if(!map.containsKey(r))
                map.put(r, new LinkedList<int[]>());
            map.get(r).addLast(new int[]{c1, c2});
        }
        Queue<Node> q = new LinkedList<Node>();
        HashSet<Node> visited = new HashSet<Node>();
        q.add(new Node(x1, y1));
        visited.add(new Node(x1, y1));
        int steps = 0;
        boolean isPossible = false;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Node p = q.poll();
                if(p.row == x2 && p.col == y2) {
                    isPossible = true;
                    break;
                }
                for(int j=-1; j<2; j++) {
                    for(int k=-1; k<2; k++) {
                        int tx = p.row + j;
                        int ty = p.col + k;
                        if(!map.containsKey(tx)) continue;
                        LinkedList<int[]> list = map.get(tx);
                        for(int[] l: list) {
                            if(ty >= l[0] && ty <= l[1] && !visited.contains(new Node(tx, ty))) {
                                q.add(new Node(tx, ty));
                                visited.add(new Node(tx, ty));
                                break;
                            }
                        }
                    }
                }
            }
            if(isPossible) break;
            steps++;
        }
        if(isPossible) System.out.println(steps);
        else System.out.println("-1");
    }
}
