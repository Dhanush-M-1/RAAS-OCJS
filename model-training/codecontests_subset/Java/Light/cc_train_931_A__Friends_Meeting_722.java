import java.util.Scanner;

public class A_Friends_Meeting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		 int b = sc.nextInt();
		 int k = Math.abs(a-b);
		 if(k % 2 == 0) {
			 System.out.println(2*(fact(k/2)));
		 }
		 else {
		
			 System.out.println(2*fact(k/2)+(int)Math.ceil((double)k/2));
		 } 
	}

	public static int fact(int a) {
		int f=0;
		for(int i = 1 ; i <= a ; i++) {
			f = f+i;
		}
		
		return f;
	}

}
