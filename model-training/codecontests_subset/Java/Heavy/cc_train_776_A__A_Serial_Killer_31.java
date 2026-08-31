import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF400A {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		// int a = reader.nextInt();
		// int b = reader.nextInt();
		String a = reader.next();
		String b = reader.next();
		int n = reader.nextInt();
		String[][] names = new String[n][2];
		// int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			names[i][0] = reader.next();
			names[i][1] = reader.next();
		}
		Set<String> pair = new HashSet<>();
		pair.add(a);
		pair.add(b);
		System.out.print(a + " " + b + "\n");
		for (int i = 0; i < n; i++) {
			pair.remove(names[i][0]);
			pair.add(names[i][1]);
			for (String str : pair)
				System.out.print(str + " ");
			System.out.println();
		}
	}

}
