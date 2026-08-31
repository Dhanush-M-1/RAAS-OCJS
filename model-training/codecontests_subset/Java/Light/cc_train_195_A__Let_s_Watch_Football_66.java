import java.util.Scanner;


public class ppp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new	Scanner (System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int z;
	    if(a==b){z=0;}
	 z=(c*a)/b;
	 if((c*a)%b!=0){
		 z++;
	 }
		System.out.print(z-c);
		
		
	}

}
