import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class a {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner scan= new Scanner(System.in);
		int c=scan.nextInt();
		int b=scan.nextInt();
		int h=0;
		while(c>=b){
			c-=b;
			c++;
			h+=b;
		}
		h+=c;
		System.out.println(h);
	}
}
