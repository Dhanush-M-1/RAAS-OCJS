import java.util.Scanner;
import java.util.*;
public class WizardsandDemonstration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc= new Scanner(System.in);
		double n = sc.nextInt();
		double y =sc.nextInt();
		double z= sc.nextInt();
		double puppets=(n*z)/100 ;
				double fin=Math.ceil(puppets-y);
		if (fin>0 && fin <1){
			System.out.println((int)1);
		}
		else if (fin<0){
			System.out.println((int) 0);			
		}
		else{
			System.out.println((int)fin);
		}
		

	}

}
