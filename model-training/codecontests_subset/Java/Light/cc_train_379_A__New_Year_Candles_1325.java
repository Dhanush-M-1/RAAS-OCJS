import java.util.*;
public class NewYearCandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt() , b =in .nextInt();
		
		int ans = a;
		int burnt = a;
		
		while(burnt >= b){
			ans = ans + (burnt/b);
			burnt = (burnt/b) + burnt%b;
		}
		System.out.println(ans);
		
		
	}

}
