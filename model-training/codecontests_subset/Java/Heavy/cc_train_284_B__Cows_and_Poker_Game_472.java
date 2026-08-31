import java.util.Scanner;


public class ejercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc = new Scanner (System.in);
    int n =sc.nextInt ();
	String vacas = sc.next();
	int sumaA = 0;
	int sumaB = 0;
	int sumaC = 0;
	int pose = 0;
    for  ( int i = 0; i < n ; i++){
    	if (vacas.substring( i,i+1).equals("A")){
   sumaA = sumaA+1;
    	}
    	if ( vacas.substring(i,i+1).equals("I")){
    		sumaB= sumaB+1;
    	}
    	
    }
	if (sumaB == 1){
		System.out.println(sumaB);
	}
	if (sumaB==0){
		System.out.println(sumaA);
	}
	else if (sumaB >1){
		System.out.println("0");
	}
	
	}
}
