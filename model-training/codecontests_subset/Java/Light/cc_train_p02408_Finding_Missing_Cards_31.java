import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int card[][] = new int[4][14];
		char[] m = { 'S', 'H', 'C', 'D' };

		for (int i = 0; i < n; i++) {
			String pic = scan.next();
			int num = scan.nextInt() - 1;
			if ("S".equals(pic)) {
				card[0][num] = 1;
			} else if ("H".equals(pic)) {
				card[1][num] = 1;
			} else if ("C".equals(pic)) {
				card[2][num] = 1;
			} else {
				card[3][num] = 1;
			}
		}		

		for(int i =0;i<=3;i++){
			for(int j =0;j<13;j++){
				if(card[i][j]==0){
					System.out.printf("%s %d%n",m[i],j+1);
				}
			}
		}

	}

}