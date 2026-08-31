import java.util.Scanner;

public class pocker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String allin = "A";
		String folded = "F";
		String in = "I"; 
		int t = 0; 
		int n = sc.nextInt();
		int ty = 0;
		String ni = sc.next();

		for (int i = 0; i < n; i++) {
			String tmp = ni.substring(i, i + 1);
			if (tmp.equals("A")) {
				t++;
			}
			if (tmp.equals("I")) {
				ty++;

			}
		}
		if (ty > 1) {
			System.out.println("0");
		}
	    else if (ty == 1) {
			System.out.println("1");
		} else {
			System.out.println(t);

		}
	}
}