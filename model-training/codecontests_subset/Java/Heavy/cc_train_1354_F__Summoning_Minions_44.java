import java.io.*;
import java.util.*;
 
public class Main {
    static final long MOD = 1000000007L;
    static final int INF = 50000000;
    static final int NINF = -500000000;
    
    static ArrayDeque<int[]>[] graph;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
        
        int Q = sc.ni();
        for (int q = 0; q < Q; q++) {
        	int N = sc.ni();
        	int K = sc.ni();
        	int[][] nums = new int[N+1][3]; //A,B,i
        	Arrays.fill(nums[0],-1);
        	for (int i = 1; i <= N; i++)
        		nums[i] = new int[] {sc.ni(),sc.ni(),i};
        	sort(nums);
        	
        	int[][] dp = new int[N+1][K+1]; //put minion i in position j
        	for (int i = 0; i <= N; i++)
        		Arrays.fill(dp[i], NINF);
        	dp[0][0] = 0;
        	int[][] from = new int[N+1][K+1]; //equal to k or k-1
        	for (int i = 1; i <= N; i++) {
        		for (int j = 0; j <= Math.min(i, K); j++) {
        			int v1 = 0;
        			if (j > 0)
        				v1 = dp[i-1][j-1]+nums[i][0]+(j-1)*nums[i][1]; //put this minion in the final roster
        			int v2 = dp[i-1][j]+(K-1)*nums[i][1]; //this is a throwaway minion
        			if (v1 > v2) {
        				dp[i][j] = v1;
        				from[i][j] = j-1;
        			} else {
        				dp[i][j] = v2;
        				from[i][j] = j;
        			}
        		}
        	}
        	//pw.println(Arrays.deepToString(nums));
        	//pw.println(Arrays.deepToString(dp));
        	//pw.println(Arrays.deepToString(from));
        	
        	
        	ArrayList<Integer> survived = new ArrayList<Integer>();
        	ArrayList<Integer> killed = new ArrayList<Integer>();
        	int pos = K;
        	for (int i = N; i >= 1; i--) {
        		if (from[i][pos]==pos) {
        			killed.add(nums[i][2]);
        		} else {
        			survived.add(nums[i][2]);
        		}
        		pos = from[i][pos];
        	}
        	Collections.reverse(survived);
        	
        	ArrayList<Integer> ans = new ArrayList<Integer>();
        	for (int i = 0; i < survived.size()-1; i++) {
        		ans.add(survived.get(i));
        	}
        	for (int i = 0; i < killed.size(); i++) {
        		int idx = killed.get(i);
        		ans.add(idx);
        		ans.add(0-idx);
        	}
        	ans.add(survived.get(survived.size()-1));
        	
        	pw.println(ans.size());
        	for (int a: ans)
        		pw.print(a + " ");
        	pw.println();
        }
        
        pw.close();
    }

    public static void sort(int[][] arr) {
    	//Sort an array (immune to quicksort TLE)
    	Random rgen = new Random();
    	for (int i = 0; i < arr.length; i++) {
    		int randomPosition = rgen.nextInt(arr.length);
    		int[] temp = arr[i];
    		arr[i] = arr[randomPosition];
    		arr[randomPosition] = temp;
    	}
    	Arrays.sort(arr, new Comparator<int[]>() {
    		@Override
    		public int compare(int[] arr1, int[] arr2) {
    			return arr1[1]-arr2[1];
    			//Ascending order.
    		}
    	});
    }
    
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner() {
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
 
        int ni() {
            return Integer.parseInt(next());
        }
 
        long nl() {
            return Long.parseLong(next());
        }
 
        double nd() {
            return Double.parseDouble(next());
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