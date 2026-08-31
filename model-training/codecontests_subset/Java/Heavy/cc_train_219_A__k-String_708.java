import java.util.*;

public class Codeforces{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        char mas[] = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            mas[i] = s.charAt(i);
        }
        Arrays.sort(mas);
        int c = 1; boolean q = true;
        for (int i = 0; i < mas.length-1; i++) {
            if (mas[i]==mas[i+1]){
                c++;
            }
            else{
                if (c%n!=0){
                    q = false;
                    System.out.println(-1);
                    break;
                }c=1;
            }
        }
        if (q && c%n!=0)System.out.println(-1);
        else {
            if (q) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mas.length; i += n) {
                    sb.append(mas[i]);
                }
                StringBuilder answer = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    answer.append(sb.toString());
                }
                System.out.println(answer.toString());
            }
        }
    }
}