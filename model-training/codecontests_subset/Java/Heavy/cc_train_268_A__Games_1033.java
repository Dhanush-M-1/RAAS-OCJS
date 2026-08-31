import java.util.Scanner;

public class Cf268a {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] homeUniformList = new int[n];
        int[] awayUniformList = new int[n];
        for (int i = 0; i < n; i++) {
            homeUniformList[i] = input.nextInt();
            awayUniformList[i] = input.nextInt();
        }

        // HOW MANY TIMES IS THE *HOST* TEAM GOING TO PUT ON THE GUEST UNIFORM.
        // The *HOST* team puts on the guest uniform:
        //    when the home uniform color of the host team matches the guests' uniform
        int matches = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                // i hosting
                if (homeUniformList[i] == awayUniformList[j]) {
                    matches += 1;
                }
                // j hosting
                if (homeUniformList[j] == awayUniformList[i]) {
                    matches += 1;
                }
            }
        }

        System.out.println(matches);
    }
}
