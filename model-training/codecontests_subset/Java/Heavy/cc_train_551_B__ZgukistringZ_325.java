import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution{
	
	
	
	
    public static void main(String[] args) throws IOException {
     
    	FastScanner fs = new FastScanner();
    	PrintWriter out = new PrintWriter(System.out);
    	
    		
    		
    	int tt = 1;
    	while(tt-->0) {
    		
    		char[] a = fs.next().toCharArray();
    		char[] b = fs.next().toCharArray();
    		char[] c = fs.next().toCharArray();
    		
    		int[] cnt1 = new int[26];
    		int[] cnt2 = new int[26];
    		int[] cnt3 = new int[26];
    		
    		for(int i=0;i<a.length;i++) cnt1[a[i]-'a']++;
    		for(int i=0;i<b.length;i++) cnt2[b[i]-'a']++;
    		for(int i=0;i<c.length;i++) cnt3[c[i]-'a']++;
    		
    		
    		int num2=0,num3=0;
    		int max = 0;
    		
    		int lim = checklim(cnt1, cnt2);
    		
    		for(int i=0;i<=lim;i++) {
    			int j = (int)1e9;
    			for(int k=0;k<26;k++) {
    				if(cnt3[k]==0) continue;
    				j = Math.min(j, (cnt1[k]-i*cnt2[k])/cnt3[k]);
    			}
    			if(i+j>max) {
    				max = i + j;
    				num2 = i;
    				num3 = j;
    			}
    		}
    		
    		
    		for(int i=0;i<num2;i++) out.print(b);
    		for(int i=0;i<num3;i++) out.print(c);
    		
    		for(int i=0;i<26;i++) {
    			for(int j=0;j<cnt1[i]-num2*cnt2[i]-num3*cnt3[i];j++) out.print((char)(i+'a'));
    		}
    		
    		out.println();
    		
    		
    		
    		
    		
    		
    	}
    	
    		
    		
    		
    	out.close();
    		
    }
    
    
    
    static int checklim(int[] cnt1, int[] cnt2) {
    	int x = (int)1e9;
    	for(int i=0;i<26;i++) {
    		if(cnt2[i]==0) continue;
    		x = Math.min(x, cnt1[i]/cnt2[i]);
    	}
    	return x;
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