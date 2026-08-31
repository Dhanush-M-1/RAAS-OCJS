

import java.util.Scanner;

public class c2 {

    public static void main(String cd[]){
        Scanner in=new Scanner(System.in);
        long n=in.nextLong();
        long m=n;
        long previous=0;
        long now=0;
        if(n==1){
            System.out.println(1);
            System.out.println(0);
            return;
        }
        for(int i=2;(long)i*i<=m;i++){
            while(n%i==0){
                n=n/i;
                previous=now;
                now=i;
                if(previous!=0){
                    break;
                }
            }
            if(previous!=0){
                break;
            }
            
        }
        if((previous==0 && now==0)){
            System.out.println(1+"\n"+0);
            return;
        }
        //System.out.println(previous+" "+now+" "+now*now);
        if(previous==0 && now !=0){
            System.out.println(2);
            return;
        }
        if((previous*now!=m)){
            if(previous!=0)
            System.out.println(1+"\n"+previous*now);
            else
                System.out.println(1+"\n"+0);
        }
        else{
            System.out.println(2);
        }
    }
}
