import java.util.*;
public class Main {
	static Scanner sc = new Scanner(System.in);
	static int Q;
	static int[] N;
	public static void main(String[] args) {
		while(read()){
			solve();
		}
	}
	
	static boolean read(){
		if(!sc.hasNext())return false;
		Q = sc.nextInt();
		N = new int[Q];
		for(int i = 0; i < N.length; i++){
			N[i] = sc.nextInt();
		}
		return true;
	}
	
	static void solve(){
		for(int i = 0; i < N.length; i++){
			int res = 0;
			String value = new String(Integer.toString(N[i]));
			boolean canSolve = true;
			while(value.length() != 1){
				int product = 0;
				for(int j = 1; j < value.length(); j++){
					String sub1 = value.substring(0, j);					
					String sub2 = value.substring(j);					
					int productNow = Integer.parseInt(sub1)*Integer.parseInt(sub2);
					if(productNow > product)product = productNow;
				}
				res++;
				if(product > Integer.parseInt(value)){
					canSolve = false;
					break;
				}
				value = Integer.toString(product);
			}
			System.out.println(canSolve ? res : -1);
		}
	}
}