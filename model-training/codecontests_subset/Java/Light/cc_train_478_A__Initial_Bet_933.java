import java.util.*;
import java.io.*;
public class A {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintStream out = System.out;
		String line = in.readLine();
		String[] strs = line.split(" ");
		int[] coins = new int[5];
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			coins[i] = Integer.parseInt(strs[i]);
			sum += coins[i];
		}
		out.println(sum % 5 != 0 || sum == 0 ? -1 : sum / 5);
	}
}