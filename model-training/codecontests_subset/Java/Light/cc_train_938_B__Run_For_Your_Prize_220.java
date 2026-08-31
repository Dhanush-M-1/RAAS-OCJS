import java.util.Scanner;
public class Main {
	public static Scanner cin=new Scanner(System.in);
	public static void main(String[] args) {
		int n=cin.nextInt(),ans=1000000;
		int []a=new int[n+10];
		a[0]=1;
		for(int i=1;i<=n;i++)a[i]=cin.nextInt();
		a[n+1]=1000000;
		for(int i=1;i<=n+1;i++) {
			ans=Math.min(ans,Math.max(a[i-1]-1,1000000-a[i]));
		}
		System.out.println(ans);
	}
}