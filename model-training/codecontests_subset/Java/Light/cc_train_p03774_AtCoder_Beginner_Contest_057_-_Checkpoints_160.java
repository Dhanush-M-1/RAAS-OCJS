import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		List<Coordinate> st = new ArrayList<>();
		List<Coordinate> ch = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st.add(new Coordinate(scanner.nextInt(), scanner.nextInt()));
		}
		for (int i = 0; i < m; i++) {
			ch.add(new Coordinate(scanner.nextInt(), scanner.nextInt()));
		}

		long min = 1000000000;
		int[] index = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (min > Math.abs(st.get(i).x - ch.get(j).x) + Math.abs(st.get(i).y - ch.get(j).y)) {
					index[i] = j;
				}
				min = Math.min(min, Math.abs(st.get(i).x - ch.get(j).x) + Math.abs(st.get(i).y - ch.get(j).y));
			}
			min = 1000000000;
		}
		for (int i = 0; i < n; i++) {
			System.out.println(index[i] + 1);
		}
	}
}

class Coordinate {
	long x;
	long y;

	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}