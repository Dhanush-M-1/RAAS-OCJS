import java.io.*;
import java.util.*;
import java.lang.*;
public class shark4{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	double x = sc.nextDouble();
	double y = sc.nextDouble();
	double z = sc.nextDouble();

	double x_y;
	double x_z;
	double y_z;
	double y_x;
	double z_x;
	double z_y;
	double xy;
	double yz;
	double xz;

	double logx = Math.log(x);
	double logy = Math.log(y);
	double logz = Math.log(z);
	double loglogx = Math.log(logx);
	double loglogy = Math.log(logy);
	double loglogz = Math.log(logz);

	if(!(x>1 && y>1 && z>1)){
	    x_y = (Math.pow(x,y))*logz;
	    x_z = (Math.pow(x,z))*logy;
	    y_z = (Math.pow(y,z))*logx;
	    y_x = (Math.pow(y,x))*logz;
	    z_x = (Math.pow(z,x))*logy;
	    z_y = (Math.pow(z,y))*logx;
	    xy = x*y*logz;
	    yz = y*z*logx;
	    xz = x*z*logy;
	}
	else{
	    x_y = y*logx+loglogz;
	    x_z = z*logx+loglogy;
	    y_z = z*logy+loglogx;
	    y_x = x*logy+loglogz;
	    z_x = x*logz+loglogy;
	    z_y = y*logz+loglogx;	    
	    xy = logx+logy+loglogz;
	    yz = logy+logz+loglogx;
	    xz = logx+logz+loglogy;
	}
	
	int i = 0;
	int r1 = 0;
	int r2 = 0;
	int r3 = 0;
	double d1 = 0;
	double d2 = 0;
	double d3 = 0;
	
	//comparing first four
	if(y_z>=z_y){
	    if(y_z>=yz){
		r1 = 1;
		d1 = y_z;
	    }
	    else{
		r1 = 3;
		d1 = yz;
	    }
	}
	else{
	    if(z_y>=yz){
		r1 = 2;
		d1 = z_y;
	    }
	    else{
		r1 = 3;
		d1 = yz;
	    }
	}
	//comparing next four
	if(x_z>=z_x){
	    if(x_z>=xz){
		r2 = 5;
		d2 = x_z;
	    }
	    else{
		r2 = 7;
		d2 = xz;
	    }
	}
	else{
	    if(z_x>=xz){
		r2 = 6;
		d2 = z_x;
	    }
	    else{
		r2 = 7;
		d2 = xz;
	    }
	}
	//comparing last four
	if(x_y>=y_x){
	    if(x_y>=xy){
		r3 = 9;
		d3 = x_y;
	    }
	    else{
		r3 = 11;
		d3 = xy;
	    }
	}
	else{
	    if(y_x>=xy){
		r3 = 10;
		d3 = y_x;
	    }
	    else{
		r3 = 11;
		d3 = xy;
	    }
	}

	//comparing winners from the three
	if(d1>=d2){
	    if(d1>=d3){
		//do nothing output r1
	    }
	    else{
		r1 = r3;
	    }
	}
	else{
	    if(d2>=d3){
		r1 = r2;
	    }
	    else{
		r1 = r3;
	    }
	}

	switch(r1){
	case 1:
	    System.out.println("x^y^z");
	    break;
	case 2:
	    System.out.println("x^z^y");
	    break;
	case 3:
	    System.out.println("(x^y)^z");
	    break;
	case 5:
	    System.out.println("y^x^z");
	    break;
	case 6:
	    System.out.println("y^z^x");
	    break;
	case 7:
	    System.out.println("(y^x)^z");
	    break;
	case 9:
	    System.out.println("z^x^y");
	    break;
	case 10:
	    System.out.println("z^y^x");
	    break;
	case 11:
	    System.out.println("(z^x)^y");
	    break;
	default:
	    System.out.println("error");
	}
    }
}
