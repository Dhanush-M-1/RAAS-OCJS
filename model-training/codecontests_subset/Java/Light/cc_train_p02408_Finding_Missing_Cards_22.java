import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	 public static void main(String[] args) {
		 try (Scanner sc = new Scanner(System.in)) {
			 /* 完品トランプcardsの生成 */
			 String[] ptn = {"S ","H ","C ","D "};
			 List<String> cards = new ArrayList<String>(52);
			 for(int i = 0; i < 4; i++) {
				 for(int j = 1; j <=13 ; j++) {
					 cards.add(ptn[i] + j);
				 }
			 }
			 /* 完品トランプの生成ここまで */

			 // 入力1行目入力カード総数の読み込み, 改行文字空読み
			 int num = sc.nextInt();
			 sc.nextLine();

			 // 完品トランプから, 入力のカードを削除
			 for(int i = 0; i<num; i++) {
				 String cd = sc.nextLine();
				 cards.remove(cd);
			 }

			 // 入力カード削除後のcardsの出力
			 for (String str : cards) {
			    System.out.println(str);
			 }
		 }
	 }
}
