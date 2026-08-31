import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int b=s.nextInt();
		int c=s.nextInt();
		int k=(int) Math.ceil(a*c/100.);
		int t=k-b;
		System.out.println(Math.max(0, t));
	}

}
