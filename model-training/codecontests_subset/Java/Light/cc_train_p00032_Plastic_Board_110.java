import java.io.IOException;
import java.util.Scanner;


public class Main{
	public static void main(String args[]) throws IOException{
		Scanner bf = new Scanner(System.in);
		int tyou = 0;
		int hishi = 0;
		while(bf.hasNext()){
			String tmp = bf.nextLine();
			String[] str = tmp.split(",");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int c = Integer.parseInt(str[2]);
			if(c >= a+b) continue;
			if(a == b) hishi++;
			else if(a*a+b*b==c*c) tyou++;
		}
		System.out.println(tyou);
		System.out.println(hishi);
	}
}