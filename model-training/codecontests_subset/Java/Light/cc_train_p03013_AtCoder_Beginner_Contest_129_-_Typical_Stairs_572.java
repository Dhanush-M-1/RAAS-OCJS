import java.util.ArrayList;
import java.util.Scanner;
 
class Main {
	int n;
	int m;
	boolean[] a;
	long[] step;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Main m = new Main(sc);
		m.solve();
	}
	Main(Scanner sc){
		n = sc.nextInt();
		m = sc.nextInt();
		a = new boolean[n+1];
		step = new long[n+1];
		for(int i = 0; i <= n;i++){
			a[i] = true;
			step[i] = 0;
		}
		for(int i=0;i<m;i++){
			a[sc.nextInt()] = false;
		}
		step[0] = 1;
	}
	void solve(){
		for(int i = 0;i<n;i++){
			for(int j = i + 1;j <= Math.min(i+2, n);j++){
				if(a[j]){
					step[j] += step[i];
					step[j] %= 1000000007;
				}
			}
		}
		System.out.println(step[n]);
	}
}
