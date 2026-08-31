import java.util.Scanner;

public class Games {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), counter = 0;
        int[][] kits = new int[n][n];
        for(int i = 0; i < n; i++) {
            kits[i][0] = sc.nextInt();
            kits[i][1] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j)
                    continue;
                if(kits[i][0] == kits[j][1])
                    counter++;
            }
        }
        System.out.println(counter);
    }
    
}