import java.io.*;

import java.util.*;



public class problemA 
{
   public static void main (String[] args) throws IOException
   {
   
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer token = new StringTokenizer(input.readLine());
      int maxCount = Integer.parseInt(token.nextToken());
      for(int b = 0; b < maxCount; b++)
      {
         boolean no = true;
         token = new StringTokenizer(input.readLine());
         int array1Length =  Integer.parseInt(token.nextToken());
         int array2Length =  Integer.parseInt(token.nextToken());
         ArrayList<Integer> array1 = new ArrayList<Integer>();
         token = new StringTokenizer(input.readLine());
         for(int x = 0; x < array1Length; x++)
            array1.add(Integer.parseInt(token.nextToken()));
         ArrayList<Integer> array2 = new ArrayList<Integer>();
         token = new StringTokenizer(input.readLine());
         for(int x = 0; x < array2Length; x++)
            array2.add(Integer.parseInt(token.nextToken()));
         for(int x = 0; x < array1Length; x++)
         {
            if(array2.contains(array1.get(x)))
            {
               System.out.println("YES");
               System.out.println("1 " + array1.get(x));
               no = false;
               break;
            }
         }
         if(no)
            System.out.println("NO");
      }     
   }
}