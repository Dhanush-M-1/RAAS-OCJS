import java.util.Scanner;

public class A893 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int game = scanner.nextInt();
        int[] log = new int[game];
        int i;
        for(i=0; i<game; i++)
        {
            log[i] = scanner.nextInt();
        }
        int spec = 3;
        for(i=0; i<game; i++)
        {
            if(log[i] == spec)
            {
                System.out.println("NO");
                System.exit(0);
            }
            spec = 6 - spec - log[i];
        }
        System.out.println("YES");
    }
}
