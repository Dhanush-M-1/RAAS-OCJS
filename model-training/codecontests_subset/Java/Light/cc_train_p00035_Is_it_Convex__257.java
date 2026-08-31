import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.*;

public class Main {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		new Main();	
	}

	public Main() {
		while(sc.hasNext()){
			new aoj0035().doIt();
		}
	}
	class aoj0035 {
		//?????????????????????EPS,Point2D????????????
		final double EPS = 1.0e-08;
		//????????¨?????????Arrays.sort(data, com);
		Comparator< Point2D > com = new Comparator< Point2D >() {
			public int compare(Point2D o1, Point2D o2) {
				if(o1.getX() < o2.getX()) return -1;
				else if(o1.getX() > o2.getX()) return 1;
				else if(o1.getY() < o2.getY()) return -1;
				else if(o1.getY() > o2.getY()) return 1;
				else return 0;
			} 
		};
		
		int ccw (Line2D l,Point2D p){
			return l.relativeCCW(p);
		}
		
		void doIt() {
			int ans = 0;
			String str[] = sc.nextLine().split(",");
			Point2D.Double a[] = new Point2D.Double [4];
			for(int i = 0;i < 4;i++){
				a[i] = new Point2D.Double(Double.parseDouble(str[i*2]),Double.parseDouble(str[i*2+1]));
			}
			Line2D.Double b[] = new Line2D.Double [4];
			for(int i = 0;i < 4;i++){
				b[i] = new Line2D.Double(a[i].getX(),a[i].getY(), a[(i+1)%4].getX(), a[(i+1)%4].getY());
				ans = ans + ccw(b[i],a[(i+2)%4]);
			}
			if(ans == 4 || ans == -4)System.out.println("YES");
			else System.out.println("NO");
		}
	}
}