import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] students = new int[n][2];
		int[][] checkpoints = new int[m][2];
				
		for (int i = 0; i < n; i++) {
			students[i][0] = in.nextInt();
			students[i][1] = in.nextInt();
		}
		
		for (int i = 0; i < m; i++) {
			checkpoints[i][0] = in.nextInt();
			checkpoints[i][1] = in.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			int checkpoint = 0;
			int prevRes = Math.abs(students[i][0] - checkpoints[0][0]) + 
					Math.abs(students[i][1] - checkpoints[0][1]);

			for (int j = 0; j < m; j++){
				int tmpRes = Math.abs(students[i][0] - checkpoints[j][0]) + 
						Math.abs(students[i][1] - checkpoints[j][1]);
				if (tmpRes < prevRes) {
					checkpoint = j;
					prevRes = tmpRes;
				}
			}
			System.out.println((int)checkpoint + 1);
		}
		in.close();
	}
}
