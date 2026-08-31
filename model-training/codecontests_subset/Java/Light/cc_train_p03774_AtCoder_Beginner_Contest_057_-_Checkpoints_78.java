import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int n = sc.nextInt();
			int m = sc.nextInt();
			sc.nextLine();

			List<int[]> student = new ArrayList<int[]>();
			for (int i = 0; i < n; i++) {
				student.add(new int[] {sc.nextInt(), sc.nextInt(), Integer.MAX_VALUE, 0});
				sc.nextLine();
			}

			int manhattan = 0;
			for (int j = 0; j < m; j++) {
				int cj = sc.nextInt();
				int dj = sc.nextInt();
				for (int i = 0; i < n; i++) {
					int[] si = student.get(i);
					manhattan = Math.abs(si[0] - cj) + Math.abs(si[1] - dj);
					if (manhattan < si[2]) {
						si[2] = manhattan;
						si[3] = j;
					}
				}
				sc.nextLine();
			}

			student.stream().forEach(e -> System.out.println(e[3] + 1));

		} finally {
			sc.close();
		}
	}
}