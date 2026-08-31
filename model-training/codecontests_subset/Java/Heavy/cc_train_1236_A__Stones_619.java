import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Labs {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner scn = new Scanner(System.in);
	
BufferedReader br=new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
int test=Integer.parseInt(br.readLine());
		while (test-- > 0) {
String []ar=br.readLine().split(" ");
			int a = Integer.parseInt(ar[0]);
			int d = Integer.parseInt(ar[1]);
			int c = Integer.parseInt(ar[2]);

			int res = 0;
			int tempc = c / 2;

			while (tempc > 0 && d > 0) {
				res += 3;
				tempc--;
				d--;
			}
			int tempb = d / 2;

			while (tempb > 0 && a > 0) {
				res += 3;
				tempb--;
				a--;
			}
			System.out.println(res);
		}

	}

}