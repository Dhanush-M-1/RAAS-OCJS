import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        int[] array = {1, 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14, 1, 5, 1, 5, 2, 2, 1, 15, 2, 2, 5, 4, 1, 4, 1, 51};
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        System.out.print(array[k-1]);

    }

}
