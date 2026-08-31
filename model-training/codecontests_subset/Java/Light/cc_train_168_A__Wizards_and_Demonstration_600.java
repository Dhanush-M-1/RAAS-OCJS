import java.util.*;
public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(), y =  sc.nextInt() , z = sc.nextInt();
		int mult = x*z, div, resta;
		if(mult % 100 == 0){
			div = mult/100;
			resta = div - y;
			if(resta > 0)
				System.out.println(resta);
				else
				System.out.println("0");
		} else {
			div = (mult/100)+1;
			resta = div - y;
			if(resta > 0)
				System.out.println(resta);
				else
				System.out.println("0");
		
		}
	
	}
}