import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] ss = new int[n][2];
		int [][] cps  = new int[m][2];
		
		for(int[] s:ss) {
			s[0] = sc.nextInt();
			s[1] = sc.nextInt();
		}
		for(int[] cp:cps) {
			cp[0] = sc.nextInt();
			cp[1] = sc.nextInt();
		}
		
		for(int i = 0; i<n; i++) {
			int number = 1;
			int d;
			int fd = Math.abs(ss[i][0]-cps[0][0]) + Math.abs(ss[i][1]-cps[0][1]);
			for(int j = 1; j<m; j++) {
				d = Math.abs(ss[i][0]-cps[j][0]) + Math.abs(ss[i][1]-cps[j][1]);
				if(d<fd) {
					fd = d;
					number = j+1;
				}
			}
			System.out.println(number);
		}

	}

}
