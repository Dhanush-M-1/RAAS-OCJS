import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] x=new int[n];
		for(int i=0;i<n;i++) {
			x[i]=sc.nextInt();
		}
		Arrays.sort(x);
		for(int i=n-1;i>=0;i--) {
			if(k%x[i]==0) {
				System.out.print(k/x[i]);
				break;
			}
		}
	}
}