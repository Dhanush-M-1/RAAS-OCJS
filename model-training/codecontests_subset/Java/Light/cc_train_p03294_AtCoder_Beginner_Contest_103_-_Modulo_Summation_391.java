import java.util.*;
import static java.lang.Math.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		// 入力
		int n = sc.nextInt();
		int sum = 0;
		for(int i = 0; i < n; i++){
		    sum += sc.nextInt();
		}
		
		// 計算
		
		// 出力
		System.out.println(sum - n);
	}
}
