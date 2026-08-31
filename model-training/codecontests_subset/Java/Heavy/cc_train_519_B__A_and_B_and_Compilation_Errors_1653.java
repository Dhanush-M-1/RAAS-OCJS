import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr1 = new int[n];
    int[] arr2 = new int[n-1];
    int[] arr3 = new int[n-2];
    for (int i = 0; i < n; i++) arr1[i] = sc.nextInt();
    for (int i = 0; i < n-1; i++) arr2[i] = sc.nextInt();
    for (int i = 0; i < n-2; i++) arr3[i] = sc.nextInt();
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    Arrays.sort(arr3);

    boolean printed = false;
    for (int i = 0; i < arr2.length; i++) {
      if (arr1[i] != arr2[i]) {
        System.out.println(arr1[i]);
        printed = true;
        break;    
      }
    }
    if(printed == false) {
      System.out.println(arr1[arr1.length-1]);
    }

    printed = false;
    for (int i = 0; i < arr3.length; i++) {
      if (arr2[i] != arr3[i]) {
        System.out.println(arr2[i]);
        printed = true;
        break;    
      }
    }
    if(printed == false) {
      System.out.println(arr2[arr2.length-1]);
    }
  }
}
