import java.util.Scanner;

public class problem175 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int totaldata = a*c;
		int totaltimereq = totaldata/b;
		if(totaldata%b!=0)
		{
			totaltimereq++;
			System.out.println(totaltimereq-c);
		}
		else
			System.out.println(totaltimereq-c);

	}

}
