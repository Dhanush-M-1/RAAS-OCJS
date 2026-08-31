import java.util.*;
public class azz {
	public static void main (String [] args) {
		Scanner sc=new Scanner (System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
			}
		int p1=1;
		int p2=2;
		int s=3;
		for(int i=0;i<n;i++) {
			if (a[i]==p1) {
				int tmp=s;
				s=p2;
				p2=tmp;
			}
			else
			{
				if(a[i]==p2) {
					int tmp=s;
					s=p1;
					p1=tmp;
					
				}
				else {
					System.out.print("No");return;
				}
			}
			

		}
		System.out.print("Yes");

	 

}
	}
