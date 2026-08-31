/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Ahmed
 */
public class Watermelon {

    public static boolean state;
    public static int countA = 0, countB = 0;

    private static int mod(int x, int y) {
        int result = x % y;
        return result < 0 ? result + y : result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        java.util.Scanner input = new java.util.Scanner(System.in);
        int n = input.nextInt();
        int arr[][] = new int[n][2];

        int home[] = new int[n];
        int guest[] = new int[n];
        
        HashMap<Integer,  Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; ++i) {
            home[i] =  input.nextInt();
            guest[i] =  input.nextInt();
         
            int key  = home[i];
            if(map.get(key) == null)
            {
               map.put(key, 1);
            }
            else{
                map.put(key, map.get(key) + 1);
            }
            
         /*   
            for(int j = 0 ; j < 2 ; ++j)
            {
               arr[i][j] = input.nextInt();
            }
            
            int key  = arr[i][0];
            if(map.get(key) == null)
            {
               map.put(key, 1);
            }
            else{
                map.put(key, map.get(key) + 1);
            }*/
        }
        
        
        int sum = 0 ;
        for(int i = 0 ; i < arr.length ; ++i)
        {
           // int value = arr[i][1];
            int value = guest[i];
            if(map.get(value) != null)
            {
                sum +=  map.get(value);
            }
        }
        
        System.out.println(sum);
    }

  public static void solver(int k , int r)
  {
      
      for(int i = 1 ; i  < Integer.MAX_VALUE ; ++i)
      {
          int x = k * i;
          int z = x - r;
          int f = mod(z , 10);
          if(f  == 0)
          {
              System.out.println(i);
              return;
          }
      }
  }
}
