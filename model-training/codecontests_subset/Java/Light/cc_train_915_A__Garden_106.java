import java.util.*;

public class Garden {

  public static  void main(String args[]){


      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int k = s.nextInt();

      int min = Integer.MAX_VALUE;
      int ans = 0;
      for(int i=0;i<n;i++){
          int x  = s.nextInt();
          if(k%x == 0){
              if(min > k/x){
                  min = k/x;
                  ans = x;
              }
          }
      }



      System.out.println(min);
  }
}
