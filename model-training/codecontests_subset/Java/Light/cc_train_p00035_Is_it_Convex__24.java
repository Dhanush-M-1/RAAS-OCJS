import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args){
	BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
	try{
	    String st;
	    double xa, ya, xb, yb, xc, yc, xd, yd, S, Sa, Sb, Sc, Sd;
	    while((st = sc.readLine())!=null){
		String[] c = st.split(",");
		xa = Double.valueOf(c[0]);
		ya = Double.valueOf(c[1]);
		xb = Double.valueOf(c[2])-xa;
		yb = Double.valueOf(c[3])-ya;
		xc = Double.valueOf(c[4])-xa;
		yc = Double.valueOf(c[5])-ya;
		xd = Double.valueOf(c[6])-xa;
		yd = Double.valueOf(c[7])-ya;
		xa = 0.0;
		ya = 0.0;
		S = Math.abs(xb*yc+xc*yd-yb*xc-yc*xd);
		Sa = Math.abs(xb*yc+xc*yd+xd*yb-yb*xc-yc*xd-yd*xb);
		Sb = Math.abs(xc*yd-yc*xd);
		Sc = Math.abs(xb*yd-yb*xd);
		Sd = Math.abs(xb*yc-yb*xc);
		if(S>Sa && S>Sb && S>Sc&& S>Sd)
		    System.out.println("YES");
		else
		    System.out.println("NO");
	    }
	}catch (Exception e){
	    System.out.println("Error");
	}
    }
}