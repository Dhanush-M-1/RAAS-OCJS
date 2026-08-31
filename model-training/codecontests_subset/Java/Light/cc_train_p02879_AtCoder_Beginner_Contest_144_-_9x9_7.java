import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a > 9 || b > 9) {
		    System.out.println(-1);
		} else {
		    System.out.println(a * b);
		}
      
	}
}