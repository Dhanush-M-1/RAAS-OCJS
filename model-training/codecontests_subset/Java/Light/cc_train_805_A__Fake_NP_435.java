import java.util.Scanner;
public class Main {
	public static void main(String[]args){
		Scanner n = new Scanner(System.in);
		int a,b,aux;
		b = n.nextInt();
		a = n.nextInt();
		if(b>a){
			aux = a;
			a = b;
			b = aux;
		}
		if(a==b){
			System.out.println(a);
		}else{
			System.out.println(2);
		}
	}
}

   	 		    		 	  	     		   			