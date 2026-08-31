import java.util.Scanner;
public class Codeforces_778A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        parts = sc.nextLine().split(" ");
        System.out.println(parts[0] + " " + parts[1]);
        int a = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < a; i++) { 
            String input = sc.nextLine(); 
            String newparts[] = input.split(" ");
            if (newparts.length >= 2) {
                checkStatus(newparts[0], newparts[1]);
            }
        }
    }
    public static String[] parts = new String[2];
    public static void checkStatus(String a, String b) {
        if (parts[0].equals(a)) {
            a = parts[1];
        } else if (parts[0].equals(b)) {
            b = parts[1];
        } else if (parts[1].equals(a)) {
            a = parts[0];
        } else {
            b = parts[0];
        }
        parts[0] = a;
        parts[1] = b;
        System.out.println(a + " " + b);
    }
}