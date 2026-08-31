import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class CP{
    static int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args){
    	int t = sc.nextint();
    	while(t-- > 0) {
    		solve();
    	}
        out.close();
    }
    
    static void solve() {
    	int n = sc.nextint(), queries = sc.nextint();
    	long max_sum = MIN;
    	int[] nums = sc.readint(n);
    	long[] pref = new long[n+1];
    	List<long[]> pos = new ArrayList<>();
    	for(int i = 0; i < n; ++i) {
    		pref[i+1] = pref[i] + nums[i];
    		if(pref[i+1] > max_sum) {
    			max_sum = pref[i+1];
    			pos.add(new long[] {i, max_sum});
    		}
    	}
    	
    	for(int i = 0; i < queries; ++i) {
    		int x = sc.nextint();
    		if(pref[n] <= 0 && max_sum < x) {
    			out.print(-1 + " ");
    			continue;
    		}
    		long cycles = max(0, pref[n] > 0 ? (x-max_sum+pref[n]-1)/pref[n] : 0), time = cycles * n;
    		x -= cycles * pref[n];
    		int lb = 0, hb = pos.size()-1;
    		while(lb < hb) {
    			int mb = (lb+hb)/2;
    			if(pos.get(mb)[1] >= x) {
    				hb = mb;
    			}
    			else {
    				lb = mb+1;
    			}
    		}
    		time += pos.get(lb)[0];
    		out.print(time + " ");
    	}
    	
    	out.println();
    }
    
    static void sort(int[] a) {
        Random r = new Random();
        int n = a.length;
        for(int i = 0; i < n; ++i) {
            int idx = r.nextInt(n);
            int temp = a[idx];
            a[idx] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
    
    static BufferedReader br;
    static StringTokenizer st;
    
    static class FastScanner{
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while(st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int[] readint(int n) {
            int[] res = new int[n];
            for(int i = 0; i < n; i++) {
                res[i] = nextint();
            }
            return res;
        }
        
        long[] readlong(int n) {
            long[] res = new long[n];
            for(int i = 0; i < n; i++) {
                res[i] = nextlong();
            }
            return res;
        }
        
        int nextint(){
            return Integer.parseInt(next());
        }
        
        long nextlong() {
            return Long.parseLong(next());
        }
        
        double nextdouble() {
            return Double.parseDouble(next());
        }
        
        String nextline() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

