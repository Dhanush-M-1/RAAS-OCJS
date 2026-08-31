import java.util.Scanner;

public class MyClass {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] colors = new int[n][2];
        for (int i = 0; i < n; i++) {
            colors[i][0] = in.nextInt();
            colors[i][1] = in.nextInt();
        }

        int games = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i!=j){
                    if(colors[i][0] == colors[j][1]){
                        games++;
                    }
                }
            }
        }
        System.out.print(games);
    }
}