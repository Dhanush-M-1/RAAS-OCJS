import java.util.*;

public class medians{
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();long s=scan.nextLong();
		long[] a=new long[n];
		for (int i=0;i<n;i++) {
			a[i]=scan.nextLong();
		}
		Arrays.sort(a);
		double ans=0;
		for(int i=0;i<n/2;i++){
			if(a[i]>s)
				ans+=a[i]-s;
		}
		ans+=Math.abs(s-a[n/2]);
		for(int i=n/2+1;i<n;i++){
			if(a[i]<s)
				ans+=s-a[i];
		}
		System.out.println((long)ans);
	}
}