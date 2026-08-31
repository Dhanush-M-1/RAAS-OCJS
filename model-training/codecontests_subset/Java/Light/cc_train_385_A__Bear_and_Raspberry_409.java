import java.util.*;
public class Dragon{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int c=sc.nextInt();
		int d[]=new int[n];
		for (int i=0;i<n;i++) {
			d[i]=sc.nextInt();
		}
		int max=0;
		int f=0;
		int g=0;

		for (int i=0;i<n-1;i++) {
			if (d[i]-d[i+1]>max) {
				max=d[i]-d[i+1];
				f=i+1;
				g=i;
	}}
		if (d[g]-d[f]-c>0) 
			System.out.println(d[g]-d[f]-c); else System.out.println(0);
    }
}