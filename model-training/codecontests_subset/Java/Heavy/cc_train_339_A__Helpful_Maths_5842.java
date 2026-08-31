import java.util.Scanner;

public class Codeforces_jadnie_algoritmi {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
			int b = 0,d = 0,u = 0;	
				String s = in.next();
					for (int i=0; i<s.length(); i++) {
						if (s.charAt(i) == '1') b++;
						if (s.charAt(i) == '2') d++;
						if (s.charAt(i) == '3') u++;
					}
					while(b-- > 0)
						if (d > 0 || u > 0 || b >= 1)
							System.out.print("1+");
						else
							System.out.print(1);
					
					while(d-- > 0)
						if (d >= 1 || u > 0)
							System.out.print("2+");
						else
							System.out.print(2);
					
					while(u-- > 0)
						if (u >= 1)
							System.out.print("3+");
						else
							System.out.print(3);
	}
}
