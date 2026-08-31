import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		if (a == b) {
			System.out.println(0);
		} else {
			int a2 = f(a, 2);
			int a3 = f(a, 3);
			int a5 = f(a, 5);
			int b2 = f(b, 2);
			int b3 = f(b, 3);
			int b5 = f(b, 5);
			int min2 = Math.min(a2, b2);
			int min3 = Math.min(a3, b3);
			int min5 = Math.min(a5, b5);
			int ans = 0;
			if(a2 < b2){
				for(int i = 0; i < b2 - a2; i++){
					b/=2;
					ans++;
				}
			}else{
				for(int i = 0; i < a2 - b2; i++){
					a/=2;
					ans++;
				}
			}
			if(a3 < b3){
				for(int i = 0; i < b3 - a3; i++){
					b/=3;
					ans++;
				}
			}else{
				for(int i = 0; i < a3 - b3; i++){
					a/=3;
					ans++;
				}
			}
			if(a5 < b5){
				for(int i = 0; i < b5 - a5; i++){
					b/=5;
					ans++;
				}
			}else{
				for(int i = 0; i < a5 - b5; i++){
					a/=5;
					ans++;
				}
			}
			if(a == b){
				System.out.println(ans);
			}else{
				System.out.println(-1);
			}
			
		}
	}

	private static int f(int a, int i) {
		int ans = 0;
		int temp = a;
		while(temp % i == 0){
			temp /= i;
			ans++;
		}
		return ans;
	}

}
