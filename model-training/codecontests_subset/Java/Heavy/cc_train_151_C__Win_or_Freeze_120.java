//package clirr;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args){
        Scanner I = new Scanner(System.in);
        PrintWriter O = new PrintWriter(System.out);
        long q, n;
        q = I.nextLong();
        int a = 1, t = 0;
        int[] d = new int[3500001];
        Queue<Integer> s = new LinkedList();
        for (int i = 2; i <= 3500000; i++){
            d[i] = 0;
        }
        n = q;
        for (int i = 2; i <= 3500000; i++){
            if (d[i] == 0){
                s.add(i);
                for (int j = 2; i*j <= 3500000; j++)
                    d[i*j] = 1;
            }
        }
        for (; s.isEmpty() == false && s.peek() <= q; ){
            int i = s.peek();
            if (q % i < 1){
             //    O.println(i);
                 q /= i;
                 if (a > 1){
                     if (q > 1){
                         O.print(1 + "\n" + a * i);
                         t = 1;
                         break;
                     }
                     else{
                         t = 2;
                         break;
                     }
                 }
                 else
                    a *= i;
            }
            else
                s.poll();
        }
        if (t == 0 && a == 1 || a == n)
            O.print(1 + "\n" + 0);
        else if ((t == 0 && a != 1 || t == 2) && a != n)
            O.print(2);
        O.close();

    }

}