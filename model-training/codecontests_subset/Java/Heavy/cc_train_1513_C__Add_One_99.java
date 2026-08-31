import java.io.*;
import java.util.*;
/*


*/




 
 
public class A {
	static FastReader sc=null;
	static int nax=(int)2e5+ 5;
	static long mod=(long)1e9 + 7;

	public static void main(String[] args) {
		long dp[][]=new long[nax][10];
		//dp[i][j] -> no of digits 'j' produces after 'i' operations
		Arrays.fill(dp[0], 1);
		for(int i=1;i<nax;i++)
			for(int j=0;j<10;j++) {
				if(j==9) {
					dp[i][j]+=(dp[i-1][0]);
					if(dp[i][j]>=mod)dp[i][j]-=mod;
					dp[i][j]+=dp[i-1][1];
					if(dp[i][j]>=mod)dp[i][j]-=mod;
				}
				else {
					dp[i][j]=dp[i-1][j+1];
				}
				
			}
		sc=new FastReader();
		PrintWriter out=new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0) {
			String s=sc.next();
			int m=sc.nextInt();
			long ans=0;
			for(int i=0;i<s.length();i++) {
				int d=s.charAt(i)-'0';
				ans+=dp[m][d];
				if(ans>=mod)ans-=mod;
			}
			out.println(ans);
		}
		out.close();
	}
	
	
	
	
	
	
	

	
 
	
	static void reverseSort(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i:a)al.add(i);
		Collections.sort(al,Collections.reverseOrder());
		for(int i=0;i<a.length;i++)a[i]=al.get(i);
	}
	static int gcd(int a,int b) {
		if(b==0)return a;
		else return gcd(b,a%b);
	}
	static long gcd(long a,long b) {
		if(b==0)return a;
		else return gcd(b,a%b);
	}
	static void reverse(int a[]) {
		int n=a.length;
		int b[]=new int[n];
		for(int i=0;i<n;i++)b[i]=a[n-1-i];
		for(int i=0;i<n;i++)a[i]=b[i];
	}
	static void ruffleSort(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i:a)al.add(i);
		Collections.sort(al);
		for(int i=0;i<a.length;i++)a[i]=al.get(i);
	}
	
	
	
	static void print(int a[]) {
		for(int e:a) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	static void print(long a[]) {
		for(long e:a) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
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
        int[] readArray(int n) {
    		int a[]=new int [n];
    		for(int i=0;i<n;i++) {
    			a[i]=sc.nextInt();
    		}
    		return a;
    	}
    } 
}
