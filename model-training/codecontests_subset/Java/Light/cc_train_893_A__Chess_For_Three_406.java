import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chess {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int a = Integer.parseInt(in.readLine());
		if(a == 3) {
			System.out.println("NO");
		} else {
			int b = 3;
			int c = 3 - a;
			for(int i = 1;i<n;i++) {
				int j = Integer.parseInt(in.readLine());
				if(j == a || j == b) {
					int temp = (a+b) - j;
					a = j;
					b = c;
					c = temp;
				} else {
					System.out.println("NO");
					return;
				}
			}
			System.out.println("YES");
			
		}
		
	}
}
