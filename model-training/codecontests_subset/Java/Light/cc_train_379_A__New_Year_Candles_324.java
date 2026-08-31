import java.util.Scanner;


public class Q26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt(),b=scan.nextInt();
		int hour=a;
		while(a>=b){
			int r=a/b;			
			hour+=r;
			int temp=a;
			a/=b;			
			a+=temp%b;					
		}
		System.out.println(hour);
	}

}
