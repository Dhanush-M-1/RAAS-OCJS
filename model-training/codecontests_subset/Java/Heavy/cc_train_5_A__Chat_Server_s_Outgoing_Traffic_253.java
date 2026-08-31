import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int trafego = 0;
		int total = 0;
		String msg;
		while (in.hasNext()) {

			String proximo = in.nextLine();
			if ((proximo.charAt(0) == '+') || (proximo.charAt(0) == '-')) {
				if (proximo.charAt(0) == '+') {
					total++;
				}
				if (proximo.charAt(0) == '-') {
					total--;
				}
			} else {
				for (int i = 0; i < proximo.length(); i++) {
					if (proximo.charAt(i) == ':') {
						msg = proximo.substring(i + 1);
						trafego = trafego + (msg.length() * total);
					}
				}
			}

		}
		System.out.println(trafego);
	}

}
