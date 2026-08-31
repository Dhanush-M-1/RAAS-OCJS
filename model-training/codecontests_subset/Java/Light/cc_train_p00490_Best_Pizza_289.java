import java.util.*;

class Main{
	public static void main(String[] args){
		Solve s = new Solve();
		s.solve();
	}	
}

class Solve{
	Solve(){}
	
	Scanner in = new Scanner(System.in);

	void solve(){
		int n = in.nextInt();
		int a = in.nextInt(), b = in.nextInt();
		int c = in.nextInt();

		int[] d = new int[n];
		for(int i = 0; i < n; i++) d[i] = -in.nextInt();

		Arrays.sort(d);

		int ans = c, i = 0;
		while(true){
			if((double)c/a < (double)(c - d[i])/(a + b)){
				c -= d[i];
				a += b;
				i++;
			}
			else break;
		}

		System.out.println(c/a);
	}
	
	
}