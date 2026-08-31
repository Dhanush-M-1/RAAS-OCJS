//package c;

import java.math.BigDecimal;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long xa = in.nextLong();
		long ya = in.nextLong();
		long xb = in.nextLong();
		long yb = in.nextLong();
		long xc = in.nextLong();
		long yc = in.nextLong();
		BigDecimal dis1 = new BigDecimal(xa-xb).pow(2).add(new BigDecimal(ya-yb).pow(2));
		BigDecimal dis2 = new BigDecimal(xb-xc).pow(2).add(new BigDecimal(yb-yc).pow(2));
		//double distance1 = Math.sqrt(Math.pow((xa-xb),2) + Math.pow((ya-yb), 2));
		//double distance2 = Math.sqrt(Math.pow((xc-xb),2) + Math.pow((yc-yb), 2));
		if(!dis1.equals(dis2)) System.out.println("No");
		else {
			if((xa-xb)*(yb-yc) != (xb-xc)*(ya-yb))
				System.out.println("Yes");
			else System.out.println("No");
		}
		in.close();
	}

}
