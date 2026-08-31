
import java.util.Scanner;

public class A143_Help_Vasilisa_the_Wise2 {
	

	public static void main(String[] args) {
		Scanner ss = new Scanner (System.in) ; 
		int r1 =ss.nextInt() ; 
		int r2 = ss.nextInt() ; 
		int c1 =ss.nextInt() ; 
		int c2 =ss.nextInt() ; 
		int d1 =ss.nextInt() ; 
		int d2 = ss.nextInt() ; 
		int a = (r2+d2-c2)/2 ; 
		int b = a-d2+c2 ; 
		int x = c1-a ; 
		int y = c2-b ; 
		if (a!=b && a!=x && a!=y && b!=x && b!=y && x!=y && a+b ==r2 && x+y ==r1  && x>0 && x<10 && y>0 && y<10 && a>0 && a<10 && b>0 && b<10 ) {
			System.out.printf("%d %d\n%d %d",x,y,a,b);
		}
		else {
			System.out.println(-1);
		}
	}

}
