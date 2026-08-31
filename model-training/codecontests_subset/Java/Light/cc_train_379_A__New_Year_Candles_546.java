//package newYear2014;
import java.util.Scanner;
public class A {
	public static void main(String[] args) {
		Scanner leer=new Scanner(System.in);
		int a =leer.nextInt();
		int b=leer.nextInt();
		int aux=a;
		int aux2=0;
		while(a/b>0){
			int a2=a;
			a=a/b;
			aux2=a2-(a*b);
			aux+=a;
			a+=aux2;
		}
		System.out.println(aux);
	}
}
