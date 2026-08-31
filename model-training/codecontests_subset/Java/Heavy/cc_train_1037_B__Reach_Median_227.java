import java.util.*;
/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 12.09.2018
 * @author 
 */

public class solution {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int s = sc.nextInt();
    int[] a = new int[n];
    
    long z = 0; //Zähler für die Schritte
    
    
    for (int i = 0; i<n; i++) {
      a[i] = sc.nextInt();
    } 
    
    //sort(a); //zuerst einmal sortieren!
    Arrays.sort(a);
    int median = a[(n/2)]; //Median!
    
    //System.out.println(median);
    if (a[(n/2)] != s) {
      z += Math.abs(a[(n/2)]-s);
    }
    
    for (int i = 0; i<(n/2); i++) {
      
      if (a[i]>s) {
        z += Math.abs(a[i]-s);
        
        
      } 
      
      if (a[n-1-i] < s) {
        z += Math.abs(a[n-1-i]-s);
      }
      
    } 
    
    
    
    System.out.println(z);
    
    
    
    
    /*
    for(int z : a) {
    System.out.println(z);
    }    */
    
  } 
  
  
  
  
  
  /*
  public static int[] sort(int[] r) { //Sortieralgorithmus!  
    int k;
    for (int i = 0; i < r.length; i++) {
      for (int j = r.length-1; j > 0; j--) {
        if (r[j-1] > r[j]) {
          k = r[j];
          r[j] = r[j - 1];
          r[j - 1] = k;
        }
      }
    }
    return r;
  }   */
  
} 
