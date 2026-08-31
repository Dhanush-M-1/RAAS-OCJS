import java.util.*;
public class New_Year_Candles {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int count=a;
		while(a>=b){
			count+=a/b;
			a=(a/b)+(a%b);
		}
		System.out.println(count);
	}
}