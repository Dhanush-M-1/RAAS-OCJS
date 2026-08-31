import java.util.Scanner;

/**
 * Created by constanzafierro on 11-01-17.
 */
public class CowsPokerGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] states = sc.next().toCharArray();
        int i = 0;
        int a = 0;
        for (char c: states){
            if (c=='I') i++;
            if (c=='A') a++;
        }
        if (i==1) System.out.println(1);
        else if (i>=2) System.out.println(0);
        else System.out.println(a);
    }
}
