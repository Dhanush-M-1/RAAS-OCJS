import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem526A {

	public static void main(String[] args) {
		Problem526A instance = new Problem526A();
		BufferedReader bfr = null;

		try {
			bfr = new BufferedReader(new InputStreamReader(System.in));
			String line = "";
			int n = 0;
			if ((line = bfr.readLine()) != null) {

				n = Integer.parseInt(line);
			}
			if ((line = bfr.readLine()) != null) {

				String s = line.trim();
				if (s.length() != n) {
					throw new Exception("Invalid");
				}
				instance.process(s);
			}

		} catch (Throwable t) {
			System.err.println(t);
		} finally {
			if (bfr != null) {
				try {
					bfr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private void process(String s) {
		System.out.println(input(s));
	}
	
	private String input(String s){
		int[] level = new int[s.length()];
		int n = s.length();
		for (int i = 0; i < s.length(); i++) {
			level[i] = (s.charAt(i) == '*' ? 1 : 0);
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = 1; j < s.length(); j++) {
				int count = 0;
				for (int k = 0; k < 4; k++) {
					int i1 = i + k * j;
					int i2 = i + (k + 1) * j;
					if (i1 >= 0 && i1 < n && i2 >= 0 && i2 < n
							&& level[i1] == 1 && level[i2] == 1) {
						count++;
					}
				}
				if(count==4){
					return "yes";
				}
			}
		}
		return "no";
				
	}

}
