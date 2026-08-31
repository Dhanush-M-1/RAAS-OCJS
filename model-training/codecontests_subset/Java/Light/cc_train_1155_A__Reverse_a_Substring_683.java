import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i)>str.charAt(i+1)) {
                System.out.println("YES");
                System.out.println((i+1)+" "+(i+2));
                System.exit(0);
            }
        }
        System.out.println("NO");
        sc.close();
    }
}