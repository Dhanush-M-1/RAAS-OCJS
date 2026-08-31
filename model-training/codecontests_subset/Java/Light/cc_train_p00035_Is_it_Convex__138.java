import java.util.*;
 
 
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] s = sc.nextLine().split(",");
            double[] a = new double[8];
            for(int i=0;i < 8;i++){
                a[i] = Double.parseDouble(s[i]);
            }
             
            if(isCross(a[0],a[1],a[4],a[5],a[2],a[3],a[6],a[7]) > 0.0 || isCross(a[2],a[3],a[6],a[7],a[0],a[1],a[4],a[5]) > 0.0){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
     
    private static double isCross(double p1_x,double p1_y,double p2_x,double p2_y,double p3_x,double p3_y,double p4_x,double p4_y){  
        return ( (p1_x-p2_x)*(p3_y-p1_y) + (p1_y-p2_y)*(p1_x-p3_x)) * ((p1_x-p2_x)*(p4_y-p1_y) + (p1_y-p2_y)*(p1_x-p4_x));  
    }
}