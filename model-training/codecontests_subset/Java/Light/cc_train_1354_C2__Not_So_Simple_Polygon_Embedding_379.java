import java.io.BufferedInputStream;
import java.util.Scanner;

public class SimplePolygonEmbedding {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int t = input.nextInt();
        int count = 0;
        while (count < t) {
            count++;
            int n = input.nextInt();
            if (n % 2 == 0)
                System.out.println(1 / (Math.tan(Math.PI / 2 / n)));
            else//idk what this is
                System.out.println(Math.cos(Math.PI / 4 / n) / (Math.sin(Math.PI / 2 / n)));
        }
    }
}
