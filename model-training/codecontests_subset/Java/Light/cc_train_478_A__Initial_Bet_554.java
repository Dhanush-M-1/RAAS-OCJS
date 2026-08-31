import java.util.*;
public class InitialBet {
    public static void main (String []args){
        int sum=0;
        Scanner sc=new Scanner (System.in);
        for (int i=0;i<5;i++){
            sum+=sc.nextInt();            
        }
        System.out.println((sum%5==0 && sum!=0)? sum/5 :"-1");
    } 
}
