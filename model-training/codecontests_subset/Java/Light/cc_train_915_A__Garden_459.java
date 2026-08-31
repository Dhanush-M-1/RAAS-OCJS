import java.util.*;
public class A{
       
       public static void main(String args[]){
              Scanner sc = new Scanner(System.in);
              int n = sc.nextInt();
              int garden = sc.nextInt();
              int min = Integer.MAX_VALUE;
              for(int i = 0; i < n; i++){
                     int bucket = sc.nextInt();
                     if(garden % bucket == 0)
                            min = Math.min(min, garden / bucket);
              }
              System.out.println(min);
       }
}