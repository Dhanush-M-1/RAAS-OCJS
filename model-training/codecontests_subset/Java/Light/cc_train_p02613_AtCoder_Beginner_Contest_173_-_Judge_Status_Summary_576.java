import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int a = 0, w = 0, t = 0, r = 0;
        for (int i = 0; i < N; i++ ){
            String str = s.next();
            if(str.equals("AC")) a++;
            if(str.equals("WA")) w++;
            if(str.equals("TLE")) t++;
            if(str.equals("RE")) r++;
        }

        System.out.println("AC x " + a);
        System.out.println("WA x " + w);
        System.out.println("TLE x " +t);
        System.out.println("RE x " + r);
    }
}