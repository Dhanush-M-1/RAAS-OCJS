import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        String word = "welcome";
        word = scan.next();
        String[] arr = word.split("\\+");
        int[] num = new int[arr.length];
        for (int j = 0; j < arr.length; j++) {
            num[j] = Integer.parseInt(arr[j]);
        }
        
        Arrays.sort(num);
        
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1)
                System.out.println(num[i]);
            else
                System.out.print(num[i] + "+");

        }

    }

}
