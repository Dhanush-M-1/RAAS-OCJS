import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> matches = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(sc.nextInt());
			temp.add(sc.nextInt());
			matches.add(temp);
		}
		sc.close();
		int result = 0;
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> pair = matches.get(i);
			for (int j = 0; j < n; j++) {
				if (j != i && pair.get(1) == matches.get(j).get(0)) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
