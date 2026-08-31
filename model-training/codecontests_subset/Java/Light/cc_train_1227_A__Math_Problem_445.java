
import java.util.Scanner;
public class Main {
	final static int N=(int)(1e5+10);
	static int t;
	static String s;
	static int[] a=new int[N];
	static int[] b=new int[N];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		for(int i =0;i<t;i++) {
			int n=sc.nextInt();
			
			int min=(int)(1e9);
			int max=0;
			for(int j=0;j<n;j++) {
				a[j]=sc.nextInt();
				b[j]=sc.nextInt();
				max=a[j]>max? a[j]:max;
				min=b[j]<min? b[j]:min;
			}
			if(n==1) {
				System.out.println(0);
				continue;
			}
			System.out.println((max-min)>0? max-min:0);
		}
	}

}