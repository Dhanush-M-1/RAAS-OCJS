import java.util.*;
public class CFEduRound3B {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int counter = 0;
        int[] books = new int[m];
        for(int i = 0; i < n; i++)
            books[input.nextInt() - 1]++;
        for(int i = 0; i < m; i++)
            for(int j = i + 1; j < m; j++)
                    counter += books[i] * books[j];
        System.out.println(counter);
    }
}
