import java.util.Scanner;

public class ReverseSubStringA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        String s = sc.next();
        char previous = s.charAt(0);
        char current;
        for (int i = 1; i < s.length() ; i++) {
            current = s.charAt(i);
            if(current<previous){
                System.out.println("YES");
                System.out.println(""+i+" "+(i+1));
                return;
            }
            previous=current;
        }
        System.out.println("NO");
    }
}
