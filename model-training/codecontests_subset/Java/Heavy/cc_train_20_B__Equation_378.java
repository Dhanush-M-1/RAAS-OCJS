/***************20B - Equation***************/
//author - @Divyesh Chhabra

import java.util.*;
import java.lang.*;
import java.math.*;

public class Main{
	public static void main(String[] arg){
		Scanner input = new Scanner(System.in);
		double a=input.nextDouble(),b=input.nextDouble(),c=input.nextDouble();
		
		if(a==0){
		    if(b==0 && c==0){
		        System.out.println(-1);
		    }else if(b==0){
		        System.out.println(0);
		    }else{
		        System.out.println(1);
		        System.out.format("%.5f",(-c)/b);
		    }
		}else if(b*b - 4*a*c < 0){
		    System.out.println(0);
		}else if(b*b - 4*a*c == 0){
		        System.out.println(1);
		        System.out.format("%.5f",(-b)/(2*a));
		}else{
		    System.out.println(2);
		    
		    double x = ((-b-Math.sqrt(b*b - 4*a*c))/(2*a)),y=((-b+Math.sqrt(b*b - 4*a*c))/(2*a));
	        double temp;
	        if(y>x){
	            temp = x;
	            x = y;
	            y = temp;
	        }
		    System.out.format("%.5f\n",y);
		    System.out.format("%.5f",x);
		}
	}
}