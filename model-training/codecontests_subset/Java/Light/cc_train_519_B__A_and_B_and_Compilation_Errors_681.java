import java.util.*;
public class AandB {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int sum1=0,sum2=0,sum3=0;
		for(int i=0;i<n;i++)
			sum1=sum1+s.nextInt();
		for(int i=0;i<n-1;i++)
			sum2=sum2+s.nextInt();
		for(int i=0;i<n-2;i++)
			sum3=sum3+s.nextInt();
		System.out.println(sum1-sum2);
		System.out.println(sum2-sum3);
	}
}