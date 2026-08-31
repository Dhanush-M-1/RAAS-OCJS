import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";

		int cost = Integer.parseInt(br.readLine());
		int month = 0;
		boolean more = true;
		StringBuilder sb = new StringBuilder();

		while (true) {

			line = br.readLine();
			if (line == null || line.isEmpty())
				break;

			if (line.contains(" ") && more) {
				int in = Integer.parseInt(line.substring(0, line.indexOf(' ')));
				int out = Integer
						.parseInt(line.substring(line.indexOf(' ') + 1));
				cost -= in - out;
				month++;
				if (cost <= 0) {
					more = false;
					continue;
				}
			} else if (!line.contains(" ") && !line.equals("0")) {
				if (cost <= 0) {
					sb.append(month + "\n");
				} else {
					sb.append("NA\n");
				}
				cost = Integer.parseInt(line);
				month = 0;
				more = true;
			} else if (line.equals("0")) {
				if (cost <= 0) {
					sb.append(month + "\n");
				} else {
					sb.append("NA\n");
				}
			}
		}
		System.out.print(sb.toString());
	}
}