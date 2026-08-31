import java.io.PrintWriter;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int a = in.nextInt(), b = in.nextInt(), c = a;
		
		while(true){
			if(a/b >= 1){
				c += a/b;
				a = a/b + a%b;
			}
			else{
				break;
			}
		}
		
		out.printf("%d",c);
		out.close();
	}

}
