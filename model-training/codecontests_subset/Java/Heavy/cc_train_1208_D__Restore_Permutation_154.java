import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution{
	
	
	
    public static void main(String[] args) throws IOException {
     
    	FastScanner fs = new FastScanner();
    	PrintWriter out = new PrintWriter(System.out);
    	
    		
    		
    	int tt = 1;
    	while(tt-->0) {
    		
    		int n = fs.nextInt();
    		long[] s = new long[n+1];
    		
    		Ftree ft = new Ftree(n);
    		
    		for(int i=1;i<=n;i++) {
    			ft.update(i, i);
    			s[i] = fs.nextLong();
    		}
    		
    		int[] ans = new int[n+1];
    		
    		for(int i=n;i>0;i--) {
    			ans[i] = ft.search(s[i]) + 1;
    			ft.update(ans[i], -ans[i]);
    		}
    		
    		for(int i=1;i<=n;i++) out.print(ans[i]+" ");
    		out.println();
    		
    		
    		
    		
    		
    		
    		
    	}
    	
    		
    		
    		
    	out.close();
    		
    }
    
    
    
  
    
    static class Ftree{
    	long[] bit;
    	int n;
    	
    	Ftree(int n){
    		this.n = n;
    		bit = new long[n+1];
    	}
    	
    	void update(int ind, int val) {
    		while(ind<=n) {
    			bit[ind] += val;
    			ind += ind&(-ind);
    		}
    	}
    	
    	long query(int ind) {
    		long sum = 0;
    		while(ind>0) {
    			sum += bit[ind];
    			ind -= ind&(-ind);
    		}
    		return sum;
    	}
    	
    	//doing search in O(LOG(N)) using binary lifting or you can do binary search in O(LOG^2(N))
    	int search(long x) {
    		int pos = 0;
    		long sum = 0;
    		for(int i=20;i>=0;i--) {
    			if(pos+(1<<i)<=n && sum + bit[pos + (1<<i)]<=x) {
    				sum += bit[pos + (1<<i)];
    				pos += (1<<i);
    			}
    		}
    		return pos;
    	}
     	
    }
    
    
    
    static final Random random=new Random();
    	
    static void ruffleSort(int[] a) {
    	int n=a.length;//shuffle, then sort 
    	for (int i=0; i<n; i++) {
    		int oi=random.nextInt(n); int temp=a[oi];
    		a[oi]=a[i]; a[i]=temp;
    	}
    	Arrays.sort(a);
    }
   
  
    
    	
    	
    static class FastScanner{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer("");
     
    	public String next(){
    		while(!st.hasMoreElements()){
    			try{
    				st = new StringTokenizer(br.readLine());
    			} catch(IOException e){
    				e.printStackTrace();
    			}
    		}
    		return st.nextToken();
    	}
    		
    	public String nextLine() throws IOException {
    		return br.readLine();
    	}
    		
    	public int nextInt(){
    		return Integer.parseInt(next());
    	}
     
    	public int[] readArray(int n){
    		int[] a = new int[n];
    		for(int i=0;i<n;i++)
    			a[i] = nextInt();
    		return a;
    	}
    		
    	public long nextLong() {
    		return Long.parseLong(next());
    	}
    		
    	public char nextChar() {
    		return next().toCharArray()[0];
    	}
    }
   	
}
