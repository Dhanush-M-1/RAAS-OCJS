import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(); 
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		for (int i = 1; i <= m; i++)
			a.add(i);
		
		for (int i = 0; i < n; i++) {
			int k = scn.nextInt();
			for (int j = 0; j < k; j++)
				a.remove((Integer) scn.nextInt());
		}
		
		System.out.println(a.isEmpty() ? "YES" : "NO");
		scn.close();
	}
}
