import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] nums = new int[4][13];
		
		for (int i = 0; i < n; i++) {
			String suit = sc.next();
			int num = sc.nextInt();
			
			if ("S".equals(suit)) {
				nums[0][num - 1] = 1;
			} else if ("H".equals(suit)) {
				nums[1][num - 1] = 1;
			} else if ("C".equals(suit)) {
				nums[2][num - 1] = 1;
			} else {
				nums[3][num - 1] = 1;
			}
		}
		
		for (int i = 0; i < 4; i++) {
			String suit = "S";
			
			if (i == 0) {
				suit = "S";
			} else if (i == 1) {
				suit = "H";
			} else if (i == 2) {
				suit = "C";
			} else {
				suit = "D";
			}
			
			for (int j = 0; j < 13; j++) {
				if (nums[i][j] == 0) {
					System.out.println(suit + " " + (j + 1));
				}
			}
		}
	}
}

