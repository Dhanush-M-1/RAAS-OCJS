import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt();
        int fc=a;
        int wc=0;
        int hour=0;
        while(fc>0||wc>=b){
            if(fc>0){
            fc-=1;
            hour+=1;
            wc+=1;
            }
            else{
                if(wc>=b){
                    fc+=1;
                    wc-=b;
                }
            }
        }
        System.out.println(hour);
    }
}