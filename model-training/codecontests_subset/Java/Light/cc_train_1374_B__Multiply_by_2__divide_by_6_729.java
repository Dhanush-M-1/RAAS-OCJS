// Code Forces Mulitply By 2 Divide By 6.
import java.util.*;
public class MulitplyBy2DivideBy6{

		public static void Divisibleby6MutliplyBy2(int X , int moves){
				if(X == 1){
					System.out.println(moves);
				}
			    else if(X%6 == 0){
					X = X/6;
					moves++;
					Divisibleby6MutliplyBy2(X,moves);
				}
				else if( isDivisibleby3(X) ){
					X = X*2;
					moves++;
					X = X/6;
					moves++;
					Divisibleby6MutliplyBy2(X,moves);
				}
				else{
					System.out.println("-1");
				}
			
			}
			public static boolean isDivisibleby3(int x){
			if(x%3 == 0)
				return true;
			else return false;
		}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);	
		int  t = sc.nextInt();
		for(int i=0;i<t;i++){
			int N = sc.nextInt();
		      Divisibleby6MutliplyBy2(N , 0);
		     
		}
	} 
}