import java.util.*;
 
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		
		if(a>=1&&b>=1&&9>=a&&9>=b) {
			System.out.println(a*b);
		}else {
			System.out.println(-1);
		}

		
 
		sc.close();
	}
}