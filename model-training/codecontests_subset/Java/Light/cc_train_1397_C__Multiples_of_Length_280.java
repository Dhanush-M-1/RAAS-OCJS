import java.util.*;
public class p3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
			int n=0;
			n=sc.nextInt();
			long arr[]=new long[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextLong();
			}
			long val1=0;
			val1=-arr[0];
			arr[0]+=val1;
			System.out.println(1+" "+1);
			System.out.println(val1);
			if(n==1) {
				System.out.println(1+" "+1);
				System.out.println("0");
				System.out.println(1+" "+n);
				for(int i=0;i<n;i++) {
					System.out.print((-1*arr[i])+" ");
				}
			}
			else {
				System.out.println(2+" "+n);
				for(int i=1;i<n;i++) {
					System.out.print((n-1)*arr[i]+" ");
					arr[i]+=((n-1)*arr[i]);
				}
				System.out.println();
				System.out.println(1+" "+n);
				for(int i=0;i<n;i++) {
					System.out.print((-1*arr[i])+" ");
				}
				System.out.println();
			}
	}
}