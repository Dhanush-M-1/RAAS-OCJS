import java.util.*;

public class ProblemA {
	public static void main(String[] args) {
		@SuppressWarnings({ "unused", "resource" })
		Scanner sc = new Scanner(System.in);
		
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		int max=Math.max(a, b);
		int min=Math.min(b, a);
		
		a=min;
		b=max;
		
		int total=b-a;
		int first=total/2+total%2;
		int second=total/2;
		
		System.out.println(((first*(first+1))/2+(second*(second+1))/2));
		
	}
}
