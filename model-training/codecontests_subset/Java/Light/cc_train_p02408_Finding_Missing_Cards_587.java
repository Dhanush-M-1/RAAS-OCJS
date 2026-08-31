import java.util.Scanner;
public class Main { 
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		boolean[][]cards = new boolean[4][13];
		char[] mark = {'S','H','C','D'};

		int n = scan.nextInt();
		for(int i=0;i<n;i++) {
			char c = scan.next().charAt(0);
			int num = Integer.parseInt(scan.next());

			switch(c) {
			case 'S': cards[0][num-1] = true; break;
			case 'H': cards[1][num-1] = true; break;
			case 'C': cards[2][num-1] = true; break;
			case 'D': cards[3][num-1] = true; break;

			}
		}
		for (int i=0;i<4;i++) {
			for (int j=0;j<13;j++) {
				if(!cards[i][j]) System.out.println(mark[i] + " "+(j+1));
			}
		}
	}
}


