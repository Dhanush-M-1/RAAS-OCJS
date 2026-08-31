import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int a[] = new int[100];
      int b[] = new int[100];
      for(int i = 0; i < n; i++) {
          a[i] = sc.nextInt();
          b[i] = sc.nextInt();
      }
      int count = 0;
      for(int i = 0; i < n; i++) {
          for(int j = 0; j < n; j++) {
              if(a[i] == b[j]) {
                  count++;
              }
          }
      } 
      System.out.println(count);
      
    }
}