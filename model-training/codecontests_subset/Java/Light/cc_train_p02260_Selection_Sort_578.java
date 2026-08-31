import java.util.Scanner;

public class Main {
	public static void main(String[] arges) {

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int v = Integer.parseInt(line);
		int[] vs = new int[v];
		String line2 = sc.nextLine();
		String[] k = line2.split(" ");
		for (int i = 0; i < v; i++) {
			vs[i] = Integer.parseInt(k[i]);
		}
		int count = 0;
		for (int i = 0; i < v; i++) {
			int min = i;

			for (int l = i; l < v; l++) {
				if (vs[min] > vs[l]) {
					min = l;
				}
			}
			if (min != i) {
				int a =vs[min];
				int b = vs[i];
				vs[min]=b;
				vs[i]=a;
				count++;
			}
		}
		for (int i = 0; i < v - 1; i++) {
			System.out.print(vs[i]+" ");
		}
		System.out.println(vs[v - 1]);
		System.out.println(count);
	}
}