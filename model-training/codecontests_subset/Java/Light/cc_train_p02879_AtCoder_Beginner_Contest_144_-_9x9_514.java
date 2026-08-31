import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int ans = num1 < 10 && num2 < 10 ? num1 * num2 : -1;
		System.out.println(ans);
	}
}


