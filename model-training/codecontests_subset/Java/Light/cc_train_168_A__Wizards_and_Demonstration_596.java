import java.util.*;
public class WizardsandDemonstration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int x=sc.nextInt();
		int y=sc.nextInt();
		double z=(double)y*n/100;
		if(z-(int)z==0&&(int)z-x>=0)
			System.out.println((int)z-x);
		else if(z-(int)z!=0&&(int)z-x>=0)
			System.out.println((int)z-x+1);
		else
			System.out.println(0);
	}
}
