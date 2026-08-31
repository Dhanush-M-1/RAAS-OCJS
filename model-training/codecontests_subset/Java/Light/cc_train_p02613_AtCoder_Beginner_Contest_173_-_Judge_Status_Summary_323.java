import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = Integer.parseInt(sc.nextLine());
    
    Map<String, Integer> map = new HashMap<>();
    for(int i=0;i<n;i++){
      String result = sc.nextLine();
      map.put(result, map.getOrDefault(result,0)+1);
    }
    
    for(String item:new String[]{"AC","WA","TLE","RE"}){
      System.out.println(item + " x " + map.getOrDefault(item,0));
    }
  }
}
