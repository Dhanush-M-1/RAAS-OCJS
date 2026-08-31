import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FastReader s = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = s.nextInt();
		
		for(int a=0;a<t;a++) {
			int n = s.nextInt();
			long l = s.nextLong();
			long r = s.nextLong();
			
			long[] arr = new long[n];
			
			long sum = 0;
			long val = 2*(n-1);
			for(int i=0;i<n-1;i++) {
				sum += val;
				val -= 2;
				
				arr[i] = sum;
			}
			arr[n-1] = arr[n-2] + 1;
			
//			for(int i=0;i<n;i++)
//				System.out.println(arr[i]);
			int index = upperBound(arr, l);
			//System.out.println(index);
			print(arr, l, r, index, out);
			out.println();
		}
		
		out.flush();
	}
	
	public static void print(long[] arr, long l, long r, int index, PrintWriter out) {
		int n = arr.length;
		
		if(index == n-1) {
			out.print(1+" ");
			return;
		}
		long val1 = index + 1, val2 = 0;
		long end = arr[index];
		if(l%2 == 0) {
			val2 = n - (end-l)/2;
		}
		else {
			val2 = n - (end-l-1)/2;
		}
		
		for(long i=l;l <= Math.min(end, r);l++) {
			if(l%2 == 1)
				out.print(val1+" ");
			else {
				out.print(val2+" ");
				val2++;
			}
				
		}
		
		if(end < r)
			print(arr, end + 1, r, index + 1, out);
	}
	
	public static int upperBound(long[] arr, long v) {
		if(v > arr[arr.length-1])
			return -1;
		if(arr[0] > v)
			return 0;
		int low = 0, high = arr.length - 1;
		
		while(low < high) {
			
			if(low == high - 1) {
				if(arr[low] >= v)
					high = low;
				else
					low = high;
				break;
			}
			int mid = (low + high)/2;
			
			if(arr[mid] >= v)
				high = mid;
			else
				low = mid + 1;
		}
		
		return low;
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
    }

}
