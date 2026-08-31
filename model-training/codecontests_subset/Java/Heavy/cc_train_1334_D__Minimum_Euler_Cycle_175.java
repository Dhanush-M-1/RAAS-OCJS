import java.io.*;
 
import java.util.*;
/*
 

*/
 
 
 
 
 
 
 
public class A {
	static FastReader sc=null;
	static int nax=(int)1e6 +10;
	
	public static void main(String[] args) {
		sc=new FastReader();
		PrintWriter out=new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			long l=sc.nextLong(),r=sc.nextLong();
			long l1=l;
			int curr=1;
			while(l>2*(n-curr) && curr<=n) {
				l-=2*(n-curr);
				curr++;
				//System.out.println(l+" ");
			}
			//CURR indicates which starting point we get to and now
			int from=(int)(l/2+curr);
			int ans[]=new int[nax];
			//System.out.println(l+" "+r+" "+from);
			Arrays.fill(ans, -1);
			int j=0;
			if(l%2==0) {
				ans[0]=from;
				from++;
				j++;
			}
			else {
				from++;
			}
			while(from<=n) {
				ans[j++]=curr;
				ans[j++]=from++;
			}
			curr++;
			
			int len=(int)(r-l1+1)+5;
			
			while(j<len && curr<n) {
				for(int k=(curr+1);k<=n && j<len;k++) {
					ans[j++]=curr;
					ans[j++]=k;
				}
				curr++;
			}
			if(j<nax)ans[j++]=1;
			
			//System.out.println(len);
			for(int i=0;i<len-5;i++) {
				//if(ans[i]==-1)break;
				out.print(ans[i]+" ");
			}
			out.println();
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
        long[] readArrayL(int n) {
    		long a[]=new long [n];
    		for(int i=0;i<n;i++) {
    			a[i]=sc.nextLong();
    		}
    		return a;
    	}
    } 
}