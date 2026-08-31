import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math; 

public class Lo {
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int d = sc.nextInt();
      int v = sc.nextInt();
      int max = 0;
      ArrayList<Integer> A = new ArrayList<Integer>();
      for(int i = 0; i < d; i++){
          A.add(sc.nextInt());
      }
      for(int i = 0; i < d-1; i++){
          if(A.get(i)>A.get(i+1)){
              int x = A.get(i)-A.get(i+1)-v;
              if(max<x){
                  max = x;
              }
          }
      }
      System.out.println(max);
    }
}