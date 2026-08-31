///package implementation;
import java.util.Scanner;
public class NewYearCandles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b,cnt=0;
		a=sc.nextInt();
		b=sc.nextInt();
		while(a!=0)
		{
			a--;
			cnt++;
			if(cnt%b==0) a++;
		}
		System.out.println(cnt);		
		sc.close();
	}
}