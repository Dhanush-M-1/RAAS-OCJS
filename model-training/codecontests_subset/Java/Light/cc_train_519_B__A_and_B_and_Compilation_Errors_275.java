import java.util.Scanner;


public class compiler2 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        
        long x=in.nextLong();
        
        long sum1=0,sum2=0,sum3=0;
        for(int i=0;i<x;i++){
        sum1+=in.nextLong();
        }
        for(int i=0;i<x-1;i++){
            sum2+=in.nextLong();
        }
        for(int i=0;i<x-2;i++){
            sum3+=in.nextLong();
        }
        System.out.println(sum1-sum2);
        System.out.println(sum2-sum3);
    }

}