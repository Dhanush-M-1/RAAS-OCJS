import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5A {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int res = 0;
		int n = 0;
		String m;
		while ((m = in.readLine()) != null) {
			if (m.charAt(0) == '+') {
				n++;
			} else if (m.charAt(0) == '-') {
				n--;
			} else {
				res += ((m.length() - m.indexOf(':') - 1) * n);
			}		
		}
		System.out.print(res);
	}
}