import java.util.*;
import static java.lang.Math.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// 入力
		int n = sc.nextInt();
		int[] p = new int[n];
		for(int i = 0; i < n; i++){
		    p[i] = sc.nextInt()-1;
		}
		
		// 計算
		int result = 0;
		int cnt = 0;
		boolean flg = false;
		for(int i = 0; i < n; i++){
		    if(flg){
		        result++;
		        flg = false;
		    }else if(p[i] == i){
		        flg = true;
		    }
		}
		if(flg) result++;
		
		// 出力
		System.out.println(result);
	}
}


