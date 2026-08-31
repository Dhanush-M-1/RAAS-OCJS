import java.util.*;
import java.io.*;
public class NewYearCandles
{
   public static void main(String[] args) throws Exception
   {       
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int full = Integer.parseInt(st.nextToken());
      int needed = Integer.parseInt(st.nextToken());
      int hours = full; // initial usage and time
      int used = full;
      full = 0;
      while (used >= needed) // after initial use, after every cycle, we combine a few used to make fulls
      { // then the full ones are used again (and we added some time) 
         full += (int) (used / needed); // make a few full candles
         used %= needed; // the leftover used candles
         hours += full; // extra time from the created ones
         used += full; // 
         full = 0;
      }
      
      System.out.println(hours);
      br.close();
   }
}