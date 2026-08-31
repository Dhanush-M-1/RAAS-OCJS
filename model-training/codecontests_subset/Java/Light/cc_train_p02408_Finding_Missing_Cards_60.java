import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		boolean[][] cards = new boolean[4][13];
		for(int i = 0; i < n; i++){
			int m = getMark(scan.next().charAt(0));
			int num = scan.nextInt() - 1;
			cards[m][num] = true;
		}
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
				if(!cards[i][j]){
					System.out.println(toMark(i) + " " + (j + 1));
				}
			}
		}
	}
	public static int getMark(char c){
		switch(c){
			case 'S' : return 0;
			case 'H' : return 1;
			case 'C' : return 2;
			default : return 3;
		}
	}
	public static String toMark(int c){
		switch(c){
			case 0 : return "S";
			case 1 : return "H";
			case 2 : return "C";
			default : return "D";
		}
	}

}