import java.util.*;
public class AandBandCompilationErrors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum1=0,sum2=0,sum3=0,x=0,ans1=0,ans2=0;
		for(int i=0;i<n;i++) {
			x= sc.nextInt();
			sum1+=x;
		}
		for(int i=0;i<n-1;i++) {
			x=sc.nextInt();
			sum2+=x;
		}
		ans1=sum1-sum2;
		System.out.println(ans1);
		for(int i=0;i<n-2;i++) {
			x=sc.nextInt();
			sum3+=x;
		}
		ans2=sum2-sum3;
		System.out.println(ans2);
		

	}

}