
import java.util.*;
import java.lang.*;
import java.util.regex.*;
import java.math.*;
import java.io.*;

public class Friends_Meeting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		double dist = Math.abs(x-y);
		if(dist % 2 == 0){
			dist = (int)(dist/2);
			System.out.println(sum(dist));
		}else{
			dist = (int)(dist/2);
			System.out.println((int)((dist+1)*(dist+1)));
		}

	}
	
	public static int sum(double x){
		return (int)((x)*(x+1));
	}

}

