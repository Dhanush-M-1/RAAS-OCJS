import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 入力
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Vector2d> p = new ArrayList<>();
		for (int i=0; i<n; i++) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			p.add(new Vector2d(x, y));
		}
		sc.close();
		System.out.println(solve(p));
	}

	static class Vector2d {
		Vector2d(Double x, Double y){
			this.x = x;
			this.y = y;
		}
		Double x;
		Double y;
		public String toString() {
			return String.format("%1$.10f %2$.10f", x, y);
		}
	}

	public static Vector2d sub(Vector2d v1, Vector2d v2){
		return new Vector2d(v2.x - v1.x, v2.y - v1.y);
	}

	public static int solve(List<Vector2d> p) {
		boolean ans = true;
		int s = p.size();
		for (int i=0; i<s; i++) {
			Vector2d a = sub(p.get(i), p.get((i+1)%s));
			Vector2d b = sub(p.get((i+1)%s), p.get((i+2)%s));
			ans = ans && ((a.x * b.y - a.y * b.x) >= 0);
		}
		return ans ? 1 : 0;
	}
}

