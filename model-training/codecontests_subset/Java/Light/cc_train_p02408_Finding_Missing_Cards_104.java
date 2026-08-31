import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean[][] cardHasFlag =new boolean[4][13];
		int cardNum=sc.nextInt();
		for(int i=0;i<cardNum;i++) {
			String sign =sc.next();
			int card=sc.nextInt();

			switch(sign) {
			case "S":
				cardHasFlag[0][card-1]=true;
				break;
			case "H":
				cardHasFlag[1][card-1]=true;
				break;
			case "C":
				cardHasFlag[2][card-1]=true;
				break;
			case "D":
				cardHasFlag[3][card-1]=true;
				break;
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<13;j++) {
				if(cardHasFlag[i][j]==false) {
					switch(i) {
					case 0:
						System.out.printf("S %d\n",j+1);
						break;
					case 1:
						System.out.printf("H %d\n",j+1);
						break;
					case 2:
						System.out.printf("C %d\n",j+1);
						break;
					case 3:
						System.out.printf("D %d\n",j+1);
						break;
					}
				}
			}
		}

	}

}

