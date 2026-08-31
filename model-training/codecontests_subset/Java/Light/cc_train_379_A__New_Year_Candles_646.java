import java.util.*;
public class Velas{
	public static void main(String[] args){
		Scanner sc = new Scanner (System.in);
		int a = sc.nextInt(); //numero de velas
		int b = sc.nextInt();
		int velas = 0;
		int resultado = a;
		velas = a;
		while (velas >= b){
		resultado = resultado + velas/b; 
		velas = velas/b + velas%b;
		}
		System.out.println(resultado);
	}
}
		
		
