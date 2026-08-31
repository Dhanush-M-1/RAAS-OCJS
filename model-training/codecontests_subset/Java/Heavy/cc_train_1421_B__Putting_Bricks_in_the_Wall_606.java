import java.util.*;
import java.io.*;
import java.math.*;
public class Euler {
	 
    public static void main(String[] args){
        FastReader in = new FastReader();
        PrintWriter o = new PrintWriter(System.out);
        
        int x = in.nextInt();
        
        while (x-- > 0) {
			
			int n = in.nextInt();
			int[][] mat = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				String str = in.next();
				for (int j = 0; j < str.length(); j++) {
					if (str.charAt(j) != 'S' && str.charAt(j) != 'F') {
						mat[i][j] = str.charAt(j) - '0';
					}
				}
			}
			
			List<Integer> list = new ArrayList<>();
			
			if (mat[0][1] == mat[1][0]) {
				int t = mat[0][1] ^ 1;
				if (mat[n - 1][n - 2] != t) {
					list.add(n - 1);
					list.add(n - 2);
				}
				if (mat[n - 2][n - 1] != t) {
					list.add(n - 2);
					list.add(n - 1);
				}
			} else if (mat[n - 1][n - 2] == mat[n - 2][n - 1]) {
				int t = mat[n - 1][n - 2] ^ 1;
				if (mat[0][1] != t) {
					list.add(0);
					list.add(1);
				}
				if (mat[1][0] != t) {
					list.add(1);
					list.add(0);
				}
			} else {
				if (mat[0][1] != mat[1][0]) {
					int t = mat[0][1] ^ 1;
					list.add(1);
					list.add(0);
					if (mat[n - 1][n - 2] != t) {
						list.add(n - 1);
						list.add(n - 2);
					}
					if (mat[n - 2][n - 1] != t) {
						list.add(n - 2);
						list.add(n - 1);
					}
				}
			}
			
			o.print((list.size() / 2) + "\n");
			for (int i = 0; i < list.size(); i+=2) {
				o.println((list.get(i) + 1) + " " + (list.get(i + 1) + 1));
			}
			
			
		}
        
        
        o.close();
        o.flush();
        return;
    }
    
 
    
    
    
    
    
    
    
    
    
    
    public static void sort(int[] arr) {
		ArrayList<Integer> ar = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			ar.add(arr[i]);
		}
		Collections.sort(ar);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ar.get(i);
		}
	}
   
    static final Random random=new Random();
 
    static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		sort(a);
	}
    
   
	
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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
        
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
 
        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
 
 
}
