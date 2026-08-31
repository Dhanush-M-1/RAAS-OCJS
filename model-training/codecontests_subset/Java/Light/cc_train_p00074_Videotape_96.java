import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc =  new Scanner (System.in);
		while(true){
			int h = sc.nextInt(),
				d = sc.nextInt(),
				s = sc.nextInt();
			if( h == -1 & d == -1 & s == -1)break;
			int sum = h*3600 + d*60 + s;
			int ans1 = 2*3600 - sum;
			int ans2 = 2*3600*3 - sum*3;
			System.out.printf("%02d:%02d:%02d\n", ans1/3600 , ans1%3600/60, ans1%60);
			System.out.printf("%02d:%02d:%02d\n", ans2/3600 , ans2%3600/60, ans2%60);
		}
	}

}