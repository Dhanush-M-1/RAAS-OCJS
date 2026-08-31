import java.io.*;
import java.util.*;

/*


*/
public class Main {
	static FastReader sc=null;
	static int nax=(int)1e6;

	
	public static void main(String[] args) {
		sc=new FastReader();
		int n=sc.nextInt();
		int a[]=sc.readArray(n);
		int l=1,r=nax;
		int i=0,j=n-1;
		long ans=0;
		while(i<=j) {
			int t1=a[i]-l,t2=r-a[j];
			if(t1<t2) {
				l=a[i];
				r=r-t1;
				ans+=t1;
				i++;
			}
			else {
				r=a[j];
				l=l+t2;
				ans+=t2;
				j--;
			}
			//System.out.println(ans);
		}
		System.out.println(ans);
		
		
		
		
		
		
		
		
	}
	static boolean check(int a[],int k) {
		int t1=a[k]-0,t2=nax-a[k];
		if(t1<t2) {
		}
		return true;
	}
	
	
	
	static int[] ruffleSort(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i:a)al.add(i);
		Collections.sort(al);
		for(int i=0;i<a.length;i++)a[i]=al.get(i);
		return a;
	}
		
	static int[] reverse(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i:a)al.add(i);
		Collections.sort(al,Collections.reverseOrder());
		for(int i=0;i<a.length;i++)a[i]=al.get(i);
		return a;
	}
	static int gcd(int a,int b) {
		if(b==0)return a;
		else return gcd(b,a%b);
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