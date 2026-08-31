import java.util.*;
class Main {
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();

		String[] mark = {"S", "H", "C", "D"};

		for(int i = 0; i < 4; i++){
			for(int j = 1; j <= 13; j++){
				list.add(mark[i] + " " + j );
			}
		}

		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		for(int i = 0; i < n; i++){
			// ここのlistはint n(変数) ではだめ。理由はlist配列は参照型だから基本データ型のint n(変数)ではremoveできない
			list.remove(sc.nextLine());
		}

		for(String str : list){
			System.out.println(str);
		}
		
	}
}
