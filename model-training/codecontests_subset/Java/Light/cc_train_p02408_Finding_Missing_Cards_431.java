import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String design;
		int num;
		String[] mark = {"S", "H", "C", "D"};
		
		boolean[] tramp = new boolean[52];		// spade,heart,clover,diamond??????
		
		for (int i = 0; i < n; i++) {
			
			design = scan.next();
			num = scan.nextInt();
			if (design.equals("S")) {
				tramp[num - 1] = true;
			} else if (design.equals("H")) {
				tramp[num + 13 - 1] = true;
			} else if (design.equals("C")) {
				tramp[num + 26 - 1] = true;
			} else if (design.equals("D")) {
				tramp[num + 39 - 1] = true;
			}
			
		}
		
		for (int i = 0; i < 52; i++) {
			if (tramp[i] == false) {
				System.out.println(mark[i/13] + " " + (i % 13 + 1));
			}
		}
	}

}