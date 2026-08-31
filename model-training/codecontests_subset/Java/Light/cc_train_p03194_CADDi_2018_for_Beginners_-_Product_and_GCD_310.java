import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n=sc.nextLong();
        long p=sc.nextLong();
        if(n==1){
            System.out.println(p);
        }else{
            for(long i=(long)Math.pow(p, 1/n)+1;i>0;i--){
                if(p%Math.pow(i,n)==0){
                    System.out.println(i);
                    return;
                }
            }
        }
    }
 
    
}