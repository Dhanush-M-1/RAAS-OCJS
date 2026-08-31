import java.io.*; 
import java.util.*; 


public class d2{
	
	static class FastReader{ 
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
				catch (IOException e) 
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
	static long mod = 998244353;

	static long con_back(long num, long len, long n){
		long ten = 1;
		long ans = 0;
    	while(num>0){
    		long d = num%10;
    		ans = (ans + (n*(d*(ten%mod))%mod)%mod)%mod;
    		ten = (ten*10)%mod;
    		if(len>0){
    			ten = (ten*10)%mod;
    		}
    		len--;
    		num/=10;
    	}

    	return ans;
	}

	static long con_front(long num, long len, long n){
		long ten = 10;
		long ans = 0;
		len--;
    	while(num>0){
    		long d = num%10;
    		ans = (ans + (n*(d*(ten%mod))%mod)%mod)%mod;
    		ten = (ten*10)%mod;
    		if(len>0){
    			ten = (ten*10)%mod;
    		}
    		len--;
    		num/=10;
    	}

    	return ans;
	}

	public static void main(String[] args) 
	{ 
        FastReader sc = new FastReader(); 
        //PrintWriter out = new PrintWriter(System.out); 
        int n = sc.nextInt();
        long[] arr = new long[n];
        long[] count = new long[13];

        for(int i=0;i<n;i++){
        	long num = sc.nextLong();
        	arr[i] = num;
        	int cnt = 0;
        	while(num>0){
        		cnt++;
        		num/=10;
        	}
        	count[cnt]++; 
        }

        long ans = 0 ;
        for(int i=0;i<n;i++){
        	for(int j=1;j<=12;j++){
        		if(count[j]>0){
        			ans = (ans + con_front(arr[i], (long)j, count[j]) )%mod;
        			ans = (ans + con_back(arr[i], (long)j, count[j]) )%mod;
        		}
        	}
        }

        System.out.println( ans );
	}
}
