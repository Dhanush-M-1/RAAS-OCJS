
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		double n=in.nextInt();
		double x=in.nextInt();
		double y=in.nextInt();
		
		//System.out.println(n+x+y);
		double c=0;
		
		if(x/n>y/100){
			c=0;
		}else {
			c=Math.ceil( y/100*n-x  );
		}
		
		System.out.println((int)c);
	}

}
		 		 				 	 		 		 		 			   	 	