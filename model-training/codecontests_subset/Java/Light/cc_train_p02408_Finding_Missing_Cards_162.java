import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		boolean[][] has_cards = new boolean[4][13];
		Map<String, Integer> sutes = new HashMap<String, Integer>();
		String[] suite_rev = new String[]{"S", "H", "C", "D"};
		sutes.put("S", 0);
		sutes.put("H", 1);
		sutes.put("C", 2);
		sutes.put("D", 3);
		
		final int n = sc.nextInt();
		for(int i = 0; i < n; i++){
			final String sute = sc.next();
			final int num = sc.nextInt() - 1;
			
			has_cards[sutes.get(sute)][num] = true;
		}
		
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
				if(!has_cards[i][j]){
					System.out.println(suite_rev[i] + " " + (j + 1));
				}
			}
		}
		
	}

}