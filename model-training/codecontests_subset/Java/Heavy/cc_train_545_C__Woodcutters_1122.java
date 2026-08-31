import java.util.*;
import java.io.*;

public class Problem545C {

	public static HashMap<String, Integer> map = new HashMap<>();

	public static class Pair {
		int x;
		int tree;

		public Pair(int x, int tree){
			this.x = x;
			this.tree = tree;
		}
	}

	public static int solve(ArrayList<Pair> lines, int index, int prevLeft, String s){
		if (index == lines.size()){
			return 0;
		}
		
		if (map.containsKey(index + s)){
			return map.get(index + s);
		}

		Pair p = lines.get(index);
		int x = p.x;
		int height = p.tree;
		int count = 0;
		int count1 = 0;
		boolean left = false;
		int count2 = 0;

		if ((index + 1 < lines.size() && x + height < lines.get(index + 1).x) 
			|| (index == lines.size() - 1)) {
			count2 = 1 + solve(lines, index + 1, x + height, "R");
		}

		count = solve(lines, index + 1, x, "L");

		if (index == 0 ||  x - height > prevLeft){
			count++;
			left = true;
		}

		map.put(index + s, Math.max(count, count2));

		return Math.max(count, count2);
	}

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numLines = Integer.parseInt(br.readLine());
		ArrayList<Pair> lines = new ArrayList<>();
		for (int i = 0; i < numLines; i++){
			String[] vals = br.readLine().split(" ");
			int x = Integer.parseInt(vals[0]);
			int tree = Integer.parseInt(vals[1]);
			Pair p = new Pair(x, tree);
			lines.add(p);
		}
		int res = solve(lines, 0, -1, "L");
		System.out.println(res);
	}

}