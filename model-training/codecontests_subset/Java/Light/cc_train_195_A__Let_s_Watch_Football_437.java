
import java.util.Scanner;
public class LetSWatchFootball {

    public static void main(String[] args) {
       Scanner in=new Scanner(System.in);
       int a,b,c,i=0;
       
       a=in.nextInt();
       b=in.nextInt();
       c=in.nextInt();
       int y=b*c;
       a=a*c;
       while(a>0)
       {
           a=a-b;i++; 
          // System.out.println(a);
           //System.out.println(y);
           if((y-a)<0)
           {
           } else {
               break;
           }
         
       }
        System.out.println(i);
    }
    
}
