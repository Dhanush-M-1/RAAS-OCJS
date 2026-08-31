
import java.util.*;
import java.lang.*;
import java.io.*;

public class First {

//	            ***                          ++                      
//             +=-==+                      +++=-                     
//            +-:---==+                   *+=----=                   
//           +-:------==+               ++=------==                  
//           =-----------=++=========================                
//          +--:::::---:-----============-=======+++====             
//          +---:..:----::-===============-======+++++++++           
//          =---:...---:-===================---===++++++++++         
//          +----:...:-=======================--==+++++++++++        
//          +-:------====================++===---==++++===+++++      
//         +=-----======================+++++==---==+==-::=++**+     
//        +=-----================---=======++=========::.:-+*****    
//       +==::-====================--:  --:-====++=+===:..-=+*****   
//       +=---=====================-...  :=..:-=+++++++++===++*****  
//       +=---=====+=++++++++++++++++=-:::::-====+++++++++++++*****+ 
//      +=======++++++++++++=+++++++============++++++=======+****** 
//      +=====+++++++++++++++++++++++++==++++==++++++=:...  . .+**** 
//     ++====++++++++++++++++++++++++++++++++++++++++-.     ..-+**** 
//     +======++++++++++++++++++++++++++++++++===+====:.    ..:=++++ 
//     +===--=====+++++++++++++++++++++++++++=========-::....::-=++* 
//     ====--==========+++++++==+++===++++===========--:::....:=++*  
//     ====---===++++=====++++++==+++=======-::--===-:.  ....:-+++   
//     ==--=--====++++++++==+++++++++++======--::::...::::::-=+++    
//     ===----===++++++++++++++++++++============--=-==----==+++     
//     =--------====++++++++++++++++=====================+++++++     
//     =---------=======++++++++====+++=================++++++++     
//     -----------========+++++++++++++++=================+++++++    
//     =----------==========++++++++++=====================++++++++  
//     =====------==============+++++++===================+++==+++++ 
//     =======------==========================================++++++

	/*
	 * created by : Nitesh Gupta
	 * 
	 */

	public static void main(String[] args) throws Exception {

//		first();
//		sec();
//		third();
//		four();
//		fif();
//		six();
		sev();
	}

