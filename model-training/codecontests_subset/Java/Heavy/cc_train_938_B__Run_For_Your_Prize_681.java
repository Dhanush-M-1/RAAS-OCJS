import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunForYourPrize {

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int [] array = new int[1000001];
        for (int i = 0; i < 1000001; i++){
            array[i] = 0;
        }
        for (int i = 0; i < n; i++){
            int c = in.nextInt();
            array[c] = 1;
        }
        int start1 = 1, start2 = 1000000;
        int sum = 0;
        int time = 0;
        while (sum != n){
            start1++;
            if (array[start1] == 1) sum++;
            start2--;
            if (array[start2] == 1) sum++;
            time++;
        }
        System.out.println(time);
    }

}
