import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
	Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		new CGL_3B().doIt();
	}

	class CGL_3B{

		double cross(Point2D p1,Point2D p2){
			return p1.getX()*p2.getY()-p1.getY()*p2.getX();
		}
		int CCW(Point2D a,Point2D b,Point2D target){ //a-bの直線はtargetの右か左か
			Point2D q = new Point2D.Double(b.getX()-a.getX(),b.getY()-a.getY());
			Point2D r = new Point2D.Double(target.getX()-a.getX(),target.getY()-a.getY());
			if(cross(q, r)>0)return -1;//左側
			else if(cross(q,r)<0)return 1;//右側
			else return 0;//重なっている
		}
		
		void doIt(){
			int n = in.nextInt();
			Point2D[] p = new Point2D[n];
			for(int i=0;i<n;i++)p[i] = new Point2D.Double(in.nextDouble(), in.nextDouble());
			boolean sw = true;
			for(int i=0;i<n;i++){
//				System.out.println(CCW(p[i%n],p[(i+1)%n],p[(i+2)%n]));
				if(CCW(p[i%n],p[(i+1)%n],p[(i+2)%n])!=CCW(p[(i+1)%n],p[(i+2)%n],p[(i+3)%n])
						&&CCW(p[i%n],p[(i+1)%n],p[(i+2)%n])!=0&&CCW(p[(i+1)%n],p[(i+2)%n],p[(i+3)%n])!=0){
					sw=false;
					break;
				}
			}
			if(sw)System.out.println("1");
			else System.out.println("0");
		}
		
	}


}