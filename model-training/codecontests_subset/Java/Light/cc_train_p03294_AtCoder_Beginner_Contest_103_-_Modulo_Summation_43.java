import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int j = 0; j < n; j++){
      a[j] = sc.nextInt();
    }
    int am = 0;
    for(int j = 0; j < n; j++){
      am += a[j] - 1;
    }
    System.out.println(am);
  }
}