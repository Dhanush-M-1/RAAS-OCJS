import java.util.*;
import java.awt.geom.*;
import java.awt.geom.Line2D.Double;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
            String buffer=  in.nextLine();
            Scanner sc = new Scanner(buffer.replace(',', ' '));

			double xa = sc.nextDouble();
			double ya = sc.nextDouble();
			double xb = sc.nextDouble();
			double yb = sc.nextDouble();
			double xc = sc.nextDouble();
			double yc = sc.nextDouble();
			double xd = sc.nextDouble();
			double yd = sc.nextDouble();
			
			Line2D.Double s = new Line2D.Double();
			Line2D.Double t = new Line2D.Double();
			int ans = 1;
			
			while(true){
			
				ans = 1;
				s.setLine(xa, ya, xd, yd);
				t.setLine(xb, yb, xc, yc);
				if(s.intersectsLine(t)==true)ans*=0;
				s.setLine(xb, yb, xd, yd);
				t.setLine(xa, ya, xc, yc);
				if(s.intersectsLine(t)==true)ans*=0;
				s.setLine(xc, yc, xd, yd);
				t.setLine(xa, ya, xb, yb);
				if(s.intersectsLine(t)==true)ans*=0;
				if(ans==1){
					System.out.println("NO");
					break;
				}
				
				ans = 1;
				s.setLine(xa, ya, xc, yc);
				t.setLine(xb, yb, xd, yd);
				if(s.intersectsLine(t)==true)ans*=0;
				s.setLine(xb, yb, xc, yc);
				t.setLine(xa, ya, xd, yd);
				if(s.intersectsLine(t)==true)ans*=0;
				s.setLine(xd, yd, xc, yc);
				t.setLine(xa, ya, xb, yb);
				if(s.intersectsLine(t)==true)ans*=0;
				if(ans==1){
					System.out.println("NO");
					break;
				}
			
				ans = 1;
				s.setLine(xa, ya, xb, yb);
				t.setLine(xc, yc, xd, yd);
				if(s.intersectsLine(t)==true)ans*=0;
				s.setLine(xc, yc, xb, yb);
				t.setLine(xa, ya, xd, yd);
				if(s.intersectsLine(t)==true)ans*=0;
				s.setLine(xd, yd, xb, yb);
				t.setLine(xa, ya, xc, yc);
				if(s.intersectsLine(t)==true)ans*=0;
				if(ans==1){
					System.out.println("NO");
					break;
				}
				
				ans = 1;
				s.setLine(xb, yb, xa, ya);
				t.setLine(xc, yc, xd, yd);
				if(s.intersectsLine(t)==true)ans*=0;
				s.setLine(xc, yc, xa, ya);
				t.setLine(xb, yb, xd, yd);
				if(s.intersectsLine(t)==true)ans*=0;
				s.setLine(xd, yd, xa, ya);
				t.setLine(xb, yb, xc, yc);
				if(s.intersectsLine(t)==true)ans*=0;
				if(ans==1){
					System.out.println("NO");
					break;
				}
				
				System.out.println("YES");
				break;
			}
		}
	}	
}