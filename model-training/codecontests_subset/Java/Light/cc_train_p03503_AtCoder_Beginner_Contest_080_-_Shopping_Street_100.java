import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] fArr = new int[n];
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < 10; j++) {
		        fArr[i] *= 2;
		        fArr[i] += sc.nextInt();
		    }
		}
		int[][] pArr = new int[n][11];
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j <= 10; j++) {
		        pArr[i][j] = sc.nextInt();
		    }
		}
		int max = Integer.MIN_VALUE;
		for (int target = 1; target < Math.pow(2, 10); target++) {
		    int sum = 0;
		    for (int i = 0; i < n; i++) {
		        int result = fArr[i] & target;
		        int count = 0;
		        while(result > 0) {
		            count += result % 2;
		            result /= 2;
		        }
		        sum += pArr[i][count];
		    }
		    max = Math.max(max, sum);
		}
       System.out.println(max);
	}
}
