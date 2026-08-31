import java.util.Scanner;

public class Lets_Watch_Football {

    public static boolean suitable (int matchLen,int shouldLoad,int canLoad,int t ){
        int requiredData = matchLen*shouldLoad;
        int can = canLoad*t + matchLen*canLoad;
        if (can>=requiredData) return true;
        return false;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        int shouldLoad,canLoad,matchLen;
        shouldLoad=s.nextInt();
        canLoad=s.nextInt();
        matchLen=s.nextInt();
        int lo=0,hi,t,min;
        hi = (int)Math.ceil(((double)matchLen*(double)shouldLoad) / (double)canLoad );
        min = hi;
        while (lo<hi){
            t=lo + (hi-lo)/2;
            if (suitable (matchLen,shouldLoad,canLoad,t)){
                min = t;
                hi = t;
            }
            else {lo=t+1;}
        }
        System.out.print(min);
    }

}