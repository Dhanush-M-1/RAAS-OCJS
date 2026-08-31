import java.util.ArrayList;
import java.util.Scanner;

public class Main{

	//全てのカードリストを作る
	//入力されたカードをリストから除外する
	//出力
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<String> all_cards=new ArrayList<String>();
		String[] card_hilt_ary={"S","H","C","D"};

		//全てのカードリストを作る
		for(int i=0;i<4;i++){
			for(int j=1;j<=13;j++){
				all_cards.add(card_hilt_ary[i]+" "+String.valueOf(j));
			}
		}

		//カードを除外
		int being_num=sc.nextInt();
		for(int i=0;i<being_num;i++){
			String hilt=sc.next();
			String num=sc.next();
			//String being_cards=hilt+num;
			all_cards.remove(hilt+" "+num);
		}

		//出力
		for(int i=0;i<all_cards.size();i++){
			System.out.println(all_cards.get(i));
		}
	}

}

