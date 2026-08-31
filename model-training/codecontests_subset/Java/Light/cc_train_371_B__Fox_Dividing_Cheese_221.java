import java.util.Scanner;

public class Fox {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] facts = new int[2][4];
        facts[0][3] = sc.nextInt();
        facts[1][3] = sc.nextInt();
        int[] factors = { 2, 3, 5 };
        for (int j = 0; j < facts.length; j++)
            for (int i = 0; i < factors.length; i++)
                while (facts[j][3] % factors[i] == 0) {
                    facts[j][3]/=factors[i];
                    facts[j][i]++;
                }
        if(facts[0][3] != facts[1][3])
            System.out.println(-1);
        else{
            int ans = 0;
            for(int i = 0; i < 3; i++)
                ans+= Math.abs(facts[0][i]-facts[1][i]);
            System.out.println(ans);
        }
    }
}
