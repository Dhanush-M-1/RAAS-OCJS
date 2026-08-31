import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Main{ 
    
    public static void main(String[] args)throws IOException{
	try{
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	String line;
	/*
	  y=y2-y1/x2-x1  (x-x1)+y1
	  y(x2-x1)=(y2-y1)(x-x1)+y1(x2-x1)
	  (x2-x1)(y-y1)=(y2-y1)(x-x1)
	*/
	while((line=br.readLine())!=null){
	    StringTokenizer st=new StringTokenizer(line,",");
	    double[] x=new double[4];
	    double[] y=new double[4];
	    for(int i=0;i<4;i++){
		x[i]=Double.parseDouble(st.nextToken());
		y[i]=Double.parseDouble(st.nextToken());
	    }
	    f(x,y);
	}
	}catch(java.lang.NumberFormatException e){
	    System.out.println(e);
	}
    }

    static void f(double[] x,double[] y){
	if(	(((x[2]-x[0])*(y[1]-y[0])-(y[2]-y[0])*(x[1]-x[0]))*((x[2] -x[0])*(y[3]-y[0])-(y[2]-y[0])*(x[3]-x[0])))<0){
	    if((((x[3]-x[1])*(y[0]-y[1])-(y[3]-y[1])*(x[0]-x[1]))*((x[3]-x[1])*(y[2]-y[1])-(y[3]-y[1])*(x[2]-x[1])))<0){
		System.out.println("YES");
	    }
	    else System.out.println("NO");
	}
	else System.out.println("NO");
    }
}