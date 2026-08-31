
import java.util.Scanner;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s,newS="";
        int j = 0;

        s = in.next();

        int[] arr = new int[s.length() - (s.length() / 2)];

        if (s.length() < 2) {
            System.out.println(s);
            System.exit(0);
        }
        for (int i = 0; i < s.length() - s.length() / 2; i++) {
            arr[i] = Integer.parseInt(s.substring(j, j + 1));
            j += 2;
        }

        Arrays.sort(arr);


        for (int i = 0 ; i <s.length() - s.length() / 2 ; i++){
            if (i == 0)
                newS += arr[i];
            else
                newS += "+"+arr[i];
        }

        System.out.println(newS);
    }
}
