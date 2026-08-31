import java.util.*;
public class MyClass {
   public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(q-->0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int d = sc.nextInt();
            int x = d;
            if(d>r){
                x=d;
            }
            else if(d>=l && d<= r){
                if(r/d>1){
                    x = d*(r/d)+d;
                }
                else{
                    x = 2*d;
                }
            }
            else{
                x=d;
                /*if(l/d>1){
                    x = d;
                }
                
                else{
                    if(r/d>1){
                        x = d*(r/d)+d;
                    }
                    else{
                        x = d*2;
                    }
                }*/
            }
            System.out.println(x);
        }
    }
    
}
