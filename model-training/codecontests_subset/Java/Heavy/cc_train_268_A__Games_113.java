import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class HomeGuestJerseyColor {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    
    Map<Integer,Integer> map = new HashMap<>();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
      int homeColor = sc.nextInt();
      int guestColor = sc.nextInt();
      arr[i] = homeColor;
      map.put(guestColor, map.getOrDefault(guestColor,0)+1);
    }
    
    int res = 0;
    for(int homeColor:arr){
      res+= map.getOrDefault(homeColor,0);
    }
    System.out.println(res);
  }
}


/* 
Your previous Plain Text content is preserved below:

Examples
inputCopy
3
1 2
2 4
3 4
outputCopy
1
inputCopy
4
100 42
42 100
5 42
100 5
outputCopy
5
inputCopy
2
1 2
1 2
outputCopy
0
 */
