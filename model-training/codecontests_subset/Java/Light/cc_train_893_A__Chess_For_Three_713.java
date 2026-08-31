import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int sum = scanner.nextInt();
            int spec = 3;
            boolean correct = true;
            while (sum>0){
                int winner = scanner.nextInt();
                if(winner==spec){
                    correct = false;
                    break;
                }
                spec = 6-winner-spec;

                sum --;
            }
            if(correct)
                System.out.println("YES");
            else
                System.out.println("NO");
    }
}
