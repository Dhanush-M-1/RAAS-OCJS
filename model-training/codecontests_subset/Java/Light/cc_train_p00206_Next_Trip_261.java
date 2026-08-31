
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;


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
		while(in.hasNext()){
			int l = in.nextInt();
			if(l == 0) return;
			int a = 0;
			boolean f = true;
			for(int i = 0; i < 12; i++){
				int m = in.nextInt(), n = in.nextInt();
				a += m - n;
				if(a >= l && f){
					System.out.println(i + 1);
					f =false;
				}
				if(i == 11 && f) System.out.println("NA");
			}
		}
	}

	

}