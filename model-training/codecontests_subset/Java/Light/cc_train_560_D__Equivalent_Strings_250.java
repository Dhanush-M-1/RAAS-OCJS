import java.io.*;

public class D {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = lexicalMinimal(br.readLine());
		String s2 = lexicalMinimal(br.readLine());
		if(s1.equals(s2)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static String lexicalMinimal(String s) {
		if(s.length() % 2 == 1) return s;
		String part1 = lexicalMinimal(s.substring(0, s.length()/2));
		String part2 = lexicalMinimal(s.substring(s.length()/2, s.length()));

		if(part1.compareTo(part2) >= 0) return part2.concat(part1);
		else return part1.concat(part2);
	}
}