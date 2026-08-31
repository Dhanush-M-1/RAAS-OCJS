import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Task195A {

	public static void main(String... args) throws NumberFormatException,
			IOException {
		Solution.main(System.in, System.out);
	}

	static class Solution {
		public static void main(InputStream is, OutputStream os)
				throws NumberFormatException, IOException {
			PrintWriter pw = new PrintWriter(os);
			Scanner s = new Scanner(is);

			int a = s.nextInt();
			int b = s.nextInt();
			int c = s.nextInt();

			int retVal = Math.max((a * c + b - 1) / b - c, 0);

			pw.println(retVal);

			pw.flush();
			s.close();
		}

	}

}
