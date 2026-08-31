import java.io.*;
import java.util.*;

public class CodeForce1
{
     public static void main(String[] args) 
     {
           Scanner keyboard = new Scanner(System.in);
                      
           int n = keyboard.nextInt();
           
           for (int i = 0; i < n; i++)
           {
               int num = keyboard.nextInt();
               int move = 0;
               
               while (num > 1)
               {
                    if (num % 6 == 0)
                    {
                        num /= 6;
                        move++;
                    }
                    else
                    {
                        num *= 2;
                        move++;
                    }
              }
              
              if (num == 1)
              {
                  System.out.println(move);
              }
              else
              {
                  System.out.println(-1);
              }
            }
      }
}
               