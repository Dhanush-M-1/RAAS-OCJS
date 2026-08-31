import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int ans0 = 0;
		int ans1 = 0;
		
		while(stdIn.hasNext()) {
			String tmp = stdIn.next();
			String[] tmp2 = tmp.split(",");
			
			int a = Integer.parseInt(tmp2[0]);
			int b = Integer.parseInt(tmp2[1]);
			int c = Integer.parseInt(tmp2[2]);
			
			if(a * a + b * b == c * c) {
				ans0++;
			}
			else {
				if(a == b) {
					ans1++;
				}
			}
		}
		System.out.println(ans0 + "\n"+ ans1);

	}

}