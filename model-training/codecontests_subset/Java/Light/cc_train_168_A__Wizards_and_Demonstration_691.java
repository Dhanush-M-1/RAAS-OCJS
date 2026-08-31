

import java.util.Scanner;

/**
 *
 * @author takhi
 */
public class wizards_168A {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        double n=sc.nextInt();
        double x=sc.nextInt();
        double y=sc.nextInt();
        double per=Math.ceil(y*n/100);
        //System.out.println(per);
        //int z=(int)per;
        //System.out.println(z);
        if(per==0||per<x){
            System.out.println(0);
        }else{
        double sum=Math.abs(per-x);
        System.out.println((int)sum);
        }
    }
    
}
