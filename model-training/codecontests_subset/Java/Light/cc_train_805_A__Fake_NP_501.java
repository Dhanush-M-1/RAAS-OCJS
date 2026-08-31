import java.util.*;
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a == b && a % 2 == 1){
		    System.out.println(a);
		    return;
		}
		System.out.println("2");
	}
}