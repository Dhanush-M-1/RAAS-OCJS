import java.util.Scanner;

public class Problematique_ErreurCompilation {

	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		 int n=scanner.nextInt();
		 int a=0,b=0,c=0;
		 int m=n-1,l=n-2;
		 
		while(n--!=0) {
		a=a+scanner.nextInt();}
		
		while(m--!=0) {
		b=b+scanner.nextInt();}
		
		while(l--!=0) {
		c=c+scanner.nextInt();}
		
		System.out.println(a-b);
		System.out.print(b-c);
		 
		}
	
}
