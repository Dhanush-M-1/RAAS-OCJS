import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		StringBuilder str = new StringBuilder();
		rec(0, N, 0, new char[N], str);
		System.out.println(str.toString());
	}

	static void rec(int depth, int N, int used, char[] cur, StringBuilder str) {
		if ( depth == N ) {
			str.append(new String(cur));
			str.append("\n");
			return;
		}
		for ( int i = 0 ; i < used + 1 ; i++ ) {
			cur[depth] = (char)('a' + i);
			rec(depth + 1, N, i == used ? used + 1: used , cur ,str);
		}
	}
}
