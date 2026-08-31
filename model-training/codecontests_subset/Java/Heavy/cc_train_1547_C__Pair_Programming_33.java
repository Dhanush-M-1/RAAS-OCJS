
import java.util.*;
import java.lang.*;
import java.io.*;

public class C {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		br.readLine();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			String[] scn = (br.readLine()).trim().split(" ");
			int k = Integer.parseInt(scn[0]);
			int n = Integer.parseInt(scn[1]);
			int m = Integer.parseInt(scn[2]);
			long[] arr = new long[n];
			scn = (br.readLine()).trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(scn[i]);
			}
			long[] brr = new long[m];
			scn = (br.readLine()).trim().split(" ");
			for (int i = 0; i < m; i++) {
				brr[i] = Long.parseLong(scn[i]);
			}

			ArrayList<Long> list = new ArrayList<>();
			int i = 0, j = 0;
			boolean pos = true;
			while (i < n && j < m) {
				if (arr[i] <= k) {
					list.add(arr[i]);
					if (arr[i] == 0)
						k += 1;
					i += 1;
				} else if (brr[j] <= k) {
					list.add(brr[j]);
					if (brr[j] == 0)
						k += 1;
					j += 1;
				} else {
					pos = false;
					break;

				}
			}
			while (i < n) {
				if (arr[i] <= k) {
					list.add(arr[i]);
					if (arr[i] == 0)
						k += 1;
					i += 1;
				} else {
					pos = false;
break;
				}
			}
			while (j < m) {
				if (brr[j] <= k) {
					list.add(brr[j]);
					if (brr[j] == 0)
						k += 1;
					j += 1;
				} else {
					pos = false;
break;
				}
			}

			if (!pos) {
				sb.append("-1");
			} else {
				for (long ele : list) {
					sb.append(ele + " ");
				}
			}
			sb.append("\n");
			if (t != 0) {
				br.readLine();
			}
		}
		System.out.println(sb);
		return;

	}

	public static void sort(long[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int idx = (int) (Math.random() * n);
			long temp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = temp;
		}
		Arrays.sort(arr);
	}

	public static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int idx = (int) (Math.random() * n);
			int temp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = temp;
		}
		Arrays.sort(arr);
	}

	public static void print(long[][] dp) {
		for (long[] a : dp) {
			for (long ele : a) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}

	public static void print(int[][] dp) {
		for (int[] a : dp) {
			for (int ele : a) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}

	public static void print(int[] dp) {
		for (int ele : dp) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}

	public static void print(long[] dp) {
		for (long ele : dp) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}

}
