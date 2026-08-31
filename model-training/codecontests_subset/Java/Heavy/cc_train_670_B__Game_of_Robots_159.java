import java.io.*;
public class Snowball {
	private static int n;
	private static long k;
	private static BufferedReader stdin;
	public static void main(String[] args) {
		try {
			stdin = new BufferedReader(new InputStreamReader(System.in));
			args = stdin.readLine().split(" ");
			n = Integer.parseInt(args[0]);
			k = Long.parseLong(args[1]);
			args = stdin.readLine().split(" ");
			int[] order = new int[n];
			for (int i = 0; i < n; i++) {
				order[i] = Integer.parseInt(args[i]);
			}
			long t = ((int) Math.sqrt(8*k - 7) - 1)/2;
			//System.out.println(t);
			System.out.println(order[(int) (k - 1 - t*(t + 1)/2)]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
