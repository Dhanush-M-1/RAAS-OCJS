import java.util.*;
import java.math.*;
import java.lang.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		String str = sc.next();
		int strLength = str.length();
		String expected = "keyence";
		boolean flag =false;

		if(str.indexOf(expected)==0 || str.indexOf(expected)==strLength-7){
			flag =true;
			}



		for (int i = 1; i < 7; i++) {
			if(flag){
				break;
			}
			String forword = expected.substring(0,i);
			String backword= expected.substring(i);
			int resultF = str.indexOf(forword);
			int resultB = str.lastIndexOf(backword);
			// System.out.println(forword);
			// System.out.println(backword);
			// System.out.println(resultF);
			// System.out.println(resultB);
			
			if(
				resultF == 0 &&
				(resultB == strLength - backword.length())
			){
				flag =true;
			}

		}

		if(flag){
				System.out.println("YES" );
				}else{
				System.out.println("NO" );
				}




	}


}