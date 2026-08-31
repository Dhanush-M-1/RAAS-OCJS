import java.util.*;
public class main
{
	public static void main(String[] args) {
		Scanner c = new Scanner(System.in);
		int a = c.nextInt();
		int b = c.nextInt();
		int sum = (int)Math.ceil((a+b)/2);
		int dif1 = Math.abs(sum-a);
		int dif2 = Math.abs(sum-b);
		int ans1 = (dif1*(dif1+1))/2;
		int ans2 = (dif2*(dif2+1))/2;
		System.out.println(ans1 + ans2);
	}
}