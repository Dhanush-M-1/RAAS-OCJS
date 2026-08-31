import java.util.*;
public class WizardsMeeting{
	public static void main (String args[]){
		Scanner scnr = new Scanner(System.in);
		double n=scnr.nextDouble();
		double x=scnr.nextDouble();
		double y=scnr.nextDouble();
		int a=0;
		while ((x+a)/n<y/100) {a++;}
		System.out.print((int)a);
	}
}
