import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
public class Graph {
    
    public static void main(String[]args)throws IOException{
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st=new StringTokenizer(br.readLine()," ");
       double A=Double.parseDouble(st.nextToken());
       double B=Double.parseDouble(st.nextToken());
       double C=Double.parseDouble(st.nextToken());
       double D=Math.pow(B,2)-(4*A*C);
       if(A!=0.0){
           if(D>0){
               System.out.println("2");
               double r1=(-B+Math.sqrt(D))/(2*A);
               double r2=(-B-Math.sqrt(D))/(2*A);
               System.out.printf("%f\n%f",Math.min(r1,r2),Math.max(r1,r2));
           }
           if(D==0.0){
               System.out.println("1");
               double r1=-B/(2*A);
               System.out.printf("%f",r1);
           }
           if(D<0.0){
               System.out.print("0");
           }
       }
       if(A==0.00 && B!=0.0){
           System.out.println("1");
           System.out.printf("%f",(-C)/B);
       }
       if(A==0.00 && B==0.0 && C==0.00){
           System.out.print("-1");
       }
       if(A==0.00 && B==0.0 && C!=0.00){
           System.out.print("0");
       }
       
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
