import java.util.*;
import java.io.*;

public class File {
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
	
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		
		
		
		
		
		
		int n = sc.nextInt();
		int[] a = new int[n];
		List<int[]> list = new ArrayList<int[]>();
		
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			list.add(new int[] {a[i], i});
		}
		
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return b[0] - a[0];
			}
		});
		
		
		int m = sc.nextInt();
		
		for (int i = 0; i < m; i++) {
			int k = sc.nextInt();
			int pos = sc.nextInt() - 1;
			
			List<int[]> elements = new ArrayList<int[]>();
			for (int j = 0; j < k; j++) {
				elements.add(list.get(j));
			}
			
			Collections.sort(elements, new Comparator<int[]>() {
				@Override
				public int compare(int[] a, int[] b) {
					return a[1] - b[1];
				}
			});
			
			out.println(elements.get(pos)[0]);
		}
		
		
		
		
		
		
		
		out.close();
	}
}



	