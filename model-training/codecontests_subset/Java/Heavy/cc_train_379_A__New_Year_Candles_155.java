
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.util.Arrays;


public class geek {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        try{





            StringBuffer sb=new StringBuffer();
           int a=s.nextInt();
           int b=s.nextInt();
          int candles=a,went=0,ans=0;
          while (candles>0){
              ans++;
              candles--;
              went++;
              if(went==b){
                  candles++;
                  went=0;
              }
          }
            System.out.println(ans);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}










