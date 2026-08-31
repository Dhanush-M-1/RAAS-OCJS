import java.util.Scanner;


public class Main{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String line = sc.nextLine();
			Scanner scstr = new Scanner(line);
			scstr.useDelimiter(",");
			XPoint a = new XPoint(scstr.nextDouble(), scstr.nextDouble());
			XPoint b = new XPoint(scstr.nextDouble(), scstr.nextDouble());
			XPoint c = new XPoint(scstr.nextDouble(), scstr.nextDouble());
			XPoint d = new XPoint(scstr.nextDouble(), scstr.nextDouble());

			
			XTriangle abc = new XTriangle(a, b, c);
			XTriangle bcd = new XTriangle(b, c, d);
			XTriangle cda = new XTriangle(c, d, a);
			XTriangle dab = new XTriangle(d, a, b);
			
			if(!abc.isInThisTriangle(d) && !bcd.isInThisTriangle(a) && !cda.isInThisTriangle(b) && !dab.isInThisTriangle(c)) System.out.println("YES");
			else System.out.println("NO");
			scstr.close();
		}
		sc.close();
	}
	
}

class XPoint{
	
	private double x;
	private double y;
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public XPoint(double d, double e){
		this.x = d;
		this.y = e;
	}
}

class XLine{
	
	double p;
	double q;
	double r;
	
	/**
	 * ??´???px+qy=r??????????????????
	 * 
	 * @param p
	 * @param q
	 * @param r
	 */
	XLine(double p, double q, double r){
		this.p = p;
		this.q = q;
		this.r = r;
	}
	
	public XLine(XPoint p1, XPoint p2){
	
		if(p1.getX() != p2.getX()) {
			this.p = -(p1.getY()-p2.getY())/(p1.getX()-p2.getX());
			this.q = 1;
			this.r = p1.getX()* this.p +p1.getY();
		}else {
			if(p1.getY() != p2.getY()) {
				this.p = 1;
				this.q = 0;
				this.r = 0;
			}else {
				this.p = 1;
				this.q = 1;
				this.r = 1;
			}
		}
	}
	
	/**
	 * ????????´???????????????2????????????????????´????????????????????????????????????
	 * 
	 * @param x
	 * @param y
	 * @return 2???x, y???????????´???????????°true
	 */
	boolean isTheSameSide(XPoint x, XPoint y){
		double result = (this.calcPX_QY(x.getX(), x.getY()) - this.r)
				* (this.calcPX_QY(y.getX(), y.getY()) - this.r);
		return (result > 0) ? true: false;
	}
	
	/**
	 * ???????????????x, y????????????px+qy????¨?????????????
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	double calcPX_QY(double x, double y){
		return x * p + y * q;
	}
}

class XTriangle{
	
	XPoint p1;
	XPoint p2;
	XPoint p3;
	
	XTriangle(XPoint p1, XPoint p2, XPoint p3){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	XPoint getCenter(){
		return new XPoint((p1.getX() + p2.getX() + p3.getX()) / 3, (p1.getY()
				+ p2.getY() + p3.getY()) / 3);
	}
	
	boolean isInThisTriangle(XPoint p) {
		XLine l12 = new XLine(p1, p2);
		XLine l23 = new XLine(p2, p3);
		XLine l31 = new XLine(p3, p1);
		XPoint center = this.getCenter();
		
		return l12.isTheSameSide(p, center) && l23.isTheSameSide(p, center) && l31.isTheSameSide(p, center);
	}
}