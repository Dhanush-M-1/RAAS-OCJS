import java.util.*;
import java.io.*;
public class b{
	static long dist(long x1,long y1,long x2,long y2){
		return Math.abs(sq(x1-x2))+Math.abs(sq(y1-y2));
	}
	static long  sq(long x){
		return x*x;
	}
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		long ax=sc.nextLong();
		long ay=sc.nextLong();
		long bx=sc.nextLong();
		long by=sc.nextLong();
		long cx=sc.nextLong();
		long cy=sc.nextLong();

		if(dist(ax,ay,bx,by)==dist(bx,by,cx,cy)){//check if distance is same
			if(((by-ay)*(cx-bx))==((cy-by)*(bx-ax))){//if on same line
				System.out.println("No");
			}
			else{
				System.out.println("Yes");
			}
		}
		else{
			System.out.println("No");
		}
	}
}
