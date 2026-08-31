

import java.util.*;
import java.io.*;

public class Codeforces {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[][] arr = new int [2][3];

        a = fillArray(a, arr[0]);
        b = fillArray(b , arr[1]);

        if( a != b){
            System.out.println(-1);
            return;
        }

        int res = Math.abs(arr[0][0] - arr[1][0]) + Math.abs(arr[0][1] - arr[1][1]) + Math.abs(arr[0][2] - arr[1][2]);
        System.out.println(res);
    }

    private static int fillArray(int n, int[] arr){
        boolean isOk = true;
        while(isOk){
            if(n % 2 == 0){
                n /= 2;
                arr[0]++;
                continue;
            }
            if(n % 3 == 0){
                n /= 3;
                arr[1]++;
                continue;
            }
            if(n % 5 == 0){
                n /= 5;
                arr[2]++;
                continue;
            }
            isOk = false;
        }
        return n;
    }
}
