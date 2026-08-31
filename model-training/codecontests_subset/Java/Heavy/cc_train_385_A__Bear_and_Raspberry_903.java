// package programs;

import java.util.*;

import static java.lang.System.out;

import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 

public class Main 
{ 
	static final long mod = (int)1e9+7;
	static final long M = (int)1e9+7;
	 
	
	static class Reader 
	{ 
		final private int BUFFER_SIZE = 1 << 16; 
		private DataInputStream din; 
		private byte[] buffer; 
		private int bufferPointer, bytesRead; 

		public Reader() 
		{ 
			din = new DataInputStream(System.in); 
			buffer = new byte[BUFFER_SIZE]; 
			bufferPointer = bytesRead = 0; 
		} 

		public Reader(String file_name) throws IOException 
		{ 
			din = new DataInputStream(new FileInputStream(file_name)); 
			buffer = new byte[BUFFER_SIZE]; 
			bufferPointer = bytesRead = 0; 
		} 

		public String next() throws IOException 
		{ 
			byte[] buf = new byte[64]; // line length 
			int cnt = 0, c; 
			while ((c = read()) != -1) 
			{ 
				if (c == '\n') 
					break; 
				buf[cnt++] = (byte) c; 
			} 
			return new String(buf, 0, cnt); 
		} 
		
		public int nextInt() throws IOException 
		{ 
			int ret = 0; 
			byte c = read(); 
			while (c <= ' ') 
				c = read(); 
			boolean neg = (c == '-'); 
			if (neg) 
				c = read(); 
			do
			{ 
				ret = ret * 10 + c - '0'; 
			} while ((c = read()) >= '0' && c <= '9'); 

			if (neg) 
				return -ret; 
			return ret; 
		}
		int[] readArray(int n) throws IOException {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}

		public long nextLong() throws IOException 
		{ 
			long ret = 0; 
			byte c = read(); 
			while (c <= ' ') 
				c = read(); 
			boolean neg = (c == '-'); 
			if (neg) 
				c = read(); 
			do { 
				ret = ret * 10 + c - '0'; 
			} 
			while ((c = read()) >= '0' && c <= '9'); 
			if (neg) 
				return -ret; 
			return ret; 
		} 

		public double nextDouble() throws IOException 
		{ 
			double ret = 0, div = 1; 
			byte c = read(); 
			while (c <= ' ') 
				c = read(); 
			boolean neg = (c == '-'); 
			if (neg) 
				c = read(); 

			do { 
				ret = ret * 10 + c - '0'; 
			} 
			while ((c = read()) >= '0' && c <= '9'); 

			if (c == '.') 
			{ 
				while ((c = read()) >= '0' && c <= '9') 
				{ 
					ret += (c - '0') / (div *= 10); 
				} 
			} 

			if (neg) 
				return -ret; 
			return ret; 
		} 

		private void fillBuffer() throws IOException 
		{ 
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
			if (bytesRead == -1) 
				buffer[0] = -1; 
		} 

		private byte read() throws IOException 
		{ 
			if (bufferPointer == bytesRead) 
				fillBuffer(); 
			return buffer[bufferPointer++]; 
		} 

		public void close() throws IOException 
		{ 
			if (din == null) 
				return; 
			din.close(); 
		}

	}
	

	
	public static int digitSum(int n)
	{
		int sum =0;
		while(n > 0)
		{
			int last = n%10;
			sum+=last;
			n/=10;
		}
		return sum;
	}
	
	public static boolean isPrime(int n) {
		for(int i = 2;i*i<=n;i++)
		{
			if(n%i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public static int gcd(int a, int b)
	{
		if(b == 0)
		 return a;
		
		else
		return gcd(b,a%b);
	}
	
	public static int traverser(int nums[], int n, int k) 
    { 
        int product = 1; 
        
        if (nums[n - 1] == 0 && k % 2 != 0) 
            return 0; 
  
       
        if (nums[n - 1] <= 0 && k % 2 != 0) { 
            for (int i = n - 1; i >= n - k; i--) 
                product *= nums[i]; 
            return product; 
        } 
        
        int i = 0;
  
        int j = n - 1; 
        if (k % 2 != 0) { 
            product *= nums[j]; 
            j--; 
            k--; 
        } 
        
        k >>= 1;   
		
        for (int l = 0; l < k; l++) { 
            int left_product = nums[i] * nums[i + 1]; 
  
            int right_product = nums[j] * nums[j - 1]; 
  
            if (left_product > right_product) { 
                product *= left_product; 
                i += 2; 
            } 
            else { 
                product *= right_product; 
                j -= 2; 
            } 
        } 
  
        return product; 
    } 
  
	
	public static int[] computePrefix(int arr[], int n)
	{
		int[] prefix = new int[n];
		prefix[0] = arr[0];
		for(int i = 1;i<n;i++)
		{
			prefix[i] = prefix[i-1]+arr[i];
		}
		
		return prefix;
	}
	
	public static int lcm(int a, int b)
	{
		return (a*b)/gcd(a,b);
	}
	
	public static int phi(int n)  //euler totient function
    { 
        int result = 1; 
        for (int i = 2; i < n; i++) 
            if (gcd(i, n) == 1) 
                result++; 
        return result; 
    }

	public static void main(String[] args) throws IOException 
	{ 
		Reader sc=new Reader();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = sc.readArray(n);
		
		int sum = 0;
		int max = 0;
		
		for(int i = 0;i<n-1;i++)
		{
			sum = arr[i] - arr[i+1] - k;
			
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}		
}


 