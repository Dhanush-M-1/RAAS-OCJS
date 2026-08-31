import java.io.*; 
import java.math.BigInteger;
import java.util.*;
  
public class Main {
	static final long MOD = 998244353;
    public static void main(String[] args) throws IOException {
        FastScanner sc=new FastScanner();
        int N = sc.nextInt();
        long[] nums = new long[N];
        for (int i = 0; i < N; i++)
        	nums[i] = sc.nextLong();
        BinaryIndexedTree bit = new BinaryIndexedTree(N);
        for (int i = 1; i <= N; i++) {
        	bit.add(i,i-1);
        }
        int[] ans = new int[N];
        for (int i = N-1; i >= 0; i--) {
        	long target = nums[i];
        	int L = 0;
        	int R = N;
        	while (L < R-1) {
        		int mid = (L+R+1)/2;
        		if (bit.sum(0,mid) <= target) {
        			L = mid;
        		} else {
        			R = mid;
        		}
        	}
        	ans[i] = L+1;
        	bit.add(-1 * ans[i],L);
        }
        
        for (int i = 0; i < N; i++)
        	System.out.print(ans[i] + " ");
    }
    
    static class FastScanner { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastScanner() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
}

class Node {
	public int n;
	public HashSet<Node> children;
	
	public Node(int n) {
		this.n = n;
		children = new HashSet<Node>();
	}
	
	public void addChild(Node node) {
		children.add(node);
	}
	
	public void removeChild(Node node) {
		children.remove(node);
	}
}

class BinaryIndexedTree {
	  public long[] arr;

	  public BinaryIndexedTree (int N) {
	    arr = new long[N+1];
	    arr[0] = 0;
	  }

	  //add k to the i-th element.
	  public void add(long k, int i) {
	    int node = i+1;
	    while (node < arr.length) {
	      arr[node] += k;
	      node += node & (-node);
	    }
	  }

	  //sum up the elements from input[s_i] to input[e_i], from [s_i,e_i).
	  public long sum(int s_i, int e_i) {
	    return sum(e_i) - sum(s_i);
	  }

	  public long sum(int i) {
	    long total = 0;
	    int node = i;
	    while (node > 0) {
	      total += arr[node];
	      node -= node & (-node);
	    }
	    return total;
	  }
}