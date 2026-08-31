import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class hals {
	static int n;
	static int[] arr;
	static long total =0;
	
	static boolean predicate(int x){
		long rem=x;
		if(x>=total)return true;
		for(int i=0;i<n;i++){
			int now = x-arr[i];
			rem-=now;
		}
		if(rem<=0)return true;
		return false;
	}
	static int bs(int lo,int hi){
		int mid;
		while(lo<hi){
			mid = lo+(hi-lo)/2;
			boolean flag=predicate(mid);
			if(flag)
				hi=mid;
			else
				lo=mid+1;
		}
		return lo;
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] in = br.readLine().split(" ");
		arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(in[i]);
			total+=arr[i];
		}
		Arrays.sort(arr);
		System.out.println(bs(arr[n-1],Integer.MAX_VALUE-10));
	}
}