import java.util.*;

public class ChessForThree{
	public static void main (String[] args){
		Scanner kbd = new Scanner(System.in);
		
		int n = kbd.nextInt();
		int count = 0;
		int p = 3;
		
		for(int j = 0; j < n; j++){
			int x = kbd.nextInt();
			if(x== p) {
				count++;
			} else {
				p = 6 - x - p;		
			}
		}
		
		if(count > 0){
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
		
	}
}