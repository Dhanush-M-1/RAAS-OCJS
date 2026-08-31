import java.util.Scanner;


public class Fox_Cheese {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int[] num = new int[2];
		num[0] = scanner.nextInt();
		num[1] = scanner.nextInt();
		if (num[0] == num[1]) {
			System.out.print(0);
			return;
		}
		
		int num_dids[][] = new int[2][3];
		for (int i = 0; i < 2; ++i) {
			boolean is_change = true; 
			while (is_change) {
				is_change = false;
				if (num[i]%2 == 0) {
					++num_dids[i][0];
					num[i] = num[i]/2;
					is_change = true;
				}
				
				if (num[i]%3 == 0) {
					++num_dids[i][1];
					num[i] = num[i]/3;
					is_change = true;
				}
				
				if (num[i]%5 == 0) {
					++num_dids[i][2];
					num[i] = num[i]/5;
					is_change = true;
				}
			}
		}
		
		if (num[0] != num[1]) {
			System.out.print(-1);
		} else {
			int sum_ch = 0;
			for (int i = 0; i < 3; ++i) {
				sum_ch += Math.abs(num_dids[0][i] - num_dids[1][i]);
			}
			System.out.print(sum_ch);
		}
	}

}
