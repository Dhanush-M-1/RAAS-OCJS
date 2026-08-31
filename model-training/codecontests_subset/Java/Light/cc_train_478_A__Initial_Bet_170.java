
import java.util.Scanner;



public class A {
	public  static  Scanner scan = new Scanner(System.in);
	
	
	public static void solve () {
		int x1=scan.nextInt();
		int x2=scan.nextInt();
		int x3=scan.nextInt();
		int x4=scan.nextInt();
		int x5=scan.nextInt();
		int sum=(x1+x2+x3+x4+x5);
		if(sum%5==0 && sum!=0) System.out.println(sum/5);
		else System.out.println("-1");
		
	}
	public static void main(String[] args) {
	
		solve();
		scan.close();
	}

}
