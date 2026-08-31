import java.util.*;
 
public class acmp{
	static Scanner in = new Scanner(System.in);
		// int size = in.nextInt();
		// int[] array = new int[size];
		// for(int i = 0; i<size; i++){
		// 	array[i] = in.nextInt();
		// }

		// int min = Integer.MAX_VALUE;
  		// int max = Integer.MIN_VALUE;
 	
	public static void main(String[] args) {
		//zhan
		//dos
		//md
		int test = in.nextInt();
		while(test>0){
			solve();
			test--;
		}
	}

	public static void solve(){
		int n = in.nextInt();

		int three = 0;
		int two = 0;
		while(n != 1){
			if(n%3 == 0){
				n /= 3;
				three++;
			}else if(n%2 == 0){
				n /= 2;
				two++;			
			}else{
				System.out.println(-1);
				return;
			}
		}
		if(three < two){
			System.out.println(-1);
		}else if(three == two){
			System.out.println(three);
		}else{
			System.out.println(three + (three - two));
		}

	}
}