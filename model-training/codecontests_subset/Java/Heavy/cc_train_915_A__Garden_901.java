import java.util.*;
import java.io.*;

public class test {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(s.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		StringTokenizer ts = new StringTokenizer(s.nextLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(ts.nextToken());
		}

		int minHours = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (k % arr[i] == 0 && k / arr[i] < minHours) {
				minHours = k / arr[i];
			}
		}
		System.out.println(minHours);
		s.close();
	}
}
