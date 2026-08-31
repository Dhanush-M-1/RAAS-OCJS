import java.io.*;
import java.util.*;

public class OptimalSubsequences {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int n = in.nextInt();
        int a[] = in.readArray(n);
        Integer b[] = new Integer[n];
        for(int i=0;i<n;i++) b[i] = a[i];
        Arrays.parallelSort(b,Collections.reverseOrder());
        int m = in.nextInt();
        while(m-->0) {
        	int k = in.nextInt(), pos = in.nextInt()-1;
        	if(!map.containsKey(k)) {
        		int max[] = new int[k];
            	for(int i=0;i<k;i++) max[i] = b[i];
            	ArrayList<Integer> order = new ArrayList<>();
            	int vis[] = new int[n];
            	for(int i : max) {
            		for(int j=0;j<n;j++) {
            			if(a[j]==i&&vis[j]!=1) {
            				vis[j] = 1;
            				order.add(j);break;
            			}
            		}
            	}
            	Collections.sort(order);
            	map.put(k, order);
        	}
        	out.println(a[map.get(k).get(pos)]);
        }
        out.flush();
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				}catch(IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		int[] readArray(int n) {
			int a[] = new int[n];
			for(int i=0;i<n;i++) a[i] = nextInt();
			return a;
		}
		
		long[] readArray(int n,long x) {
			long a[] = new long[n];
			for(int i=0;i<n;i++) a[i] = nextLong();
			return a;
		}
		
	}
	
	static boolean arrayEquals(char a[], char b[]) {
		int n = a.length;
		boolean verdict = true;
		for(int i=0;i<n;i++) {
			if(a[i]!=b[i]) {
				verdict = false;break;
			}
		}
		return verdict;
	}
	
	static long lcm(long a, long b) {
		return (a*b)/gcd(a,b);
	}
	
	static long gcd(long a, long b) {
		if(b==0) return a;
		else return gcd(b,a%b);
	}
}

