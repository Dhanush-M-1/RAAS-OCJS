import java.util.Scanner;

public class RoadToPostOffice {
	static Node[][] f;
	static String kVal;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long k = in.nextLong();
		int[] a = new int[n];
		int[] w = new int[n];
		f = new Node[34][n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		for (int i = 0; i < n; i++)
			w[i] = in.nextInt();

		for (int i = 0; i < n; i++) {
			f[0][i] = new Node(a[i], w[i], w[i]);
		}

		for (int i = 1; i < 34; i++) {
			for (int j = 0; j < n; j++) {
				int to = f[i - 1][f[i - 1][j].to].to;
				long sum = f[i - 1][j].sum + f[i - 1][f[i - 1][j].to].sum;
				int min = Math.min(f[i - 1][j].min, f[i - 1][f[i - 1][j].to].min);
				f[i][j] = new Node(to, sum, min);
			}
		}
		kVal = Long.toBinaryString(k);
		for (int i = 0; i < n; i++) {
			Node result = get(i);
			System.out.println(result.sum + " " + result.min);
		}
	}

	public static Node get(int start) {
		Node result = new Node(start, 0, Integer.MAX_VALUE);
		for (int i = 0; i < kVal.length(); i++) {
			if (kVal.charAt(i) == '1') {
				int usefulSum = kVal.length() - i - 1;
				result = new Node(f[usefulSum][result.to].to, result.sum + f[usefulSum][result.to].sum,
						Math.min(result.min, f[usefulSum][result.to].min));
			}
		}
		return result;
	}
}

class Node {
	int to;
	long sum;
	int min;

	public Node(int x, long y, int z) {
		this.to = x;
		this.sum = y;
		this.min = z;
	}
}
