import java.util.*;
public class friends {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a =in.nextInt();
		int b = in.nextInt();
		int meet=(a+b)/2;
		int da =Math.abs(a-meet);
		int db =Math.abs(b-meet);
		int sum = 0;
		for(int i=1;i<=db;i++){
			sum+=i;
		}
		for(int i=1;i<=da;i++){
			sum+=i;
		}
		System.out.println(sum);
	}
}
