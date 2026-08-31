import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int val;
		while ((val = getInt(br)) != 0) {
			int month = 0;
			for (int i = 1; i <= 12; i++) {
				String s = br.readLine();
				if (month == 0) {
					val -= Integer.parseInt(s.substring(0, s.indexOf(" ")));
					val += Integer.parseInt(s.substring(s.indexOf(" ") + 1));
					if (val <= 0) {
						month = i;
					}
				}
			}
			System.out.println(month > 0 ? (month) : "NA");
		}

	}

	private static int getInt(BufferedReader br) throws IOException {
		return Integer.parseInt(br.readLine());
	}

}