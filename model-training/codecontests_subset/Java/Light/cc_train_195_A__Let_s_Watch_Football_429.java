import java.util.Scanner;


public class nopa {

	
	public static void main(String[] args) {
		Scanner sc=  new Scanner (System.in);
     int a =sc.nextInt();
     int b =sc.nextInt();
     int c =sc.nextInt();
     int t=c*a/b;
     if(c*a%b!=0){
    	t++; 
     }
     System.out.println(t -c );
     
     
	}

}
