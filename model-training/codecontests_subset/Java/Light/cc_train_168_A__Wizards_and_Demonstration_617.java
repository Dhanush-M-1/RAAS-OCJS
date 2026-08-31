
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		int n;
		int x;
		double y;
		
		Scanner keyboard=new Scanner(System.in);
		
		n=keyboard.nextInt();
		x=keyboard.nextInt();
		y=keyboard.nextDouble();
		
		y=y/100;
		
		double clones=n*y-x;
		clones=Math.ceil(clones);
		if (clones<0)
			clones=0;
		System.out.println((int) clones);
		
		
	}
}
		 	  			   	  	 			 		  			