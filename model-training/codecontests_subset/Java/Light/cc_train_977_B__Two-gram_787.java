import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		String s=sc.next();
		String s2[]=new String[n-1];
		int a[]=new int[n];
		int t=0,i,test=0,i2,max,max2;
		for(i=0;i<n;i++) {
			a[i]=0;
		}
		String s3;
		for(i=0;i<n-1;i++) {
			test=0;
		s3=s.substring(i, i+2);
		for(i2=0;i2<t;i2++) {
			if(s3.compareTo(s2[i2])==0) {
				test=1;
				a[i2]++;
				break;
			}
		}
		if(test==0) {
			s2[t]=s3;
			t++;
		}
		}
		max=a[0];
		max2=0;
		for(i=1;i<=t;i++) {
			if(a[i]>max) {
				max=a[i];
				max2=i;
			}
		}
		System.out.print(s2[max2]);
	}
}