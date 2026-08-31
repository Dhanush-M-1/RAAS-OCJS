//package fuckyeah;

import java.util.Scanner;

public class FuckYeah {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        float need=a*c;
        float downtime=need/(float)b;
        if(downtime%1!=0){
            downtime=(int)downtime+1;
        }
        System.out.println((int)downtime-c);
    }
}
