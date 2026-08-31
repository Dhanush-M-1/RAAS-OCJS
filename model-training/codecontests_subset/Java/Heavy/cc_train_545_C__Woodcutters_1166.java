import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int cTr = scan.nextInt();
				  scan.nextInt();
		int nTr = 0;
		int cTall = 0;
		if (n > 1) {
			nTr = scan.nextInt();
			cTall = scan.nextInt();
		}
		int lM=cTr;
		int c = 1;
		while (n > 2) {
			cTr = nTr;
			nTr = scan.nextInt();
			if (cTr - cTall > lM) {
				c++;
				lM = cTr;
			}
			else if (cTr + cTall < nTr) {
				c++;
				lM = cTr + cTall;
			}
			else {
				lM = cTr;
			}
			
			cTall = scan.nextInt();
			n--;
		}
		if (n > 1) c++;
		System.out.println(c);
		
	}
}
