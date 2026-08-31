import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String[] suit = {"S","H","C","D"};
		String[] rank = {"1","2","3","4","5","6","7","8","9","10","11","12","13"};
		int n = sc.nextInt();
		String[][] card = new String[4][13];
		for (int i = 0; i < n; i ++ ){
			String s = sc.next();
			String r = sc.next();
			int sIdx = Arrays.asList(suit).indexOf(s);
			int rIdx = Arrays.asList(rank).indexOf(r);
//			System.out.println(sIdx + " " + rIdx);
			card[sIdx][rIdx] = "ok";
		}
		for (int i = 0; i < 4; i ++ ){
			for (int k = 0; k < 13; k ++ ){
				if (card[i][k] == null){
					System.out.println(suit[i] + " " + rank[k]);
				}
			}
		}
		sc.close();
	}
}