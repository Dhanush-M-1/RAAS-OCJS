import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
      if(a+b == c || a+c == b || c+b ==a){
        System.out.println("Yes");
      }else{   
		// 出力
		System.out.println("No");
	}
    }
}