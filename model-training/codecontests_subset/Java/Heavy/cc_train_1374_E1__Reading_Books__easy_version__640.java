import java.util.*;
// 
// gatogari.
public class Solution {
    public static void main(String[] args) {       

        Scanner scanner = new Scanner(System.in);
          
        int n = scanner.nextInt();
        int k = scanner.nextInt();
         int[][] array = new int[n][3];

                for(int i = 0; i < n; ++i)
                    {
                        array[i][0] = scanner.nextInt();
                        array[i][1] =scanner.nextInt();
                        array[i][2] =scanner.nextInt();
                    }
                 //sort arr
                
                    int[] uno_cero = new  int[n];
                    int unces = 0;
                    int a = 0;
                    
                    int[] cero_uno = new  int[n];
                    int ceuns = 0;
                    int b = 0;
                 
                 long res = 0L;
                 sort(array);
                 for(int i = 0; i < n; ++i)
                 {
                     
                     if(array[i][1] == 1 && array[i][2] == 1)
                     {
                         int suma = 100000;
                         if(ceuns > 0 && unces > 0) suma = cero_uno[ceuns-1] + uno_cero[unces-1];
                         if(array[i][0] < suma && ceuns > 0 && unces > 0 && a >= k && b >= k)
                         {
                            res -= suma;
                            --unces;
                            --ceuns;
                            res += array[i][0];
                         }
                         else if(a < k || b < k)
                         {
                                if(a >= k)
                            {
                               --a;
                               res -= uno_cero[unces-1];
                               --unces;

                            }
                            if(b >= k)
                            {
                               --b;
                               res -= cero_uno[ceuns-1];
                               --ceuns; 
                            }
                            ++a;
                            ++b;
                            res += array[i][0];
                         }
                         
                         
                     }
                     else if(array[i][1] == 1 && a < k)
                     {
                         uno_cero[unces] = array[i][0];
                         ++unces;
                         ++a;
                         res += array[i][0];
                     }
                     else if(array[i][2] == 1 && b < k)
                     {
                        cero_uno[ceuns] = array[i][0];
                         ++ceuns;
                         ++b; 
                         res += array[i][0];
                     }
                 }
                 long sol = a >= k && b >= k ? res: -1;
                 System.out.println(sol);
    }
    public static void sort(int[][] arr) 
    { 
        int n = arr.length; 
  
        
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        
        for (int i=n-1; i>0; i--) 
        { 
           
            int temp = arr[0][0]; 
            int tempp = arr[0][1]; 
            int temppp = arr[0][2];
            arr[0][0] = arr[i][0]; 
            arr[0][1] = arr[i][1]; 
            arr[0][2] = arr[i][2];
            arr[i][0] = temp; 
            arr[i][1] = tempp; 
            arr[i][2] = temppp;
  
         
            heapify(arr, i, 0); 
        } 
    } 
     static void heapify(int[][] arr, int n, int i) 
    { 
        int largest = i; 
        int l = 2*i + 1; 
        int r = 2*i + 2;   
       
        if (l < n && arr[l][0] > arr[largest][0]) 
        {           
                largest = l;           
        }
        
        if (r < n && arr[r][0] > arr[largest][0]) {          
                largest = r;            
        }
            
          
        if (largest != i) 
        { 
            int swap = arr[i][0];
            int swapp = arr[i][1];
            int swappp = arr[i][2];
            arr[i][0] = arr[largest][0]; 
            arr[i][1] = arr[largest][1];
            arr[i][2] = arr[largest][2];
            arr[largest][0] = swap;  
            arr[largest][1] = swapp;
            arr[largest][2] = swappp;
            heapify(arr, n, largest); 
        } 
    } 
}

