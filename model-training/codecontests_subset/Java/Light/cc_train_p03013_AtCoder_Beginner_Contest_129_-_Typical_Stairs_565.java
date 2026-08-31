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
			step[i] = 0;
			a[i] = false;
		}
		for(int i=0;i<m;i++){
			a[sc.nextInt()] = true;
		}
		step[0] = 1;
	}
	void solve(){
		for(int i = 1;i<=n;i++){
			if(a[i]) continue;
			step[i] = step[i-1];
			if(i>1) step[i] += step[i-2];
			step[i]%=1000000007;
		}
		System.out.println(step[n]);
	}
}