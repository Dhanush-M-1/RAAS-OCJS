/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package geomexam;

import java.util.*;
import java.io.*;

public class Geomexam {
    
    static long dist(long ax, long ay, long bx , long by){
        return (ax-bx) * (ax-bx) + (ay-by) * (ay-by);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long Ax = Integer.parseInt(st.nextToken());
        long Ay = Integer.parseInt(st.nextToken());
        long Bx = Integer.parseInt(st.nextToken());
        long By = Integer.parseInt(st.nextToken());
        long Cx = Integer.parseInt(st.nextToken());
        long Cy = Integer.parseInt(st.nextToken());
        
        long distA = dist(Bx,By,Cx,Cy);
        long distC = dist(Ax,Ay,Bx,By);
        
        //System.out.println(distC + " " + distA);
        
        
        
       
        
      //  double angleC = Math.abs(Math.toDegrees(Math.acos((top+0.000001)/(bottom+0.000001))));
        
       // top = Math.pow(distC, 2) + Math.pow(distB, 2) - Math.pow(distA, 2);
      //  bottom = 2 * distC * distB;
//        System.out.println(bottom);
//        System.out.println(top/bottom);
//        System.out.println(top+0.000001/bottom+0.000001);
      //  double angleA = Math.abs(Math.toDegrees(Math.acos((top+0.000001)/(bottom+0.000001))));
        ///System.out.println(angleC + " " + angleA);
//        System.out.println(distA + " " + distB + " " + distC);
        
//        double angle = (Math.toDegrees(Math.atan2(By, Bx)) + 360.0)%360.0 - (Math.toDegrees(Math.atan2(Ay, Ax)) + 360.0)%360.0;
//        angle = (angle + 360)%360;
//        //System.out.println(angle);
//        double angle2 = (Math.toDegrees(Math.atan2(Cy, Cx)) + 360.0)%360.0 - (Math.toDegrees(Math.atan2(By, Bx)) + 360.0)%360.0;
//        angle2 = (angle2 + 360)%360;
        //System.out.println(angle2);
        if(((double)(By - Ay))/((double)(Bx-Ax)) == ((double)(Cy - By))/((double)(Cx-Bx))){
            System.out.println("No");
        }
        else if(distA == distC){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        

    }
    
    
}
