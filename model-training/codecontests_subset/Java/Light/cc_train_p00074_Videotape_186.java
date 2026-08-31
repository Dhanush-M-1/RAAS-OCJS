import java.util.*;
public class Main {
	static Scanner sc = new Scanner(System.in);
	static int h, m, s;
	public static void main(String[] args) {
		while(read()){
			solve();
		}
	}
	static boolean read(){
		h = sc.nextInt();
		m = sc.nextInt();
		s = sc.nextInt();
		if( h == -1 && m == -1 && s == -1)return false;
		return true;
	}
	static void solve(){
		int time = h*3600 + m*60 + s;
		int res = 7200 - time;
		int res3 = 7200*3 - time*3;
		System.out.printf("%02d:%02d:%02d\n", res/3600, (res%3600)/60, res%60);
		System.out.printf("%02d:%02d:%02d\n", res3/3600, res3%3600/60, res3%60);
	}
}