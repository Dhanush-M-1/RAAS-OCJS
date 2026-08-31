import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int count = Integer.parseInt(br.readLine());
			int number[] = new int[count];
			int result[] = new int[count];
			for (int i = 0; i < count; i++) {
				String s = br.readLine();
				number[i] = Integer.parseInt(s);
				while (true) {
					if (number[i] < 10)
						break;
					s = String.valueOf(number[i]);
					int two[] = new int[s.length() - 1];
					int max = 0;
					for (int j = 0; j < s.length() - 1; j++) {
						String s1 = s.substring(0, j + 1);
						String s2 = s.substring(j + 1, s.length());
						two[j] = Integer.parseInt(s1) * Integer.parseInt(s2);
					}
					for (int j = 0; j < two.length; j++) {
						max = Math.max(max, two[j]);
					}
					number[i] = max;
					result[i]++;
				}
			}
			for (int i = 0; i < count; i++) {
				System.out.println(result[i]);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
