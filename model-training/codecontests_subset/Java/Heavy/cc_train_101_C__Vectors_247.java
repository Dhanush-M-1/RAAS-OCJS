//package DIV_79;

import java.util.Scanner;

public class E {
private static long x1;
private static long y1;
private static long x2;
private static long y2;
private static long x3;
private static long y3;

public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	  x1=sc.nextLong();
	  y1=sc.nextLong();
	  x2=sc.nextLong();
	  y2=sc.nextLong();
	  x3=sc.nextLong();
	  y3=sc.nextLong();
	  if(check(x1,y1)||check(-x1,-y1) || check(-y1,x1) || check(y1,-x1) )
			System.out.println("YES");else System.out.println("NO");
	
}
public static boolean check(long x,long y){
	long xx = x3*x3+y3*y3, tx= x2+x,ty = y2+y;
	if(xx==0)return x==x2 && y==y2;
	long ret1= tx*x3+ty*y3, ret2 = tx*y3-ty*x3;
	if(ret1%xx !=0 || ret2%xx !=0 )return false;
	return true;
}
}
