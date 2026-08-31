
import java.util.Arrays;
import java.util.Scanner;


/* *********************************************************
 In the name of Allah , the most gracious , the most merciful. 
 
 **************************************************************/
public class NewClass9 {

                 public static void main(String[] args) {
                                  Scanner ob = new Scanner(System.in);
                                  int t = ob.nextInt();
                                  for (int T = 1; T <= t; T++) {
                                                   int m = ob.nextInt();
                                                   int n = ob.nextInt();

                                                   int a[] = new int[1010];
                                                   for (int i = 0; i < m; i++) {
                                                                    int x = ob.nextInt();
                                                                    a[x] = 1;
                                                   }
                                                   int k = 0;
                                                   for (int i = 0; i < n; i++) {
                                                                    int x = ob.nextInt();
                                                                    if (a[x] == 1 && k == 0) {
                                                                                     k = x;
                                                                    }
                                                   }
                                                   if (k == 0) {
                                                                    System.out.println("NO");
                                                   } else {
                                                                    System.out.println("YES");
                                                                    System.out.println(1 + " " + k);
                                                   }

                                  }
                 }
}