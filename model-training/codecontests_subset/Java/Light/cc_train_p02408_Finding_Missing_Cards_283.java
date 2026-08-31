import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		String[] patterns = { "S", "H", "C", "D" };
		int cards[][] = new int[4][13];

		//入力されたカードを配列に2次元配列に格納する
		for (int i = 0; i < a; i++) {
			String str = sc.next();
			int num = sc.nextInt();
			cards[convert(str)][num-1] = num;
		}

		//不足してるカードを出力する
		for (int i = 0; i < patterns.length; i++) {
			for (int j = 0; j < 13; j++ ) {
				if(cards[i][j] == 0)
					System.out.println(patterns[i] + " " + (j+1));
			}
		}
	}
	
	public static int convert(String str){
		int value = 0;
		if(str.equals("S")) value = 0;
		else if(str.equals("H")) value = 1;
		else if(str.equals("C")) value = 2;
		else if(str.equals("D")) value = 3;
		return value;
	}
}