import java.util.Scanner;
 
public class hef {
 
	public static boolean check(int a[],int n,long mid) {
		
		long sum = 0;
		for(int i=0;i<n;i++) {
			if(a[i]>mid) {
				return false;
			}
			sum+=mid-a[i];
		}
		if(sum>=mid) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a[] = new int[n];
		long sum = 0;
		for(int i=0;i<n;i++)
		{
			a[i] = s.nextInt();
			sum+=a[i];
		}

		long start=2,end=sum,best = 0;
		
		while(start<=end) {
			long mid = (start+end)/2;
			if(check(a,n,mid)) {
				//System.out.println("HEEH");
				best = mid;
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		System.out.println(best);
	    
		
	}
}