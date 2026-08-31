import java.util.Scanner;
public class main {


    public static void main(String[] args) {
         Scanner SC = new Scanner(System.in);
         String [] Data = SC.nextLine().split("\\s+");
         int a = Integer.parseInt(Data[0]);
         int b = Integer.parseInt(Data[1]);
         
         int hours = a;
         int candles = 0;
         int candlesused = a;
         
         do
         {
             candles = candlesused / b;
             candlesused = candlesused % b;
             hours += candles;
             candlesused = candles + candlesused;
         }
         while(candlesused / b >0);
         System.out.println(hours);
    }
    
}
