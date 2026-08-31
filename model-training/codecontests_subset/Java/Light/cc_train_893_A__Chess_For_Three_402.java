import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int cursor;
		int spectator = 3;
		String answer = "YES";
		for(int i = 0; i < n; i++) {
			cursor = input.nextInt();
			if(cursor ==  spectator) {
				answer = "NO";
				break;
			}
			if(cursor == 1 && spectator == 2) {
				spectator = 3;
				continue;
			}
			if(cursor == 1 && spectator == 3) {
				spectator = 2;
				continue;
			}
			if(cursor == 2 && spectator == 3) {
				spectator = 1;
				continue;
			}
			if(cursor == 2 && spectator == 1) {
				spectator = 3;
				continue;
			}
			if(cursor == 3 && spectator == 1) {
				spectator = 2;
				continue;
			}
			if(cursor == 3 && spectator == 2) {
				spectator = 1;
				continue;
			}
		}
		PRINT(answer);
	}
	
	static void PRINT(Object s) {
    	System.out.println(s);
    }
}
