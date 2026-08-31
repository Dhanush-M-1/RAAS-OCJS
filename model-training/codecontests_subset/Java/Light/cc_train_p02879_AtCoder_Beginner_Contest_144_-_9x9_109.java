import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//In
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		//Process Out
		if(a>9 || b>9) {
			System.out.println(-1);
		}else {
			System.out.println(a*b);
		}
		
	}

}
