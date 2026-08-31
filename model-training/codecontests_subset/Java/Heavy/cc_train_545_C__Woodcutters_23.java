

import java.util.Scanner;

/**
 *
 * @author ADNAN
 */
public class Woodcutters {

    public static int dp[];

    public static void main(String args[]) {
        int x[];
        int h[];
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        x = new int[n];
        h = new int[n];
        dp = new int[n];
        while (n != 0) {
            x[x.length - n] = scanner.nextInt();
            h[x.length - n] = scanner.nextInt();
            scanner.nextLine();
            n--;
        }
        int count  = x.length == 1? 1: 2;
        for(int i = 1 ;i< x.length - 1;i++ ){
            if(x[i] - h[i] > x[i-1] )
                count++;
            else if(x[i] + h[i] < x[i +1]){
                 count++;
                 x[i] = x[i] +h[i];
            }
        }

        System.out.println(count);
      

    }

 
}
