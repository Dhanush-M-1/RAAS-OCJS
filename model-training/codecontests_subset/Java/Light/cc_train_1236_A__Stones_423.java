import java.util.*;
public class Stones{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int z = 0; z < t; z++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int stones=0;
            if(b==0){
                System.out.println("0");
            }
            else{
                if(b<=c/2){
                    System.out.println(b+2*b);
                    continue;
                }
                else{
                    stones+=(c/2)+2*(c/2);
                    b-=(c/2);
                    if(a<=b/2){
                        stones+=(a+2*a);
                    }
                    else{
                        stones+=(b/2)+2*(b/2);
                    }
                    System.out.println(stones);
                }
            }
        }
        sc.close();
    }
}