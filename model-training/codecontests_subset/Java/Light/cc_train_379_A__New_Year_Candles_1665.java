import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.Math;
public class Candle {


    public static void main(String[] args) {

        

        

      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int m = in.nextInt();

      int count = 0;
      int daycount = 0;
      while(n>0)
      {
         n-=1;
         
         daycount++;
         if(daycount==m)
         {
         n++;
         daycount=0;
         }
         count++;
      }
      System.out.println(count);
                 
  }    

}
