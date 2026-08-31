import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 0, b = 0, c = 0,d = 0;
        for(int i = 1; i <= n; i++) {
            String x = in.next();
            if(x.equals("AC")) a++;
            if(x.equals("TLE")) c++;
            if(x.equals("WA")) b++;
            if(x.equals("RE")) d++;
        }
        System.out.println("AC x " + a);
        System.out.println("WA x " + b);
        System.out.println("TLE x " + c);
        System.out.println("RE x " + d);
        in.close();
    }
}