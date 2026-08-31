import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by denissamodurov on 23/02/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] goalsList = input.readLine().split(" ");
        printName(goalsList[0], goalsList[1], 0);
        int n = Integer.parseInt(input.readLine());

        for(int i = 0; i < n; i++){
            String first = goalsList[0];
            String second = goalsList[1];
            String[] temp = input.readLine().split(" ");
            if(first.equals(temp[0])){
                printName(temp[1], second, i);
                goalsList[1] = temp[1];
                goalsList[0] = second;
                continue;
            }
            if(second.equals(temp[0])){
                printName(temp[1], first, 1);
                goalsList[1] = temp[1];
                goalsList[0] = first;
                continue;
            }
            if(first.equals(temp[1])){
                printName(temp[0], second, i);
                goalsList[1] = temp[0];
                goalsList[0] = second;
                continue;
            }
            if(second.equals(temp[1])){
                printName(temp[0], first, 1);
                goalsList[1] = temp[0];
                goalsList[0] = first;
                continue;
            }
        }
    }

    private static void printName(String a, String b, int n) {
        if(n == 0){
            System.out.println(a + " " + b);
            return;
        }
        System.out.println(b + " " + a);
    }
}
