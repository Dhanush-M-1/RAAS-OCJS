import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for (int i = 0; i < t; i++) {
          int length1 = sc.nextInt();
          int length2 = sc.nextInt();
          
          int[] arr1 = new int[length1];
          int[] arr2 = new int[length2];
          HashSet set = new HashSet<>();
          for (int j = 0; j < arr1.length; j++) {
              arr1[j] = sc.nextInt();
              set.add(arr1[j]);
          }
          boolean isFound = false;
          for (int j = 0; j < arr2.length; j++) {
              arr2[j] = sc.nextInt();
              
          }
          
          for (int num : arr2) {
              if (set.contains(num)) {
                  System.out.println("YES");
                  System.out.println(1 + " " + num);
                  isFound = true;
                  break;
              }
          }
          if (!isFound) {
              System.out.println("NO");
          }
          
          
          
      }
    }
}