import java.util.Scanner;

public class Main {
	static int user, bytes, traffic, total;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String comando = in.nextLine();
			if (comando.charAt(0) == '+') {
				user++;
			} else if (comando.charAt(0) == '-') {
				user--;
			} else {
				int começo = comando.indexOf(':') + 1;
				bytes = comando.length() - começo;
				total = bytes * user;

			}
			traffic = traffic + total;
			total = 0;
			bytes = 0;
			
		}
		System.out.println(traffic);
	}
}
// 1520041158335
