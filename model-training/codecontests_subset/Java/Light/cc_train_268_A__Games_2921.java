import java.util.*;
public class Za {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int teams = sc.nextInt();
		int [][] forms = new int [teams][2];
		int count = 0;
		for (int k = 0; k < teams; k++) {
			for (int l = 0; l < 2; l++)
				forms [k][l] = sc.nextInt();
		}
		for (int i = 0; i < teams; i++) {
			for (int j = 0; j < teams; j++) {
				if (forms [i][0] == forms [j][1])
					count++;
			}
		}
		System.out.print(count);
	}
}