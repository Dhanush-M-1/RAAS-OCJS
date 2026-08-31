import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class C1354 {
	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i< cases; i++) {
			double sides = scanner.nextInt() * 2;
			double ans = 0d;
			if(sides % 4 == 0)
				ans = 1d / Math.tan(Math.PI / sides);
			else
				ans = Math.cos(Math.PI / 2 / sides) / Math.sin(Math.PI / sides);
			log.write("" + ans + "\n");
		}
		log.flush();
	}
}
