import java.util.*;

class Main{
	public static void main(String args[]){
		Solve s = new Solve();
		s.solve();
	}
}

class Solve{
	Scanner in = new Scanner(System.in);

	void solve(){
		while(in.hasNext()){
			int n = in.nextInt();
			if(n == 0) return;
			
			boolean f = true, l = true, r = true;
			int ans = 0;

			for(int i = 0; i < n; i++){
				String s = in.next();
				if(s.charAt(0) == 'l') l = !l;
				else r = !r;
				if((l == r) && (l != f)){
					ans++;
					f = l;
				}
			}

			System.out.println(ans);
		}
	}
}