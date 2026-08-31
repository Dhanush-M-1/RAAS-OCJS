import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int student[][]=new int[n][2];
		int checkp[][]=new int[m][2];
		for(int i=0;i<n;i++) {
			student[i][0]=scan.nextInt();
			student[i][1]=scan.nextInt();
		}
		for(int i=0;i<m;i++) {
			checkp[i][0]=scan.nextInt();
			checkp[i][1]=scan.nextInt();
		}
		scan.close();

		for(int i=0;i<n;i++) {
			int min=Integer.MAX_VALUE;
			int min_num=0;
			for(int j=0;j<m;j++) {
				int distance = Math.abs(student[i][0]-checkp[j][0])+Math.abs(student[i][1]-checkp[j][1]);
				if(distance<min) {
					min=distance;
					min_num=j+1;
				}
			}
			System.out.println(min_num);
		}
	}
}