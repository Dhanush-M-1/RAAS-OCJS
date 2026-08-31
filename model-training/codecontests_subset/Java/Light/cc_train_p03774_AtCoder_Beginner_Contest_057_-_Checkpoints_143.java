import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(),M = sc.nextInt();
		int students[][] = new int [N][2];
		int cp[][] = new int [M][2];

		for(int i = 0; i < N;i++) {
			students[i][0] = sc.nextInt();
			students[i][1] = sc.nextInt();
		}

		for(int i = 0; i < M;i++) {
			cp[i][0] = sc.nextInt();
			cp[i][1] = sc.nextInt();
		}

		for (int[] student : students) {
			int distance = 1000000000;
			int ans = 0;
			for (int i = 0; i < cp.length ; i++){
				int[] p = cp[i];
				int xy = Math.abs(student[0] - p[0]) + Math.abs(student[1] - p[1]);
				if(distance > xy) {
					distance = xy;
					ans = i+1;
				}
			}
			System.out.println(ans);
		}
	}
}