import java.util.*;
public class WinOrFreeze {
	public static void main(String[] Args){
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int num = 0;
		boolean done = false;
		long tans = 1;
		for(long k = 2; k * k <= n && !done; k++){
			while(n%k==0 && num < 2 && k != n){
				tans*= k;
				num++;
				n/=k;
			}
			if(num==2 && !done){
				System.out.println(1);
				System.out.println(tans);
				done = true;
			}
		}
		if(num==0){
			System.out.println(1);
			System.out.println(0);
		}
		else if(!done){
			System.out.println(2);
		}
	}
}
