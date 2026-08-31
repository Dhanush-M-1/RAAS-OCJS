import java.util.Scanner;
public class Runfor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mid = 500000;
		int one = 0, two = 0;
		boolean youGot = true;
		for(int i = 0; i < n; i++){
			int in = sc.nextInt();
			if(!youGot) continue;
			if(in > mid){
				youGot = false;
				two = 1000000 - in;
			}
			else{
				one = in - 1;
			}
		}
		int ans = Math.max(one, two);
		System.out.println(ans);
	}
}