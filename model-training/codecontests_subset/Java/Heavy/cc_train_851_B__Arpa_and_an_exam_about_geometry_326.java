import java.util.*;
import java.io.*;
import java.lang.*;
public class Solution{
    static long calcDist(long a,long b,long c,long d){
        return ((c-a)*(c-a)+(d-b)*(d-b));
    }
    public static void main(String[] args){
        
    
    Scanner in = new Scanner(System.in); 
    long ax = in.nextLong();
    long ay = in.nextLong();
    long bx = in.nextLong();
    long by = in.nextLong();
    long cx = in.nextLong();
    long cy = in.nextLong();
    
    long distab = calcDist(ax,ay,bx,by);
    long distbc = calcDist(bx,by,cx,cy);
    long distac = calcDist(ax,ay,cx,cy);
    // float slopeab = (by-ay)/(bx-ax);
    // float slopebc = (cy-by)/(cx-bx);
    //determinant----> |A|=0
    // |ax ay 1|
    // |bx by 1|
    // |cx cy 1|
    if(ax*(by-cy)-ay*(bx-cx)+bx*cy-cx*by==0){
        System.out.println("No");
    }
    else if(distab!=distbc){System.out.println("No");}
     
    // else if((by-ay)*(cx-bx)==(cy-by)*(bx-ax)){
    //     System.out.println("No");
    // }
    
    else System.out.println("Yes");
    
    }
}