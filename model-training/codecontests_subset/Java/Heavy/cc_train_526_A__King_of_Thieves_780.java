import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Base {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String lvl = br.readLine();
		
		boolean b = false;
		a:for (int j = 1; j <= (n-1)/4; j++) {
			for (int i = 0; i < n-j*4; i++) {
				if (lvl.charAt(i) == '*' && lvl.charAt(i+j) == '*' && lvl.charAt(i+2*j) == '*' && lvl.charAt(i+3*j) == '*' && lvl.charAt(i+4*j) == '*'){
					b = true;
					break a;
				}
			}
		}
		System.out.println(b?"yes":"no");
	}
}
