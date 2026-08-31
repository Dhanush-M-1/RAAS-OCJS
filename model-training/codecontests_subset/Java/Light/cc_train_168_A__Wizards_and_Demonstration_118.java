import java.util.Scanner;

public class A_Wizards_And_Demonstration {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		double n=input.nextDouble();
		double x=input.nextDouble();
		double y=input.nextDouble();
		if(x/n*100>y)System.out.println(0);
		else{
			int people=(int) Math.ceil(n*y/100-x);
			System.out.println(people);
		}
	}
}
