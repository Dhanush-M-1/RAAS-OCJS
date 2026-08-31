import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int a = stdIn.nextInt();
		int b = stdIn.nextInt();
		
		if(a>=10 || b >=10) {
			System.out.println(-1);
		}else {
			System.out.println(a*b);
		}
		
		
		
		
	}

}
