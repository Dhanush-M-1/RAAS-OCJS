import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int a[]=new int[N];
		for(int i=0;i<N;i++) {
			a[i]=sc.nextInt();
		}
		int b[]=new int[N];
		int satisfy=0;
		for(int i=0;i<N;i++) {
			b[i]=sc.nextInt();
			satisfy+=b[i];
		}
		int c[]=new int[N-1];
		for(int i=0;i<N-1;i++) {
			c[i]=sc.nextInt();

		}
		for(int i=0;i<N-1;i++) {
			if(a[i+1]==a[i]+1) {
				satisfy+=c[a[i]-1];
			}
		}
		System.out.println(satisfy);
	}

}
