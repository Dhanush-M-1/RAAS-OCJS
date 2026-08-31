import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
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
			print(arr, l, r, index);
			System.out.println();
		}
	}
	
	public static void print(long[] arr, long l, long r, int index) {
		int n = arr.length;
		
		if(index == n-1) {
			System.out.print(1+" ");
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
				System.out.print(val1+" ");
			else {
				System.out.print(val2+" ");
				val2++;
			}
				
		}
		
		if(end < r)
			print(arr, end + 1, r, index + 1);
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

}
