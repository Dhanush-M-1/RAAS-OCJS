import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;


public class A168 {
	public static void main(String[] args) throws IOException {
		solve();
	}
	
	public static void solve()throws IOException{
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		int n = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		int r = (int) Math.ceil(((n*y) - (100.0*x))/100.0);
		if(r > 0)
			System.out.println(r);
		else
			System.out.println(0);
		scan.close();
	}
}
