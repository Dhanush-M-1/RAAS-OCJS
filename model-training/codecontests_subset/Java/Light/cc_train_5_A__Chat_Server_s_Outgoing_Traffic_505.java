import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a = 0;
		int pessoas = 0;
		do {
			String str = in.nextLine();
			String op[] = str.split("");
			if (op[0].equals("+")) {
				pessoas++;
			} else if (op[0].equals("-")) {
				pessoas--;
			} else {
				String b[] = str.split(":");
				if (b.length > 1) {
					String c[] = b[1].split("");
					a = a + (c.length * pessoas);
				}
			}
		} while (in.hasNext());
		System.out.println(a);
	}

}
