import java.util.*;
import static java.lang.Math.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		// 入力
		String n = sc.next();
		int k = sc.nextInt();
		
		// 計算
		long result = 0;
		result = cnt(n, k);
		//System.out.println(next("00050"));
		// 出力
		System.out.println(result);
	}
	
	static long cnt(String n, int k){
	    int len = n.length();
	    long res = 0;
		if(k == 1){
		    int a = n.charAt(0)-'0';
		    res += (len-1)*9 + a;
		}
		if(len >= 2 && k == 2){
		    StringBuilder sb = new StringBuilder();
		    for(int i = 0; i < len-1; i++){
		        sb.append("9");
		    }
		    int a = n.charAt(0)-'0';
		    res += cnt(sb.toString(), 1)*(a-1);
		    res += cnt(sb.toString(), 2);
		    int index = next(n.substring(1));
		    if(index >= 0) res += cnt(n.substring(index+1), 1);
		}
		if(len >= 3 && k == 3){
		    StringBuilder sb = new StringBuilder();
		    for(int i = 0; i < len-1; i++){
		        sb.append("9");
		    }
		    res += cnt(sb.toString(), 2)*((n.charAt(0)-'0')-1);
		    res += cnt(sb.toString(), 3);
		    int index = next(n.substring(1));
		    if(index >= 0) res += cnt(n.substring(index+1), 2);
		}
		return res;
	}
	
	static int next(String n){
	    int res = 100000;
	    if(n.indexOf('1') >= 0){
	        res = min(res, n.indexOf('1'));
	    }
	    if(n.indexOf('2') >= 0){
	        res = min(res, n.indexOf('2'));
	    }
	    if(n.indexOf('3') >= 0){
	        res = min(res, n.indexOf('3'));
	    }
	    if(n.indexOf('4') >= 0){
	        res = min(res, n.indexOf('4'));
	    }
	    if(n.indexOf('5') >= 0){
	        res = min(res, n.indexOf('5'));
	    }
	    if(n.indexOf('6') >= 0){
	        res = min(res, n.indexOf('6'));
	    }
	    if(n.indexOf('7') >= 0){
	        res = min(res, n.indexOf('7'));
	    }
	    if(n.indexOf('8') >= 0){
	        res = min(res, n.indexOf('8'));
	    }
	    if(n.indexOf('9') >= 0){
	        res = min(res, n.indexOf('9'));
	    }
	    if(res == 100000) res = -1;
	    return res;
	}
}

