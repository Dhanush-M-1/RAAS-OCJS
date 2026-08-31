import java.util.*;
public class Codeforces893A
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      int[] array = new int[n];
      
      for(int i = 0; i < n; i++)
      {
         array[i] = input.nextInt();  
      }
      
      int notPlaying = 3;
      boolean isPrinted = false;
      for(int i = 0; i < n; i++)
      {
         //System.out.println("not playing is " + notPlaying + " winner is " + array[i]);
         if(array[i] == notPlaying && isPrinted == false){System.out.println("NO"); isPrinted = true;}
         
         if(array[i] == 1 && notPlaying == 2){notPlaying = 3;}
         else if(array[i] == 1 && notPlaying == 3){notPlaying = 2;}
         else if(array[i] == 2 && notPlaying == 1){notPlaying = 3;}
         else if(array[i] == 2 && notPlaying == 3){notPlaying = 1;}
         else if(array[i] == 3 && notPlaying == 1){notPlaying = 2;}
         else if(array[i] == 3 && notPlaying == 2){notPlaying = 1;}
      }
      if(isPrinted == false){System.out.println("YES");}
   }
}