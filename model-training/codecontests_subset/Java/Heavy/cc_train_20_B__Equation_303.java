
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int a,b,c;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        double rt =1L*b*b-1L*4*a*c,ans1,ans2;
        double []  res =  new double[5];
            // 1 100000 -100000
        //System.out.println(rt);
        //if(Math.abs(rt-0)>=1e-5)System.out.println(Math.abs(rt-0));
        
        if(a==b&&b==c&&a==0)System.out.println(-1);
        else if(a==0&&b!=0){
            System.out.println("1");
            System.out.printf("%f\n",((double)-c)/b);
        }
        else if(rt>0){
            if(a!=0){
                ans1 = (-b+ Math.sqrt(rt))/(double)(2*a);
                ans2 = (-b- Math.sqrt(rt))/(double)(2*a);
                res[0] = ans1;
                res[1] = ans2;
                Arrays.sort(res,0,2);
                System.out.println(2);
                System.out.printf("%f\n",res[0]);
                System.out.printf("%f\n",res[1]);                
            }
            else {
                System.out.println("1");
                System.out.println(0.000000);
            }
        }
        else if(Math.abs(rt-0)<1e-5){
            if(a!=0){
                System.out.println(1);
                ans1 = (double)(-b)/(2*a);
                System.out.printf("%f\n" , ans1);
            }
            else System.out.println("0");
        }
        else if(rt<0){
            System.out.println("0");
        }
        
//        String a = sc.nextLine();
   //     for(int len = 99;len>=0;len--)
   //       
   //       
   //       
   //       
   //       
   //
   
    }
    
//    
//    {
//        
//    
//    }
}


