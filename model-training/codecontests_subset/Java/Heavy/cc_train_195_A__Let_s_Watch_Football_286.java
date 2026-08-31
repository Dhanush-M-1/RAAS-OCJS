import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.out;

// AOJ4
public class Main {
	final Scanner sc=new Scanner(System.in);
	final int[] vx={0,1,0,-1}, vy={-1,0,1,0};
	final int[] vvx={0,1,0,-1,-1,1,1,-1}, vvy={-1,0,1,0,-1,-1,1,1};
	final int INF=1<<24;
	static class Point{
		int x, y;
		Point(int x, int y){	this.x=x;	this.y=y;}
		Point(){	this.x=0; this.y=0;}
		@Override public String toString(){	return "("+this.x+","+this.y+")";}
		static boolean ok(int x,int y,int X,int Y,int min){	return (min<=x&&x<X)&&(min<=y&&y<Y);}
		static boolean ok(int x,int y,int X,int Y){	return ok(x,y,X,Y,0);}
	}
	public static void main(String[] args) {
		//long s=System.currentTimeMillis();
		new Main().A();
		//out.println((System.currentTimeMillis()-s)+"msec");
	}
	
	void A(){
		int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
		double d=(((double)a*c)-((double)b*c))/(double)b;
		out.println((int)ceil(d));
	}
}