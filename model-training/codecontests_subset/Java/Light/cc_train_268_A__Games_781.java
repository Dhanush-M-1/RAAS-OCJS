import java.util.Scanner;

public class ques16 {

	public static void main (String[] args) {
		Scanner s= new Scanner(System.in);
		int n =s.nextInt();
		int [][] teams= new int[n][2];
		int sum=0;
		for (int i=0; i<n;i++) {
			for (int j=0; j<2; j++) {
				teams[i][j] = s.nextInt();}}
		for (int i=0; i<n;i++) {
			for (int j=0; j<n; j++) {
			//	teams[i][j] = s.nextInt();
				if (teams[i][0]==teams[j][1])
					sum++;
			}
		}
		System.out.println(sum);	
	}
}