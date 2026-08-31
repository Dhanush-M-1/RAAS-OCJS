import java.util.Scanner;
 
public class q3 {
 
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		long a[]=new long[n];
		for(int i=0;i<n;i++) {
			a[i]=s.nextLong();
		}
		if(n==1) {
			System.out.println("1 1"); 
			System.out.println("0"); 
			System.out.println("1 1"); 
			System.out.println("0"); 
			System.out.println("1 1"); 
			System.out.println(-a[0]); 
		}else {
			System.out.println("1 "+n); 
			for(int i=0;i<n;i++) {
				System.out.print(-n*a[i]+" "); 
			}
			System.out.println();
			System.out.println("2 "+n);
			for(int i=1;i<n;i++) {
				System.out.print((n-1)*a[i]+" "); 
			}
			System.out.println();
			System.out.println("1 1");
			System.out.println((n-1)*a[0]);
		}
		s.close();
	}
 
}