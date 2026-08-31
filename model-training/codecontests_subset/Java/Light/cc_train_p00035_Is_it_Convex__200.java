

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String args[]){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String line;
            while((line=br.readLine())!=null){  if(line.equals(""))break;
                String[] splited = line.split(",");
                double xa=Double.parseDouble(splited[0]),ya=Double.parseDouble(splited[1]);
                double xb=Double.parseDouble(splited[2]),yb=Double.parseDouble(splited[3]);
                double xc=Double.parseDouble(splited[4]),yc=Double.parseDouble(splited[5]);
                double xd=Double.parseDouble(splited[6]),yd=Double.parseDouble(splited[7]);
                gra=(yc-ya)/(xc-xa);y0=ya;x0=xa;
                boolean check1;
                check1=linemaker(xb,yb)*linemaker(xd,yd)<0;
      if(!check1){System.out.println("NO");continue;}
      gra=(yd-yb)/(xd-xb);y0=yb;x0=xb;
                boolean check2=linemaker(xa,ya)*linemaker(xc,yc)<0;
                if(check2)System.out.println("YES");else System.out.println("NO");
                
            }         
        }catch(Exception e){e.printStackTrace();}        
    }
    static double gra=0,y0=0,x0=0;
    static double linemaker(double x1, double y1){
        return y1-y0-(gra*(x1-x0));
    }
}