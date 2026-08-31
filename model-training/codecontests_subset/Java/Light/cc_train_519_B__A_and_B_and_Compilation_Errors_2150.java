import java.util.*;
public class NewClass {

    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
     int sum=0,sum1=0;
       for(int i=0;i<t;i++){
       sum+=s.nextInt();               
       }
       for(int i=0;i<t-1;i++){
       sum1+=s.nextInt();               
       }
        System.out.println(sum-sum1);
       sum=0;
        for(int i=0;i<t-2;i++){
       sum+=s.nextInt();               
       }
        System.out.println(sum1-sum);
    }
}
