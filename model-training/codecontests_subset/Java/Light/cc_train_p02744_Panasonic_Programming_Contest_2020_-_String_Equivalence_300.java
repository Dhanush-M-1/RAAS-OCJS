import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static boolean nextPermutation(int[] a) {
		for (int i = a.length - 1; i > 0; --i) {
			if (a[i - 1] < a[i]) {
				int swapIndex = find(a[i - 1], a, i, a.length - 1);
				int temp = a[swapIndex];
				a[swapIndex] = a[i - 1];
				a[i - 1] = temp;
				Arrays.sort(a, i, a.length);
				return true;
			}
		}
		return false;
	}

	// destより大きい要素の中で最小のもののインデックスを二分探索で探す
	private static int find(int dest, int[] a, int s, int e) {
		if (s == e) {
			return s;
		}
		int m = (s + e + 1) / 2;
		return a[m] <= dest ? find(dest, a, s, m - 1) : find(dest, a, m, e);
	}

	static void listup(int arr[], Set<String> result, int N) {
		int perm[] = new int[N];
		int idx = 0;
		for (int a = 0; a < arr.length; ++a) {
			for (int j = 0; j < arr[a]; ++j) {
				if(arr[a] == 1){
					perm[idx++] = -1;
				}else{
					perm[idx++] = a;					
				}
			}
		}
		do {
			StringBuilder sb = new StringBuilder();
			int map[] = new int[arr.length];
			Arrays.fill(map, -1);
			int m = 0;
			for (int i = 0; i < perm.length; ++i) {
				int v = perm[i];
				if(v < 0){
					char c = (char) ('a' + m);
					m++;
					sb.append(c);
				}else{
					if (map[v] < 0) {
						map[v] = m;
						m++;
					}
					char c = (char) ('a' + map[v]);
					sb.append(c);					
				}
			}
			result.add(sb.toString());
			// System.out.println(Arrays.toString(perm)+" "+sb);
		} while (nextPermutation(perm));
	}

	static void rec(int N, int K, int[] arr, int i, int up, Set<String> result,
			int L) {
		if (K == 0) {
			if (N == 0) {
//				System.out.println(Arrays.toString(arr));
				listup(arr, result, L);
			}
			return;
		}
		for (int u = up; u <= N; ++u) {
			arr[i] = u;
			rec(N - u, K - 1, arr, i + 1, u, result, L);
			arr[i] = 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Set<String> result = new TreeSet<String>();
		for (int K = 1; K < N; ++K) {
			// System.out.println(K);
			int arr[] = new int[K];
			rec(N, K, arr, 0, 1, result, N);
		}
		// K == N
		String sb = "";
		for(int i = 0 ; i < N ; ++i){
			sb = sb + (char)('a' + i);
		}
		result.add(sb);
//		System.out.println(result.size());
		for (String r : result) {
			System.out.println(r);
		}
	}
}
