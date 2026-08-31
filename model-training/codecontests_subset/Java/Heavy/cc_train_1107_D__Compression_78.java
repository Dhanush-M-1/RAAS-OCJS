import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static int getValue(char ch) {
		
		if (ch >= '0' && ch <= '9') {
			return ch - '0';
		} else {
			return (int) (ch - 'A' + 10);
		}
		
	}
	
	private static boolean check(int n , int size) {
		
		int i , j;
		for (i = size;i <= n;i += size) {
			for (j = size;j <= n;j += size) {
				int x1 = i - size + 1 , y1 = j - size + 1;
				int x2 = i , y2 = j;				
				long value = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];				
				if (value == 0) {
					continue;
				} else if (value == (long) size * (long) size) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
		
	}
	
	private static long[][] sum = new long[5300][5300];	
	private static String[] input = new String[5300];
	
	public static void main(String[] args) {			
	
		Scanner scan = new Scanner(System.in);

		int i , j , k , n = scan.nextInt();
		for (i = 1;i <= n;i ++) {
			input[i] = scan.next();
			input[i] = " " + input[i];			
		}		
		for (i = 1;i <= n;i ++) {
			for (j = 1;j <= n;j += 4) {				
				int value = getValue(input[i].charAt(j / 4 + 1));				
				for (k = 3;k >= 0;k --) {
					int index = j + (3 - k);
					if ((value & (1 << k)) != 0) {
						sum[i][index] ++;
					}					
					sum[i][index] = (sum[i][index] + sum[i - 1][index] + sum[i][index - 1] - sum[i - 1][index - 1]);
				}
			}
		}			
		
		int ans = - 1;
		List<Integer> list = new ArrayList<>();		
		for (i = 1;i * i <= n;i ++) {
			if (n % i == 0) {
				// check size i
				list.add(i);				
				if (i * i != n) {
					list.add(n / i);
				}		
			}				
		}		
		Collections.sort(list , Collections.reverseOrder());
		for (int size : list) {
			if (check(n , size)) {
				ans = size;
				break;				
			}
		}
		System.out.println(ans);

	}
	
}














	