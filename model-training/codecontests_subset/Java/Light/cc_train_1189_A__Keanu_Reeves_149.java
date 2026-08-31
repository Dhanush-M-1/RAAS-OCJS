import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();

        int n0 = 0, n1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                n0++;
            } else {
                n1++;
            }
        }
        if(n0 != n1){
            System.out.println(1);
            System.out.println(s);
        }else{
            System.out.println(2);
            System.out.println(s.substring(0, 1) + " " + s.substring(1, n));
        }

    }
}