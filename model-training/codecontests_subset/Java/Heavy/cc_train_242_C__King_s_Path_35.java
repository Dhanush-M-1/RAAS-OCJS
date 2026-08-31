import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class C_KingsPath {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<intPair> mod = new ArrayList<>();
		mod.add(new intPair(1, 0));
		mod.add(new intPair(-1, 0));
		mod.add(new intPair(0, 1));
		mod.add(new intPair(0, -1));
		mod.add(new intPair(1, 1));
		mod.add(new intPair(1, -1));
		mod.add(new intPair(-1, 1));
		mod.add(new intPair(-1, -1));
		
		
		String [] dat = br.readLine().split(" ");
		intPair s = new intPair(Integer.parseInt(dat[0]), Integer.parseInt(dat[1]));
		intPair f = new intPair(Integer.parseInt(dat[2]), Integer.parseInt(dat[3]));

		int n = Integer.parseInt(br.readLine());
		
		HashMap<Integer, ArrayList<intPair>> board = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			dat = br.readLine().split(" ");
			int r = Integer.parseInt(dat[0]);
			if (!board.containsKey(r)) {
				board.put(r, new ArrayList<>());
			}
			board.get(r).add(new intPair(Integer.parseInt(dat[1]), Integer.parseInt(dat[2])));
		}
		
		boolean posible = false;
		int total = -1;
		
		ArrayDeque<query> bfs = new ArrayDeque<>();
		HashSet<Long> visited = new HashSet<>();
		
		bfs.add(new query(s, 0));
		
		while (!bfs.isEmpty() && !posible) {
			
			query current = bfs.remove();
			
			if (!visited.contains(current.pos.rep())) {
				
				visited.add(current.pos.rep());
				
				int x = current.pos.x;
				int y = current.pos.y;
				int steps = current.steps + 1;
				
				for (int m = 0; m < mod.size() && !posible; m++) {
					
					x = x + mod.get(m).x;
					y = y + mod.get(m).y;
					
					if (board.containsKey(x)) {
						boolean valid = false;
						ArrayList<intPair> segments = board.get(x);
						for (int i = 0; i < segments.size() && !valid; i++) {
							if (segments.get(i).x <= y && y <= segments.get(i).y){
								valid = true;
							}
						}
						if (valid) {
							intPair newP = new intPair(x, y);
							if (f.compareTo(newP) == 0) {
								posible = true;
								total = steps;
							}else {
								if (!visited.contains(newP.rep())) {
									bfs.add(new query(newP, steps));
								}
							}
						}
					}
					
					x = x - mod.get(m).x;
					y = y - mod.get(m).y;
					
				}
				
				
			}
			
		}
		
		
		bw.write(total + "\n");
		
		bw.close();

	}
	
	static class query {
		intPair pos;
		int steps;
		public query(intPair pos, int steps) {
			this.pos = pos;
			this.steps = steps;
		}
		@Override
		public String toString() {
			return pos + " " + steps;
		}
	}
	
	static class intPair implements Comparable<intPair>{
		int x;
		int y;
		public intPair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public long rep(){
			return x*1000000000l + y;
		}
		@Override
		public int compareTo(intPair o) {
			if (o.x != this.x) {
				return o.x - this.x;
			}else {				
				return o.y - this.y;
			}
		}
		@Override
		public String toString() {
			return x + " " + y;
		}
	}

}
