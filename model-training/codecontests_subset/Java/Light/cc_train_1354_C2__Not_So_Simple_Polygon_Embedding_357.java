import java.util.Scanner;

public class er87c1 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int tt=0;tt<t;tt++) {
			n=scan.nextInt()*2;
			r=1.0/(2.0*Math.sin(Math.toRadians(180.0/n)));
			
			double lo=0, hi=360.0/n;
		    for(int i=0;i<100;i++) {
		        double g1=(lo*2+hi)/3;
		        double g2=(lo+hi*2)/3;
		        
		        if(go(g1)>go(g2)) lo=g1;
		        else hi=g2;
		    }
		    System.out.println(go(lo));
		}
	}
	static int n;
	static double r;
	public static double go(double theta) {
		double minx=Integer.MAX_VALUE, miny=Integer.MAX_VALUE;
		double maxx=Integer.MIN_VALUE, maxy=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			double x=r*Math.cos(Math.toRadians(theta+i*(360.0/n)));
			double y=r*Math.sin(Math.toRadians(theta+i*(360.0/n)));
			
			minx=Math.min(minx,x);
			maxx=Math.max(maxx,x);
			miny=Math.min(miny,y);
			maxy=Math.max(maxy,y);
		}
		return Math.max(maxx-minx,maxy-miny);
	}
}