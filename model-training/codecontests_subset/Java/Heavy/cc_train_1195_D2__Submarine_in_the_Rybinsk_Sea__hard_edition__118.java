import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Iterator;


     
public class Solution{
    	
    static final int mod = 998244353;
    static int[] p;
    	
    public static void main(String[] args) {
     
    	FastScanner fs = new FastScanner();
    	PrintWriter out = new PrintWriter(System.out);
    		
    		
    	int tt = 1;
    	while(tt-->0) {
    		
    		int n = fs.nextInt();
    		
    		int[] cnt = new int[11];
    		
    		int[] a = new int[n];
    		
    		for(int i=0;i<n;i++) {
    			a[i] = fs.nextInt();
    			cnt[count(a[i])]++;
    		}
    		
    		p = new int[21];
    		p[0] = 1;
    		for(int i=1;i<=20;i++)
    			p[i] = mul(p[i-1], 10);
    		
    		int[] orig = new int[10];
    		orig[0] = 1;
    		for(int i=1;i<10;i++)
    			orig[i] = orig[i-1]*10;
    		
    		int ans = 0;
    		
    		for(int i=0;i<n;i++) {
    			int dig = count(a[i]);
    			
    			for(int j=1;j<=10;j++	) {
    				int num = Math.max(0, dig-j);
    				int rem = dig - num;
    				
    				if(num!=0)
    					ans = add(ans, mul(mul(a[i]/orig[rem], p[rem*2]), cnt[j]*2));
    				
    				int newNum = a[i];
    				if(rem!=10) {
    					newNum = a[i]%orig[rem];
    				}
    				ans = add(ans, mul(cal(newNum), cnt[j]));
    				
    			}
    			
    		}
    		
    		out.println(ans);
    		
    		
    	}
    		
    	out.close();
    		
    }
    
    
    static int count(int n) {
    	int res = 0;
    	while(n>0) {
    		n /= 10;
    		res++;
    	}
    	return res;
    }
   
    static int cal(int n) {
    	ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
    	while(n>0) {
    		int dig = n%10;
    		queue.addFirst(dig); queue.addFirst(dig);
    		n /= 10;
    	}
    	int ans = 0;
    	Iterator<Integer> iter = queue.descendingIterator();
    	int ind = 0;
    	while(iter.hasNext()) {
    		ans = add(ans, mul(iter.next(), p[ind++]));
    	}
    	return ans;
    }
    
    
    static int mul(int a, int b) {
    	return (int)(((long)a*b)%mod);
    }
    	
    	
    static int add(int a, int b) {
    	return (a+b)%mod;
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