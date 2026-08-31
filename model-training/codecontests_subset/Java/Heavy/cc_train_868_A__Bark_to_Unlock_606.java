import java.util.Scanner;

public class Decode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine(), s1 = "", s2 = "", temp;
        String first = "", second = "";
        first += s.charAt(0); second += s.charAt(1);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
             temp = in.next();
             if(temp.equals(s)){
                 System.out.println("YES"); return;
             }
             s1 += temp.charAt(0);
             s2 += temp.charAt(1);
        }
        if(s2.contains(first) && s1.contains(second))
            System.out.println("YES");
        else System.out.println("NO");
    }
}