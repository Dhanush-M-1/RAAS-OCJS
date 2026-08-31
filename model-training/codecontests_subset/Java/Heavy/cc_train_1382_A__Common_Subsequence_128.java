import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;


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

                                                   int a[] = new int[m];
                                                   int b[] = new int[n];

                                                   for (int i = 0; i < m; i++) {
                                                                    a[i] = ob.nextInt();
                                                   }
                                                   for (int i = 0; i < n; i++) {
                                                                    b[i] = ob.nextInt();
                                                   }

                                                   int k=0;
                                                   out:
                                                   for (int i = 0; i < m; i++) {
                                                                    for (int j = 0; j < n; j++) {
                                                                                     if (a[i] == b[j]) {
                                                                                                      System.out.println("YES");
                                                                                                      System.out.println(1 + " " + a[i]);
                                                                                                      k=1;
                                                                                                      break out;
                                                                                     }
                                                                    }
                                                   }
                                                   if(k==0){System.out.println("NO");}

                                  }
                 }
}