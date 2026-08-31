import java.io.*;
import java.util.*;


public class CodeForces
{
        private static long[][] numbers;
        private static long[][] helper;
        private static int number;
   
    public static void main(String[] args) throws IOException 
	{
                Scanner in = new Scanner(System.in);
                int n = in.nextInt();
                int max =0;
                long stop ;
              //  boolean top_option = true ;
                long[][] points = new long[n][2];
                for(int i=0 ; i<n ; i++){
                    points[i][0] = in.nextLong();
                    points[i][1] = in.nextLong();
                }
              sort(points);
              stop = points[0][0];
              for(int i=0 ; i <n  ; i++){
                 
                       if(i == 0) max ++ ;
                       else if(i == n-1) max++;
                       else{
                           if(points[i][0] - points[i][1] > stop){
                               max ++ ;
                               stop = points[i][0] ;
                           }
                           else if(points[i][0] + points[i][1] < points[i+1][0]){
                               max ++ ;
                               stop = points[i][0] + points[i][1] ;
                           }
                           else {
                               stop = points[i][0] ;
                           }
                       }      
              }  
              System.out.println(max);
        }
 
  
 
  
  
  public static void sort(long[][] values) {
    numbers = values;
    number = values.length;
    helper = new long[number][2];
    mergesort(0, number - 1);
  }

  private static void mergesort(int low, int high) {
  
    if (low < high) {
     
      int middle = low + (high - low) / 2;
      
      mergesort(low, middle);
     
      mergesort(middle + 1, high);
     
      merge(low, middle, high);
    }
  }

  private static void merge(int low, int middle, int high) {

      for (int i = low; i <= high; i++) {
      helper[i][0] = numbers[i][0];
      helper[i][1] = numbers[i][1];
    }

    int i = low;
    int j = middle + 1;
    int k = low;

    while (i <= middle && j <= high) {
      if (helper[i][0] <= helper[j][0] ) {
        numbers[k][0] = helper[i][0];
        numbers[k][1] = helper[i][1];
        i++;
      } else {
        numbers[k][0] = helper[j][0];
        numbers[k][1] = helper[j][1];
        j++;
      }
      k++;
    }
    while (i <= middle) {
      numbers[k][0] = helper[i][0];
      numbers[k][1] = helper[i][1];
      k++;
      i++;
    }
    while (j <= high) {
      numbers[k][0] = helper[j][0];
      numbers[k][1] = helper[j][1];
      k++;
      j++;
    }
  }
}