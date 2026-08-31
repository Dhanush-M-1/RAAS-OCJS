import java.util.*;
public class A1334 {
	public static void main(String atgs[]) {
		Scanner in=new Scanner (System.in);
		int t=in.nextInt();
		while(--t>=0) {
			int n=in.nextInt();
			int p[]=new int[n];
			int c[]=new int[n];
			for(int i=0;i<n;i++) {
				p[i]=in.nextInt();
				c[i]=in.nextInt();
			}
			boolean flag=false;
			if(p[0]>=c[0]) {
//				pass
			}
			else {
//				fail
				flag=true;
			}
			for(int i=1;i<n;i++) {
				if(p[i]>p[i-1] && c[i]-c[i-1]<=p[i]-p[i-1] && c[i]>=c[i-1]) {
//					pass
				}
				else if(p[i]==p[i-1] && c[i]==c[i-1]) {
//					pass
				}
				else {
//					fail
					flag=true;
					break;
				}
			}
			if(flag) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			}
		}
	}
}
