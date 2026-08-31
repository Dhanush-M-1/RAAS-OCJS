import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

public class Task005A {

	public static void main(String... args) throws NumberFormatException,
			IOException {
		Solution.main(System.in, System.out);
	}

	static class Solution {

		public static void main(InputStream is, OutputStream os)
				throws NumberFormatException, IOException {
			PrintWriter pw = new PrintWriter(os);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String command = null;
			Set<String> users = new TreeSet<>();
			int retVal = 0;

			while ((command = br.readLine()) != null) {
				if (command.startsWith("+")) {
					users.add(command.substring(1));
				} else if (command.startsWith("-")) {
					users.remove(command.substring(1));
				} else {
					int colonPos = command.indexOf(":");
					retVal += users.size() * (command.length() - colonPos - 1);
				}
			}

			pw.println(retVal);
			pw.flush();
			br.close();
		}
	}

}