import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] studentInfo = new int[n][2];
		int[][] checkPointInfo = new int[m][2];
		for(int i =0;i<n;i++) {
			studentInfo[i][0] = sc.nextInt();
			studentInfo[i][1] = sc.nextInt();
		}
		for(int i =0;i<m;i++) {
			checkPointInfo[i][0] = sc.nextInt();
			checkPointInfo[i][1] = sc.nextInt();
		}

		for(int i =0;i < n;i++) {
			int x = studentInfo[i][0];
			int y = studentInfo[i][1];
			int checkPoint = 0;
			int distance = Integer.MAX_VALUE;
			for(int j = 0; j <m;j++) {
				int distancej =(int)(Math.abs((double)(x -checkPointInfo[j][0]))
						+ Math.abs((double)(y -checkPointInfo[j][1])));
				if(distancej < distance) {
					checkPoint = j+1;
					distance = distancej;
				}
			}
			System.out.println(checkPoint);
		}
	}
}