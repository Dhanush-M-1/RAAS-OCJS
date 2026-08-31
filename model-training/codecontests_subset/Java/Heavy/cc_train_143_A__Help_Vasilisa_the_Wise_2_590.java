import java.io.*;
import java.util.Scanner;

import static java.lang.Integer.*;
@SuppressWarnings("unused")
public class A {

    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        for(int i = 1 ; i < 10 ; ++i){
            for(int j = 1 ; j < 10 ; ++j){
                if(i == j)
                    continue;
                for(int k = 1 ; k < 10 ; ++k){
                    if(i == k || j == k)
                        continue;
                    for(int l = 1 ; l < 10 ; ++l){
                        if(i == l || j == l || k == l)
                            continue;
                        if(i + k == c1 && j + l == c2
                                && i + j == r1 && k + l == r2
                                && j + k == d2 && i + l == d1){
                            System.out.println(i + " " + j);
                            System.out.println(k + " " + l);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
