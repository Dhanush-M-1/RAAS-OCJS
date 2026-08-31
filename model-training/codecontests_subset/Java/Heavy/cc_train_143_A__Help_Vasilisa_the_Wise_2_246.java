import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        int r1 = scan.nextInt();
        int r2 = scan.nextInt();
        int c1 = scan.nextInt();
        int c2 = scan.nextInt();
        int d1 = scan.nextInt();
        int d2 = scan.nextInt();
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                if(i == j){
                    continue;
                }
                for(int m = 1; m <= 9; m++){
                    if(m == i || m == j){
                        continue;
                    }
                    for(int n = 1; n <= 9; n++){
                        if(n == i || n == j || n == m){
                            continue;
                        }
                        
                        if(i + j != r1 ||
                                m + n != r2
                                || i + m != c1
                                || j + n != c2
                                || i + n != d1
                                || j + m != d2){
                            continue;
                        }
                        System.out.println(i + " " + j);
                        System.out.println(m + " " + n);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}