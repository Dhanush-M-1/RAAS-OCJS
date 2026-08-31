import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] S = new boolean[14];
		boolean[] H = new boolean[14];
		boolean[] C = new boolean[14];
		boolean[] D = new boolean[14];
		String suit;
		int cardNum;
		
		for (int i = 0; i < n; i++){
			suit = sc.next();
			cardNum = sc.nextInt();
			if (suit.equals("S")){S[cardNum] = true;}
			if (suit.equals("H")){H[cardNum] = true;}
			if (suit.equals("C")){C[cardNum] = true;}
			if (suit.equals("D")){D[cardNum] = true;}
		}
		
		printCards("S", S);
		printCards("H", H);
		printCards("C", C);
		printCards("D", D);
	}
	
	static void printCards(String suit, boolean[] cards){
		for (int i = 1; i <= 13; i++){
			if (!(cards[i])){
				System.out.println(suit + " " + i);
			}
		}
	}
}