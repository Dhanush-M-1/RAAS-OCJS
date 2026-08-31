import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String[] sarr = sc.next().split(",");
			double[] x = new double[8];
			for(int i=0;i<8;i++) {
				x[i] = Double.valueOf(sarr[i]);
			}
			Vector2[] r = new Vector2[4];
			for(int i=0;i<4;i++) {
				r[i] = new Vector2(x[i*2],x[i*2+1]);
			}
			int sign = 0;
			boolean flag = true;
			for(int i=0;i<4;i++) {
				Vector2 r2 = r[(i+2)%4];
				Vector2 r1 = r[(i+1)%4];
				Vector2 r0 = r[i];
				double cross = r2.subtract(r1).cross(r1.subtract(r0));
				if (sign * cross < 0) {
					flag = false;
					break;
				}else if(sign == 0){
					sign = cross < 0 ? -1 : cross > 0 ? 1 : 0;
				}
			}
			System.out.println(flag ? "YES" : "NO");
		}
	}

}
class Vector2 {
	public double x;
	public double y;
	public Vector2(double x,double y) {
		this.x = x;
		this.y = y;
	}
	public double dot(Vector2 v) {
		return this.x*v.x+this.y*v.y;
	}
	public double cross(Vector2 v) {
		return this.x*v.y-this.y*v.x;
	}
	public double norm() {
		return Math.sqrt(this.x*this.x+this.y*this.y);
	}
	public Vector2 normalize() {
		return divide(norm());
	}
	public Vector2 add(Vector2 v) {
		return new Vector2(x+v.x,y+v.y);
	}
	public Vector2 subtract(Vector2 v) {
		return new Vector2(x-v.x,y-v.y);
	}
	public Vector2 multiply(double k) {
		return new Vector2(x*k,y*k);
	}
	public Vector2 divide(double k) {
		return new Vector2(x/k,y/k);
	}
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
}