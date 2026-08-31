import java.util.*;
import java.io.*;

public class Main{
	
	public void run() throws Exception{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		
		for(int i=0;;i++){
			double a = 1.*(x + i)/n;
			a*=100;
			if (a >= y){
				System.out.println(i);
				return;
			}
		}
	}
	
	public static void main(String args[]) throws Exception{
		new Main().run();
	}
}
