import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		int s1;
		s1 = (a-b)*c;
		int res = s1/b;
		if(res*b < s1)
			res++;
		System.out.println(res);
		
	}

}
