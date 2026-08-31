/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import static jdk.nashorn.internal.objects.Global.Infinity;
import static jdk.nashorn.internal.objects.Global.NaN;

/**
 *
 * @author george
 */
public class main {
 
       
   public static void main (String []  args) 
    {
 Scanner s=new Scanner(System.in);
   double a,b,c;
   double [] ss=new double[2];
   a=s.nextDouble();b=s.nextDouble();c=s.nextDouble();
   if(a!=0&&b!=0){
   ss[0]=((-1*b)-Math.sqrt((b*b)-(4*a*c)))/(2*a);
   ss[1]=((-1*b)+Math.sqrt((b*b)-(4*a*c)))/(2*a);
   Arrays.sort(ss);
   if(ss[1]==0 && ss[0]==0){System.out.print(0);}
   else if(ss[1]==ss[0]){System.out.println(1);System.out.println(ss[0]);}
   else if(ss[1]==Infinity||ss[0]==Infinity){System.out.print(-1);}
   else if(ss[1]==NaN || ss[0]==NaN ||(a==1&&b==1&&c==1)){System.out.print(0);}
   else{System.out.println(2);System.out.println(ss[0]);System.out.println(ss[1]);}
   }
   else if(a==0&&b==0&&c==0){System.out.print(-1);}
   else if(a==0 && b!=0){ 
       if(((-1*c)/b)==Infinity){System.out.print(-1);}
       else { System.out.println(1);System.out.println(((-1*c)/b));}}
   else if(a!=0 &&b==0&& c==0){System.out.println(1);System.out.println(0);}
   else {System.out.print(0);}
    }
}
    


