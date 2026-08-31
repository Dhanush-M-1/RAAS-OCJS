import java.util.*;
public class Main {
	static Scanner sc = new Scanner(System.in);
	static double n, x, y;
	public static void main(String[] args) {
		while(read()){
			solve();
		}
	}
	
	static boolean read(){
		if(!sc.hasNext())return false;
		n = sc.nextDouble();
		x = sc.nextDouble();
		y = sc.nextDouble();
		return true;
	}
	
	static void solve(){
		double d = (n/100)*y;
		double res = Math.ceil(d-x);
		if(res > 0.0){
			System.out.println((int)res);
		}else{
			System.out.println(0);
		}
	}

}
