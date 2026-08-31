import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
public class _1043A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s=0;
        LinkedList<Integer> ll= new LinkedList<>();
           for (int i = 0; i < n; i++) {
              ll.add(sc.nextInt());
              s+=ll.get(i);
            }
         int sum=0;
         Collections.sort(ll);
         int a=Collections.max(ll)-1;
         int i;
          while(sum<=s) {
             a++;
             i = 0;
             sum = 0;
             while (i<ll.size()) {
                 sum += a - ll.get(i);
                 i++;
             }
          }
        System.out.println(a);
    }
}