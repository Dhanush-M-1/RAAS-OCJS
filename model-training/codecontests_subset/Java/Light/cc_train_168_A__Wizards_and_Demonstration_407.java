import java.util.Scanner;


public class WizardDemo {
	public static void main(String[] args)
	{
		Scanner br=new Scanner(System.in);
		double n=br.nextInt(),x=br.nextInt(),y=br.nextInt();
		double need=Math.ceil(y/100*n);
		int m=(int)(need-x);
		System.out.println(Math.max(m,0));
	}
}
