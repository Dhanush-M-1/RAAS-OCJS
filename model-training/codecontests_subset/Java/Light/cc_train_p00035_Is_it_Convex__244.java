import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
public class Main {	
	Scanner in = new Scanner(System.in);
	public static void main(String[] args){
		new Main();
	}

	public Main(){		
		while(in.hasNext())new AOJ0035();
	}
	
	class AOJ0035{
		public AOJ0035() {
			Point2D point[] = new Point2D[4];
			String input[] = in.nextLine().split(",");
			for(int i=0;i<4;i++)point[i]=new Point2D.Double(Double.parseDouble(input[i*2]),Double.parseDouble(input[i*2+1]));
			boolean sw=true;
			int memo = right_left(point[0],point[2],point[1]);
			for(int i=0;i<4;i++)if(right_left(point[i],point[(i+2)%4],point[(i+1)%4])!=memo)sw=false;
			if(sw)System.out.println("YES");
			else System.out.println("NO");
		}
		//外積
		double cross(Point2D p1,Point2D p2){
			return p1.getX()*p2.getY()-p1.getY()*p2.getX();
		}
		
		int right_left(Point2D a,Point2D b,Point2D target){ //a-bの直線はtargetの右か左か
			Point2D q = new Point2D.Double(b.getX()-a.getX(),b.getY()-a.getY());
			Point2D r = new Point2D.Double(target.getX()-a.getX(),target.getY()-a.getY());
			if(cross(q, r)>0)return -1;//左側
			else if(cross(q,r)<0)return 1;//右側
			else return 0;//重なっている
		}
		
	}
		
}