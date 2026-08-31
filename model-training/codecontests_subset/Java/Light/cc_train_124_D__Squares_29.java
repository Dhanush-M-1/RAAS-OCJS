/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;
import java.io.IOException;
import static java.lang.Integer.max;
import static java.lang.Math.abs;
/**
 *
 * @author Sergey
 */
public class Main {
        private static final Scanner scanner = new Scanner( System.in );

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str = "";
        
        str = scanner.nextLine();

        int[] arr = new int[6];
        int t1, t2;
        
        for(int i = 0; i < arr.length -1; i++){
            int index = str.indexOf(" ");
            arr[i] = Integer.parseInt(str.substring(0, index));
            str = str.substring(index+1);
        }
        
        arr[5] = Integer.parseInt(str);
        
        t1 = arr[2]; t2 = arr[3];
        arr[2] = t1 + t2;
        arr[3] = t2 - t1;

        t1 = arr[4]; t2 = arr[5];
        arr[4] = t1 + t2;
        arr[5] = t2 - t1;
        
        arr[0] *= 2;
        arr[1] *= 2;
        
        arr[2]= arr[2] / arr[0] + ((arr[2] > 0)? 1 : 0);
        arr[4] = arr[4] / arr[0] + ((arr[4] > 0)? 1 : 0);
        arr[3] = arr[3] / arr[1] + ((arr[3] > 0)? 1 : 0);
        arr[5] = arr[5] / arr[1] + ((arr[5] > 0)? 1 : 0);
        
        System.out.print(max(abs(arr[5] - arr[3]), abs(arr[4] - arr[2])));
    }
}
