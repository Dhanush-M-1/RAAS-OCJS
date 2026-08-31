import java.util.Scanner;


public class Kitahara_Harukis_Gift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n  =in.nextInt();
		int x=0;
		int y=0;
		for (int i = 1; i <=n; i++) {
			int a=in.nextInt();
			if(a==100) x++;
			if(a==200) y++;
		}
		if(x%2==1){
			System.out.println("NO");
		}else{
			if(x==0 && y%2==1)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}

}
