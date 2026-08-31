import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ans = new int[4];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if(s.equals("AC")) ans[0]++;
            else if(s.equals("WA")) ans[1]++;
            else if(s.equals("TLE")) ans[2]++;
            else ans[3]++;
        }
        System.out.println("AC x " + ans[0]);
        System.out.println("WA x " + ans[1]);
        System.out.println("TLE x " + ans[2]);
        System.out.println("RE x " + ans[3]);
        sc.close();

    }

}
