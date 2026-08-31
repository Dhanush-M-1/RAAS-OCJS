import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn =new Scanner(System.in);
		int n=scn.nextInt();
		long []arr =new long[n+1];
		long mod = (long)(Math.pow(10, 9)+7);
		long val=1l;
		for(int i=1;i<=n;i++){
			val*=(long)((i)%mod);
			val%=mod;
			arr[i]=val;
		}
		
		long ans=0l;
		long  val1 =1l;
		for(int i=1;i<n;i++){
			val1*=2;
			val1%=mod;
			
		}
		System.out.println(((val%mod-val1%mod)+mod)%mod);

	}

}