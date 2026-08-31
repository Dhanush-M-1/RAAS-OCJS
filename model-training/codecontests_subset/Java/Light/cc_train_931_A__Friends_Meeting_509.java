import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int sub = Math.abs(a - b);
		
		if(sub == 0){
			System.out.println("0");
		}
		else if(sub == 1){
			System.out.println("1");
		}
		else if(sub % 2 == 0){
			int amove = sub / 2;
			int bmove = sub / 2;
			//System.out.println("amove: " + amove + ", bmove: " + bmove);
			int sum = 0;
			for(int i = 1; i <= amove; i++){
				sum += i;
			}
			for(int i = 1; i <= bmove; i++){
				sum += i;
			}
			System.out.println(sum);
			//System.out.println(amove + bmove);
		}
		else if(sub % 2 != 0){
			int amove = (sub / 2) + 1;
			int bmove = sub / 2;
			//System.out.println("amove: " + amove + ", bmove: " + bmove);
			int sum = 0;
			for(int i = 1; i <= amove; i++){
				sum += i;
			}
			for(int i = 1; i <= bmove; i++){
				sum += i;
			}
			System.out.println(sum);
		}
		sc.close();
}
	
}