import java.util.Scanner;


public class WizardsandDemonstration {

	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		double i= 0;
		double value = ((x+i)/n)*100;
		int temp = (int)value;
		while(y>temp){
			i= i+1;
			value = ((x+i)/n)*100;	
			temp = (int)value;
	
		}
		int output = (int)i;
		System.out.println(output);

	}

}