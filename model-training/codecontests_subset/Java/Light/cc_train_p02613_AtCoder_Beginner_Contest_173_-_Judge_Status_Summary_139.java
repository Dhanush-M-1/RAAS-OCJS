import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String s[] = {"AC", "WA", "TLE", "RE"};
    int a[] = {0, 0, 0, 0};
    for (int i = 0; i < n; i++){
      String b = sc.next();
      for (int j = 0; j < 4; j++){
        if (s[j].equals(b)){
          a[j]++;
        }
      }
    }
    for (int i = 0; i < 4; i++){
      System.out.printf("%s x %d\n", s[i], a[i]);
    }
  }
}
