

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class apples {

	public static void main(String[] args) {
		Scanner zizo = new Scanner(System.in);
		int c1=zizo.nextInt();
		int c2=zizo.nextInt();
		int c3=zizo.nextInt();
		int c4=zizo.nextInt();
		int c5=zizo.nextInt();
		int sum=c1+c2+c3+c4+c5;
		if(sum%5==0 && sum!=0)System.out.println(sum/5);
		
		else System.out.println(-1);
	}
}