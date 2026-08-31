import java.util.Scanner;

public class cf_663_prob_C {
	public static long ppow(long n) {
		long ans=1;
		for(long i=1;i<=n;i++)
			ans=(ans*2)%1000000007;
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long n;
		long ans;
		ans=1;
		n=sc.nextLong();
		for(long i=1;i<=n;i++)
			ans=((ans%1000000007)*(i%1000000007))%1000000007;
		ans=((ans%1000000007)-((ppow(n-1))%1000000007))%1000000007;
		if(ans<0)
			ans=ans+1000000007;
		System.out.println(ans);
	}
}
