//note: 0<=|int|<=2 * 10^9
//note: 0<=|long|<= 9 * 10^18
//note: 20! max w/ long
//note: 91st fibonacci # highest calculable w/long
//note: 0 <= |double| <= 1.8 * 10^308
//note: 170! max w/long;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
    
public class CP{
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int MAX = Integer.MAX_VALUE;
    private static int MIN = Integer.MIN_VALUE;
    private static List<Integer> adj[];
    // private static List<String> adj[]; // use this for a graph
    public static void main(String[] args) throws IOException{
        FastScanner sc = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        
        int t = sc.nextint();
        for(int i = 0; i < t; i++) {
        	int n = sc.nextint();
        	int[] nums = new int[n];
        	for(int j = 0; j < n; j++) {
        		nums[j] = sc.nextint();
        	}
        	if(nums[0] + nums[1] <= nums[nums.length-1]) {
        		out.println(1 + " " + 2 + " " + (nums.length));
        	}
        	else {
        		out.println(-1);
        	}
        }
        

        out.close(); 
    }
    
    private static int search(int[] nums, int m) {
    	int left = 0;
    	int right = nums.length - 1;
    	while(left < right) {
    		int mid = left + (right-left)/2;
    		if(nums[mid] > m) {
    			right = mid;
    		}
    		else if(nums[mid] <= m) {
    			left = mid + 1;
    		}
    	}
    	return left;
    }
    
    private static void dfs(List<Point> cur, int r, int c, int[][] dir, boolean[][] vis){
    	if(!vis[r][c]) {
    		vis[r][c] = true;
    		Point p = new Point(r, c);
    		cur.add(p);
    		for(int[] d : dir) {
    			int newR = r + d[0];
    			int newC = c + d[1];
    			if(newR >= 0 && newR < vis.length && newC >= 0 && newC < vis.length && !vis[newR][newC]) {
    				dfs(cur, newR, newC, dir, vis);
    			}
    		}
    	}
    }
    
    private static class Point{
    	int r, c;
    	public Point(int r, int c) {
    		this.r = r;
    		this.c = c;
    	}
    }
    
    private static class FenTree{
    	private long[] tree;
    	public FenTree(int size) {
    		tree = new long[size+1];
    	}
    	
    	public void add(int index, int add) {
    		while(index < tree.length) {
    			tree[index] += add;
    			index += (index & -index);
    		}
    	}
    	
    	public long sum(int index) {
    		long sum = 0;
    		while(index > 0) {
    			sum += tree[index];
    			index -= (index & -index);
    		}
    		
    		return sum;
    	}
    }
    
    public static int f(int k) {
    	if(k == 0 || k == 1) {
    		return 1;
    	}
    	return f(k-1) + f(k-2);
    }
    
    public static int fib(int k, int[] dp2) {
    	if(dp2[k] != MAX) {
    		return dp2[k];
    	}
    	else if(k == 0 || k == 1) {
    		dp2[k] = 1;
    		return 1;
    	}
    	dp2[k] = fib(k-1, dp2) + fib(k-2, dp2);
    	return dp2[k];
    }
    
    public static boolean contains(List<Integer> arr, int key){
        int left = 0;
        int right= arr.size();
        while(left < right){
            int mid = left + (right-left)/2;
            if(arr.get(mid) == key){
                return true;
            }
            else if(arr.get(mid) < key){
                left = mid +1;
            }
            else{
                right = mid;
            }
        }
        return false;
    }
    
    private static long modInverse(long a, long b) {
        long bb = b, temp, q;
        long x0 = 0, x1 = 1;
        if(b == 1){
            return 1L;
        }
        while(a > 1){
            q = a/b;
            temp = b; b = a%b; a=temp;
            temp = x0; x0 = x1-q*x0; x1 = temp;
        }
        if(x1 < 0){
            x1 += bb;
        }
        return x1;
    }
    
    private static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a, a);
    }
    
    private static PrintWriter out;
    
        private static class FastScanner{
            public FastScanner(){
                br = new BufferedReader(new InputStreamReader(System.in));
            }
            
            String next(){
                while (st == null || !st.hasMoreElements()){
                    try{
                        st = new StringTokenizer(br.readLine());
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }
            
            int nextint(){
                return Integer.parseInt(next());
            }
            long nextlong(){
                return Long.parseLong(next());
            }
            double nextdouble(){
                return Double.parseDouble(next());
            }
            String nextline(){
                String str = "";
                try{
                    str = br.readLine();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                return str;
            }
        }
    }