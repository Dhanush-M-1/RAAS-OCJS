import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long f = 0;

        for(int i = 0; i < N; i++){
            f += sc.nextInt() - 1;
        }

        System.out.println(f);
    }
}
