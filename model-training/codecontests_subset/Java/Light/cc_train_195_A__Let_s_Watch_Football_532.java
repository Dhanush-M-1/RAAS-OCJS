import java.util.Scanner;

public class A_195_Lets_Watch_Football {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		double a=input.nextDouble(),b=input.nextDouble(),c=input.nextDouble();
		double tmp=(c*a-b*c)/b;
		//System.out.println("tmp=="+tmp);
		int result=(int) Math.ceil(tmp);
		System.out.println(result);
	}
}
