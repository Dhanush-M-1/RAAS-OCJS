import java.util.Scanner;

public class A_Bulbs_615 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[][] na = new int[n][m+1]; 
		for (int i = 0; i < n; i++) {
			na[i][0] = input.nextInt();
			for (int j = 1; j <= na[i][0]; j++) {
				na[i][j]=input.nextInt();
			}
		}
		int flag=0;
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 1; j2 <= na[j][0]; j2++) {
					if(i==na[j][j2]) {
						flag=1;
					}
				}
			}
			if(flag!=1) {
				System.out.println("NO");
				return;
			}
			flag=0;
		}
		
		System.out.println("YES");
		
	}
}