	private static void first() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] scn = (br.readLine()).trim().split(" ");
		int t = Integer.parseInt(scn[0]);
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			scn = (br.readLine()).trim().split(" ");
			int n = Integer.parseInt(scn[0]);
			long[] arr = new long[n];
			scn = (br.readLine()).trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(scn[i]);
			}
			int count = 0;

			for (int i = 0; i < n; i++) {
				if (i + 1 < n) {
					long min = Math.min(arr[i], arr[i + 1]);
					long max = Math.max(arr[i], arr[i + 1]);

					if (2 * min >= max) {

					} else {
						while (2 * min < max) {
							min = 2 * min;
							count += 1;
						}
					}

				}
			}
			sb.append(count);
			sb.append("\n");
		}
		System.out.println(sb);
		return;
	}

	private static void sec() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] scn = (br.readLine()).trim().split(" ");
		int t = Integer.parseInt(scn[0]);
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			scn = (br.readLine()).trim().split(" ");
			int n = Integer.parseInt(scn[0]);
			long[] arr = new long[n];
			scn = (br.readLine()).trim().split(" ");
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(scn[i]);
				int rem = (int) (arr[i] % 3);
				map.put(rem, map.getOrDefault(rem, 0) + 1);
			}
			int[] brr = new int[3];
			for (int key : map.keySet()) {
				brr[key] = map.get(key);
			}
			int op = 0;
			int max = n / 3;
			if (brr[0] < max) {
				int req = max - brr[0];
				int icg = Math.min(brr[2], req);
				op += icg;
				brr[0] += icg;
				brr[2] -= icg;
			}

			if (brr[0] < max) {
				int req = max - brr[0];
				int icg = Math.min(brr[1], req);
				op += 2 * icg;
				brr[0] += icg;
				brr[1] -= icg;
			}

			if (brr[1] < max) {
				int req = max - brr[1];
				int icg = Math.min(brr[0] - max, req);
				op += icg;
				brr[1] += icg;
				brr[0] -= icg;
			}

			if (brr[1] < max) {
				int req = max - brr[1];
				int icg = Math.min(brr[2], req);
				op += 2 * icg;
				brr[1] += icg;
				brr[2] -= icg;
			}
			if (brr[2] < max) {
				op += brr[0] - max + brr[0] - max + brr[1] - max;
			}

			sb.append(op);
			sb.append("\n");
		}
		System.out.println(sb);
		return;
	}

	private static void third() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] scn = (br.readLine()).trim().split(" ");
		int t = Integer.parseInt(scn[0]);
		StringBuilder sb = new StringBuilder();
		ArrayList<Long> cubes = new ArrayList<>();
		for (long i = 1; i * i * i <= (long) (1e12); i++) {
			cubes.add(i * i * i);

		}

		while (t-- > 0) {
			scn = (br.readLine()).trim().split(" ");
			long n = Long.parseLong(scn[0]);
			int s = cubes.size();
			int i = 0, j = s - 1;
			boolean found = false;
			while (i <= j) {
				long sum = cubes.get(i) + cubes.get(j);
				if (sum < n) {
					i++;
				} else if (sum > n) {
					j--;
				} else {
					found = true;
					break;
				}
			}
			if (!found) {
				sb.append("NO");
			} else {
				sb.append("YES");
			}

			sb.append("\n");
		}
		System.out.println(sb);
		return;
	}

	private static void four() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] scn = (br.readLine()).trim().split(" ");
		int t = Integer.parseInt(scn[0]);
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			scn = (br.readLine()).trim().split(" ");
			int n = Integer.parseInt(scn[0]);
			long[] arr = new long[n + 1];
			scn = (br.readLine()).trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i + 1] = Long.parseLong(scn[i]);
			}
			ht = new int[n + 1];
			int mid = fm(arr, 1, n);
			dfs(new boolean[n + 1], arr, ht, 0, mid, 1, mid - 1);
			dfs(new boolean[n + 1], arr, ht, 0, mid, mid + 1, n);
			for (int i = 1; i <= n; i++) {
				sb.append(ht[i] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		return;
	}

	static int[] ht;

	public static int fm(long[] arr, int l, int r) {
		if (l > r) {
			return -1;
		}
		long max = 0;
		int idx = -1;
		for (int i = l; i <= r; i++) {
			if (arr[i] > max) {
				max = arr[i];
				idx = i;
			}
		}
		return idx;
	}

	public static void dfs(boolean[] vis, long[] arr, int[] ht, int i, int src, int l, int r) {
		vis[src] = true;
		ht[src] = i;
		int mid = fm(arr, l, r);
		if (mid != -1) {
			dfs(vis, arr, ht, i + 1, mid, l, mid - 1);
			dfs(vis, arr, ht, i + 1, mid, mid + 1, r);
		}

	}

	static class pair {
		long ele;
		int idx;

		pair(long a, int b) {
			ele = a;
			idx = b;
		}
	}

	private static void fif() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] scn = (br.readLine()).trim().split(" ");
		int t = Integer.parseInt(scn[0]);
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			scn = (br.readLine()).trim().split(" ");
			int n = Integer.parseInt(scn[0]);
			pair[] arr = new pair[n];
			scn = (br.readLine()).trim().split(" ");
			long sum = 0;
			for (int i = 0; i < n; i++) {

				arr[i] = new pair(Long.parseLong(scn[i]), i + 1);
				sum += arr[i].ele;

			}
			for (int i = 0; i < n; i++) {
				int temp = (int) Math.random() * n;
				pair p = arr[temp];
				arr[temp] = arr[i];
				arr[i] = p;
			}
			Arrays.sort(arr, (th, ot) -> {
				if (th.ele == ot.ele) {
					return th.idx - ot.idx;
				}
				return th.ele - ot.ele > 0 ? 1 : -1;
			});
			ArrayList<Integer> list = new ArrayList<>();
			long max = sum;
			for (int i = n - 1; i >= 0; i--) {

				if (i + 1 < n) {
					max = Math.min(max, arr[i + 1].ele);
				}
				if (sum >= max) {
					list.add(arr[i].idx);
				} else {
					break;
				}
				sum -= arr[i].ele;
			}
			sb.append(list.size() + "\n");
			Collections.sort(list);
			for (int ele : list)
				sb.append(ele + " ");

			sb.append("\n");
		}
		System.out.println(sb);
		return;

	}

	private static void six() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] scn = (br.readLine()).trim().split(" ");
		int t = Integer.parseInt(scn[0]);
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			scn = (br.readLine()).trim().split(" ");
			int n = Integer.parseInt(scn[0]);
			long[] arr = new long[n];
			scn = (br.readLine()).trim().split(" ");
			HashMap<Long, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(scn[i]);
				map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			}
			TreeMap<Integer, Integer> freq = new TreeMap<>();
			for (long key : map.keySet()) {
				freq.put(map.get(key), freq.getOrDefault(map.get(key), 0) + 1);
			}

			int min = n;
			for (int key : freq.keySet()) {
				int op = 0;
				for (int sk : freq.keySet()) {
					if (sk < key) {
						op += sk * freq.get(sk);
					}
					if (sk > key) {
						op += (sk - key) * freq.get(sk);
					}
				}
				min = Math.min(min, op);
			}
			sb.append(min);
			sb.append("\n");
		}
		System.out.println(sb);
		return;
	}

	private static void sev() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] scn = (br.readLine()).trim().split(" ");
		int t = Integer.parseInt(scn[0]);
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			scn = (br.readLine()).trim().split(" ");
			int n = Integer.parseInt(scn[0]);
			int m = Integer.parseInt(scn[1]);
			long[] arr = new long[n];
			scn = (br.readLine()).trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(scn[i]);
			}
			long[] qrr = new long[m];
			scn = (br.readLine()).trim().split(" ");
			for (int i = 0; i < m; i++) {
				qrr[i] = Long.parseLong(scn[i]);
			}

			long max = 0;
			long sum = 0;
			pair[] pprr = new pair[n];
			int count = 0;
			for (int i = 0; i < n; i++) {
				sum += arr[i];
				if (sum > max) {
					pprr[i] = new pair(sum, i);
					count += 1;
					max = sum;
				}
			}
			pair[] prr = new pair[count];
			count = 0;
			for (int i = 0; i < n; i++) {
				if (pprr[i] != null) {
					prr[count++] = new pair(pprr[i].ele, pprr[i].idx);
				}
			}
			for (int i = 0; i < count; i++) {
				int tmep = (int) (Math.random() * count);
				pair p = prr[tmep];
				prr[tmep] = prr[i];
				prr[i] = p;

			}
			Arrays.sort(prr, (th, ot) -> {
				if (th.ele == ot.ele) {
					return th.idx - ot.idx;
				}
				return th.ele - ot.ele > 0 ? 1 : -1;
			});
			for (int i = 0; i < m; i++) {
				long get = LowerBound(prr, qrr[i]);
				if (get != -1) {
					sb.append(get + " ");
				} else {
					if (sum <= 0) {
						sb.append("-1 ");
					} else {
						long ans = 0;
						long val = qrr[i] - max;
						long rot = (long) (Math.ceil(val / (double) sum));
						ans += n * rot;
						val = qrr[i] - sum * rot;
						get = LowerBound(prr, val);
						ans += get;
						sb.append(ans + " ");
					}
				}

			}
			sb.append("\n");

		}
		System.out.println(sb);
		return;
	}

	static int LowerBound(pair a[], long x) {
		int l = -1, r = a.length;
		while (l + 1 < r) {
			int m = (l + r) >>> 1;
			if (a[m].ele >= x)
				r = m;
			else
				l = m;
		}
		if (r == a.length) {
			return -1;
		} else {
			return a[r].idx;
		}
	}

	public static void sort(long[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int idx = (int) Math.random() * n;
			long temp = arr[i];
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

}
