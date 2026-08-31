import java.io.PrintWriter;
import java.util.Scanner;

public class BEAR {
	public static void main(String[] args) {
		Scanner br = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int Days = br.nextInt()-1;
		int kilos = br.nextInt();
		int num = 0;
		int x = br.nextInt();
		while (Days-- > 0) {
			int y = br.nextInt();
			if (x > y) {
				if (num < x - y - kilos)
					num = x - y - kilos;
			}
			x=y;
		}
		out.println(num);
		out.flush();
		out.close();

	}

}
