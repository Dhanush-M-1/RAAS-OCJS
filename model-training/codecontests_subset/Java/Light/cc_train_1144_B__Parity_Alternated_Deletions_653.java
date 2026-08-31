import java.util.*;
public class PolyCrap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	    long a[] = new long[n];
		int e = 0,o=0;
		for(int i=0;i<n;i++) {
			a[i] = sc.nextLong();
			if(a[i]%2==0)
				e++;
			else
				o++;
		}
		Arrays.sort(a);
		long even[] = new long[e];
		long odd[] = new long[o];
		int j=0,k=0;
		for(int i=0;i<n;i++) {
			if(a[i]%2==0)
				even[j++]=a[i];
			else
				odd[k++]=a[i];
		}
		Arrays.sort(even);
		Arrays.sort(odd);
		int ev=even.length;
		int od=odd.length;
		
		if(ev==od || ev==od+1 || od==ev+1)
			System.out.println(0);
		else if(ev>od+1) {
			long sum=0;
			for(int m=0;m<(ev-od-1);m++) {
				sum+=even[m];
			}
			System.out.println(sum);
		}
		else if(od>ev+1) {
			long sum=0;
			for(int m=0;m<(od-ev-1);m++) {
				sum+=odd[m];
			}
			System.out.println(sum);
		}
	}

}
