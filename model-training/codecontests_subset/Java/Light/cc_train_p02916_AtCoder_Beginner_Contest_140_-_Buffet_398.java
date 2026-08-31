import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.next());

		int[][] man = new int[3][n];
		int total = 0;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				man[i][j] = Integer.parseInt(sc.next());
			}
		}

		for (int i = 0; i < n-1; i++) {
			man[2][i] = Integer.parseInt(sc.next());
		}

		for(int i = 0; i < n; i++) {
			total += man[1][i];
		}

		for (int i = 0; i < n-1; i++) {
			if(man[0][i]==man[0][i+1]-1) {
				total+=man[2][man[0][i]-1];
			}
		}

		System.out.println(total);
	}
}