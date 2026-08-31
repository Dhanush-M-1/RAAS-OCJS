import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        boolean[][] l = new boolean[4][13];
        char[] card = new char[] {'S', 'H', 'C', 'D'};

        for(int i = 0; i < a; i++) {
        	char cardType = sc.next().charAt(0);
        	int cardNum = sc.nextInt();

        	switch(cardType) {
        	case 'S':
        		l[0][cardNum-1] = true;
        		break;
        	case 'H':
        		l[1][cardNum-1] = true;
        		break;
        	case 'C':
        		l[2][cardNum-1] = true;
        		break;
        	case 'D':
        		l[3][cardNum-1] = true;
        		break;
        	}
        }

        for(int i = 0; i < 4; i++) {

        	for(int j = 0; j < 13; j++) {

        		if(!l[i][j]) {
        			System.out.println(card[i] + " " + (j+1));
        		}
        	}
        }
	}
}

