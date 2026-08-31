import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int a=in.nextInt();
		int b=in.nextInt();
		int res=(n*b+99)/100-a;
		if(res<0)
		{
			res=0;
		}
		System.out.println(res);
	}
}
