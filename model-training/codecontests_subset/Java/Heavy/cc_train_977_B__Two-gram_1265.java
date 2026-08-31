import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String cad = sc.nextLine();
		Set<String> s = new HashSet<String>();
		String cc = "";
		String sub = "";
		for (int i = 1; i < cad.length(); i++) {
			char g1 = cad.charAt(i - 1);
			char g2 = cad.charAt(i);
			sub = Character.toString(g1) + Character.toString(g2);
			s.add(sub);
		}
		Object x[] = s.toArray();
		int c = 0;
		String ss = "";
		int mayor = 0;
		for (int i = 0; i < x.length; i++) {
			String gg = (String) x[i];
			for (int j = 1; j < cad.length(); j++) {
				char g1 = cad.charAt(j - 1);
				char g2 = cad.charAt(j);
				sub = Character.toString(g1) + Character.toString(g2);
				if (sub.equals(gg)) {
					c++;
				}
			}
			if (c > mayor) {
				mayor = c;
				ss = gg;
			}
			c = 0;
			sub = "";
		}
		System.out.println(ss);
////
	}

}