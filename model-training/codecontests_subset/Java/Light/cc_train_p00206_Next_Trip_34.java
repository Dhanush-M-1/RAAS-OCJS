import java.util.*;
public class Main {
	static Scanner sc = new Scanner(System.in);
	static int L, N, M;
	static int[][] data;
	public static void main(String[] args) {
		while(read()){
			solve();
		}
	}
	static boolean read(){
		L = sc.nextInt();
		if(L == 0)
			return false;
		data = new int[13][13];
		for(int i = 1; i <= 12; i++){
			M = sc.nextInt(); N = sc.nextInt();
			data[0][i] = M; data[1][i] = N;
		}
		return true;
	}
	static int solve(){
		int wedge = 0;
		for(int i = 1; i <= 12; i++){
			wedge += data[0][i] - data[1][i];
			if(wedge >= L){
				System.out.println(i);
				return 0;
			}
		}
		System.out.println("NA");
		return 0;
	}

}