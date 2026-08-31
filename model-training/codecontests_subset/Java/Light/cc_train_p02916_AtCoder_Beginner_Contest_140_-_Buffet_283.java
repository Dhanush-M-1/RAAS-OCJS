
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int []a=new int[n];
		int []b=new int[n];
		int []c=new int[n-1];
		for(int i=0;i<n;i++) {
			a[i]=scn.nextInt();
		}
		for(int i=0;i<n;i++) {
			b[i]=scn.nextInt();
		}
		for(int i=0;i<n-1;i++) {
			c[i]=scn.nextInt();
		}
		int sum=0;
		for(int i=0;i<n;i++) {
				sum+=b[a[i]-1];
				//System.out.println(b[a[i]-1]);
			if(i>0) {
				if(a[i]==a[i-1]+1) {
					sum+=c[a[i]-2];
					//System.out.println(c[a[i]-2]);
				}
			}
		}
		System.out.println(sum);
	}

}
