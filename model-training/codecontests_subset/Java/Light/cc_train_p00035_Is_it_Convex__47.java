import java.io.*;
import java.util.*;
import java.math.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Main{

	public static double calc_convex(double l1x,double l1y,double l2x,double l2y,double p1x,double p1y,double p2x,double p2y){
		return ((l1x-l2x)*(p1y-l1y)+(l1x-p1x)*(l1y-l2y))*((l1x-l2x)*(p2y-l1y)+(l1x-p2x)*(l1y-l2y));
	}

	public static void check_convec(ArrayList<Double> list){
		double xa,ya,xb,yb,xc,yc,xd,yd,p1,p2;
	
		xa = list.get(0);
		ya = list.get(1);
		xb = list.get(2);
		yb = list.get(3);
		xc = list.get(4);
		yc = list.get(5);
		xd = list.get(6);
		yd = list.get(7);
				
		p1 = calc_convex(xa,ya,xc,yc,xb,yb,xd,yd);
		p2 = calc_convex(xb,yb,xd,yd,xa,ya,xc,yc);

		if(p1 < 0 && p2 < 0) System.out.println("YES");
		else System.out.println("NO");
		
	}
	

	public static void print_convex(ArrayList<Double> list){
		ArrayList <Double> inp = new ArrayList<Double>();
		
		for(int i=0;i<list.size()/8;i++){
			for(int j=0;j<8;j++){
				inp.add(list.get(i*8+j));
			}
			check_convec(inp);
			inp.clear();
		}

	}
		
	public static void main(String args[]) throws IOException{
		String str;
		ArrayList <Double> inp = new ArrayList<Double>();

		Scanner scan = new Scanner(System.in);

		while(scan.hasNext()){
			str = scan.next();
			String [] strAry = new String[str.length()];
			strAry = str.split(",");
			for(int j=0;j<strAry.length;j++){
				Pattern p = Pattern.compile("-?[0-9]*.[0-9]*");
				Matcher m = p.matcher(strAry[j]);
				if(m.find()){
					double x = Double.parseDouble(m.group(0));
					inp.add(x);
				}
			}
		}
		print_convex(inp);
	}
}