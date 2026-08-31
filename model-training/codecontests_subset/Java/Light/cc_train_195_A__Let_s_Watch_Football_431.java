import java.util.Scanner;


public class main {
	public static void main (String args []){
		Scanner input = new Scanner ( System.in );
		int a , b , c;
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		int unit1 = a*c ;
		int unit2 = c*b ;
		int unit3= unit1 - unit2 ;
		while(unit3 % b != 0){
			unit3 ++ ;
		}
		int result = unit3 / b ;
		System.out.println(result);
		
	}
}