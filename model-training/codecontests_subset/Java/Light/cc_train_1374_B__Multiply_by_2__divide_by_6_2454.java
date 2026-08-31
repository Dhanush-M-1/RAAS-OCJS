import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        aa: while(t-->0){
            long n=sc.nextInt();
            int cnt=0;
            while(n!=1){
                if(n%3!=0){
                    System.out.println("-1");
                    continue aa;
                }
                if(n%6==0){
                    cnt++;n/=6;
                }
                else{
                    cnt+=2;n/=3;
                }
            }
            System.out.println(cnt);
        }
    }
}