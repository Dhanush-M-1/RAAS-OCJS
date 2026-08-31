
import java.util.Scanner;

public class Bigo {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int numType = input.nextInt();

        int [] arrs = new int[size];
        int [] coutofType = new int[numType];

        for (int i = 0; i < size; i++){
            int n = input.nextInt();
            arrs[i] = n;
            coutofType[n -1] = ++coutofType[n -1];
        }

        int count = 0;
        for (int i = 0 ; i < size; i++){

            int increase = size - i - coutofType[arrs[i] - 1];
            coutofType[arrs[i] - 1] =  --coutofType[arrs[i] - 1];
            if (increase > 0)
                count += increase;
        }

        System.out.println(count);
    }
}