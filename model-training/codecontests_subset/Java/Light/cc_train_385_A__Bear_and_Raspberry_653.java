

import java.util.Scanner;

public class BearandRaspberry_385A {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int days = input.nextInt();
        int c = input.nextInt();
        int arr[] = new int[days];
        int res = 0;
       
        for (int i = 0; i < days; i++) {
            arr[i]=input.nextInt();
        }
        for (int i = 0; i < days - 1; i++) {
            int dif = arr[i ] - arr[i+1]-c;
            if (dif > res) {
                res = dif;
               
            }

        }
       
        System.out.println(res);

    }

}
