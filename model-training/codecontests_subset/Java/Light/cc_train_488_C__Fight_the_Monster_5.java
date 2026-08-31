
import java.util.Scanner;

public class FightMonster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hpY = sc.nextInt();
        int atkY = sc.nextInt();
        int defY = sc.nextInt();

        int hpM = sc.nextInt();
        int atkM = sc.nextInt();
        int defM = sc.nextInt();

        int h = sc.nextInt();
        int a = sc.nextInt();
        int d = sc.nextInt();

        int minCost = Integer.MAX_VALUE;

        for (int atk = Math.max(defM + 1, atkY); atk <= 200; atk++) {
            for (int def = defY; def <= Math.max(defY, atkM); def++) {
                int monsterDamage = Math.max(0, atkM - def);
                int yangDamage = Math.max(0, atk - defM);
                int turnsToKill = (hpM + yangDamage - 1) / yangDamage;
                int shouldHaveHealth = monsterDamage * turnsToKill + 1;

                int cost = (atk - atkY) * a + (def - defY) * d;
                if (shouldHaveHealth > hpY) {
                    cost += (shouldHaveHealth - hpY) * h;
                }
                if (cost < minCost) {
                    minCost = cost;
                }
            }
        }
        System.out.println(minCost);

    }
}
