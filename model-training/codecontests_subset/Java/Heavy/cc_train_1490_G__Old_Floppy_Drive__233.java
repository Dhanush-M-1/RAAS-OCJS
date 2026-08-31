import java.io.*;




import java.util.*;
/*


*/





public class B {
	static FastReader sc=null;

	public static void main(String[] args) {
		sc=new FastReader();
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt(),m=sc.nextInt();
			int a[]=sc.readArray(n);
			long xi[]=new long[m];
			for(int i=0;i<m;i++)xi[i]=sc.nextLong();
			long pre[]=new long[n];
			long preSum=0;
			long max=0;
			for(int i=0;i<n;i++) {
				preSum+=a[i];
				pre[i]=Math.max(preSum, (i>0?pre[i-1]:a[0]));
				max=Math.max(pre[i], max);
			}
			for(long x:xi) {
				if(x>max && preSum<=0)System.out.print(-1+" ");
				else if(x<=max) {
					int id=bs(pre,x);
					System.out.print((id)+" ");
				}
				else{
					long ans=(x-max+preSum-1)/preSum;
					x=x-ans*preSum;
					ans*=n;
					int id=bs(pre,x);
					System.out.print((ans+id)+" ");
				}
			}
			System.out.println();
			
		}
		

	
		
		
		
	}
	static int bs(long a[],long k) {
		int l=-1,r=a.length;
		while(l+1<r) {
			int mid=(l+r)/2;
			if(a[mid]<k)l=mid;
			else r=mid;
		}
		return r;
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
	static int[] ruffleSort(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i:a)al.add(i);
		Collections.sort(al);
		for(int i=0;i<a.length;i++)a[i]=al.get(i);
		return a;
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
	static void print(char a[]) {
		for(char e:a) {
			System.out.print(e);
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






