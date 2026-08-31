import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int ans = a * b;
		if(ans%2 == 0){
			System.out.println("Even");
		}else{
			System.out.println("Odd");
		}
		
	}

}
