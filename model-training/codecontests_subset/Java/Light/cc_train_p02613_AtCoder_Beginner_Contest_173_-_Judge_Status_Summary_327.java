import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] c = new int[4];
        for (int i=0;i<n;i++){
            String s = sc.next();
            if (s.equals("AC"))c[0]++;
            else if (s.equals("WA"))c[1]++;
            else if (s.equals("TLE"))c[2]++;
            else if (s.equals("RE"))c[3]++;
        }
        System.out.println("AC x "+c[0]);
        System.out.println("WA x "+c[1]);
        System.out.println("TLE x "+c[2]);
        System.out.println("RE x "+c[3]);
    }
}
