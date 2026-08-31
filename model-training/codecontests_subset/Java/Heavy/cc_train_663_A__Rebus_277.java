import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution{
	
	
    public static void main(String[] args) throws IOException {
     
    	FastScanner fs = new FastScanner();
    	PrintWriter out = new PrintWriter(System.out);
    	
    		
    		
    	int tt = 1;
    	while(tt-->0) {
    	
    		ArrayList<Integer> list = new ArrayList<Integer>();
    		String str = fs.nextLine();
    		int n = 0;
    		
    		list.add(0);
    		for(int i=0;i<str.length();i++) {
    			if(str.charAt(i)=='+') list.add(0);
    			else if(str.charAt(i)=='-') list.add(1);
    			else if(str.charAt(i)=='=') {
    				String s = "";
    				for(int j=i+2;j<str.length();j++) s+= str.charAt(j);
    				n = Integer.parseInt(s);
    			}
    		}
    		
    		
    		int cnt1 = 0;  //number of positives
    		int cnt2 = 0;  //number of negatives
    		
    		for(int i=0;i<list.size();i++) {
    			if(list.get(i)==0) cnt1++;
    			else cnt2++;
    		}
    		
    		if(n+cnt2>n*cnt1) {
    			out.println("Impossible");
    			out.flush();
    			return;
    		}
    		if(n+n*cnt2<cnt1) {
    			out.println("Impossible");
    			out.flush();
    			return;
    		}
    		
    		int d = -1;
    		int s = -1;
    		
    		if(contains(n+cnt2, cnt1, n*cnt1))  d = cnt2; 
    		else if(contains(n+n*cnt2, cnt1, n*cnt1)) d = n*cnt2;
    		else if(contains(cnt1, n+cnt2, n+n*cnt2)) d = cnt1-n; 
    		else if(contains(n*cnt1, n+cnt2, n+n*cnt2)) d = n*cnt1 - n; 
    			
    		
    		s = n + d;
    		
    		ArrayList<Integer> pos = new ArrayList<Integer>();
    		ArrayList<Integer> neg = new ArrayList<Integer>();
    		
    		
    		for(int i=0;i<s%cnt1;i++) pos.add(s/cnt1+1);
    		for(int i=s%cnt1;i<cnt1;i++) pos.add(s/cnt1);
    		
    		if(cnt2!=0) for(int i=0;i<d%cnt2;i++) neg.add(d/cnt2+1);
    		if(cnt2!=0) for(int i=d%cnt2;i<cnt2;i++) neg.add(d/cnt2);
    		
    		out.println("Possible");
    		
    		int cur1 = 0, cur2 = 0;
    		out.print(pos.get(cur1++)+" ");
    		
    		for(int i=1;i<list.size();i++) {
    			out.print((list.get(i)==0?'+':'-')+" ");
    			out.print(((list.get(i)==0)?pos.get(cur1++):neg.get(cur2++))+" ");
    		}
    		
    		out.println("= "+n);
    		
    		
    		
    		
    	}
    	
    		
    		
    		
    	out.close();
    		
    }
    
    
	
    static boolean contains(int a, int b, int c) {
    	if(a>=b && a<=c) return true;
    	return false;
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