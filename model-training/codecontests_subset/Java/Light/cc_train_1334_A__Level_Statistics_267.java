import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int m = scanner.nextInt();
            int[] pi = new int[m];
            int[] ci = new int[m];
            for(int j = 0; j < m; j++){
                pi[j] = scanner.nextInt();
                ci[j] = scanner.nextInt();
            }
            boolean failure = !(pi[0] >= ci[0]);
            for(int j = 1; j < m; j++){
                int lastP = pi[j - 1];
                int currP = pi[j];
                int lastC = ci[j - 1];
                int currC = ci[j];
                int diffP = currP - lastP;
                int diffC = currC - lastC;
                boolean pNotDecreased = diffP >= 0;
                boolean cNotDecreased = diffC >= 0;
                boolean cNotIncreasedMoreThanP = diffC <= diffP;
                if(!(pNotDecreased && cNotDecreased && cNotIncreasedMoreThanP)){
                    failure = true;
                    break;
                }
            }
            System.out.println(failure ? "NO" : "YES");
        }
    }
}
