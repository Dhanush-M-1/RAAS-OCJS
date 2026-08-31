
import java.util.Scanner;


public class  Main{
 public static void main(String args [])
 {
     Scanner scanner = new Scanner (System.in);
     int n = scanner.nextInt();
     int team1 [] = new int[n];
     int team2 [] = new int[n];
     int count = 0;
     for (int i = 0; i < n; i++)
     {
         team1[i]=scanner.nextInt();
         team2[i]=scanner.nextInt();
     }
     for (int i = 0; i < n; i++)
     {
         for (int j = i+1; j < n; j++)
         {
             if(team1[i] == team2[j])
             {
                 count++;
             }
             if(team1[j] == team2[i])
             {
                 count++;
             }
         }
  
     }
     System.out.println(count);
    
 }       
         
}
