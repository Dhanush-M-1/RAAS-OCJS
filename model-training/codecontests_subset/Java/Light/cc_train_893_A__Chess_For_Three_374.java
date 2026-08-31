import java.util.Scanner;


public class CF_EDU_33_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int f = 3;
		for(int i=0; i<n; ++i) {
			int a = in.nextInt();
			if(a == f)
			{
				System.out.println("NO");
				return ;
			}
			if((a == 1 && f == 2) || (a == 2 && f == 1)) f = 3;
			else if((a == 2 && f == 3) || (a == 3 && f == 2)) f = 1;
			else if((a == 3 && f == 1) || (a == 1 && f == 3)) f = 2;
		}
		System.out.println("YES");
		in.close();
	}
}
