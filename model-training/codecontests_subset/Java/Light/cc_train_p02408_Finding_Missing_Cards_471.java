import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i, j, k;
		int trmp[][];
		trmp = new int[4][13];
		
		String egara[] = { "S", "H", "C", "D" };
		
		int n = scan.nextInt();
		String x="0";
		int y=0;int card;
		for (k = 1; k <= n; k++) {
			x = scan.next();
			y = scan.nextInt();
if(x.equals(egara[0])){
	card=0;
	trmp[card][y-1]=9999;
}else if(x.equals(egara[1])){
	card=1;
	trmp[card][y-1]=9999;
	}else if(x.equals(egara[2])){
		card=2;
		trmp[card][y-1]=9999;
		}else {
			card=3;
			trmp[card][y-1]=9999;
			}


		}
		for (j = 0; j < 4; j++) {
			for (i = 0; i < 13; i++) {

				if (trmp[j][i]!=9999) {

					System.out.println(egara[j] + " " + (i+1));
				}

			}
		}

	}

}