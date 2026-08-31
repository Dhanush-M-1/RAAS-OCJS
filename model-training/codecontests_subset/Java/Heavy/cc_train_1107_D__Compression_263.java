import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution{
	
	static int[][] arr;

    public static void main(String[] args) {
     
    	FastScanner fs = new FastScanner();
    	PrintWriter out = new PrintWriter(System.out);
    		
    		
    	int tt = 1;
    	while(tt-->0) {
    		
    		
    		int n = fs.nextInt();
    		arr = new int[n][n];
    		
    		for(int i=0;i<n;i++) {
    			char[] c = fs.next().toCharArray();
    			for(int k=0;k<c.length;k++)
    				read(i, 4*k, c[k]);
    		}
    		
    		
    		int g = n;
    		
    		for(int i=0;i<n;i++) {
    			for(int j=0;j<n;) {
    				int k = j;
    				while(j<n && arr[i][j]==arr[i][k]) j++;
    				g = gcd(g, j-k);
    			}
    		}
    		
    		for(int j=0;j<n;j++) {
    			for(int i=0;i<n;) {
    				int k = i;
    				while(i<n && arr[i][j]==arr[k][j]) i++;
    				g = gcd(g, i-k);
    			}
    		}
    		
    		
    		out.println(g);
    		
    	}
    		
    	out.close();
    		
    }
    
    static int gcd(int a, int b) {
    	if(b==0) return a;
    	return gcd(b, a%b);
    }
    
    
    static void read(int i, int j, char ch) {
    	int num = 0;
    	if(Character.isDigit(ch)) {
    		num = ch-'0';
    	}
    	else {
    		num = ch-'A' + 10;
    	}
    	
    	for(int k=3;k>=0;k--) {
    		arr[i][j+k] = num&1;
    		num = num>>1;
    	}
    	
    }
    
  
    
  

    
    
    	
    static final Random random=new Random();
    	
    static void ruffleSort(long[] a) {
    	int n=a.length;//shuffle, then sort 
    	for (int i=0; i<n; i++) {
    		int oi=random.nextInt(n); long temp=a[oi];
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