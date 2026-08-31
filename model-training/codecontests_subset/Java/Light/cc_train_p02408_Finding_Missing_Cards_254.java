import java.util.*;

 class Main
 {
   public static void main(String args[])
   { 
    answer();
   }
   static void answer()
   {
     Scanner sc = new Scanner(System.in);
     
     int n = sc.nextInt();
     
     boolean[][] card = new boolean[4][14];
     
     String[] suit = {"S","H","C","D"};
     //input
     for(int i = 0;i < n;i ++)
     {
       String s = sc.next();
       
       int num = sc.nextInt();
       
       int sb = 5;
       
       for(int j = 0;j < 4; j ++)
       {
         if(suit[j].equals(s)) sb = j;
       }
       if(sb == 5)
       {
         System.out.println("error!!");
         
         return;
       }
       card[sb][num] = true ;
     }//output 
     for(int i = 0; i < 4; i ++)
     {
       for(int j = 1; j < 14; j ++)
       {
         if(card[i][j] != true)
         {
           System.out.println(suit[i] + " " + j);
         }
       }
     }
   }
 }

