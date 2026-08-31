import java.util.*;
import java.io.*;
public class A {
	
	public void run(){
		Scanner scan = null;
		try {
//			scan = new Scanner(new File("Untitled 1"));
			scan = new Scanner(System.in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		double n = scan.nextDouble();
		double x = scan.nextDouble();
		double y = scan.nextDouble();
		double asd = Math.ceil(n*y/100);
		if(asd>x){
			System.out.println((int)(asd-x));
		}
		else System.out.println(0);
		
	}
	public static void main(String[] args) {
		new A().run();
	}

}
