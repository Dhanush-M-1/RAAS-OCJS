import java.util.Scanner;

public class B {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String togramm = input.next();
        char [] s = togramm.toCharArray();
        int kmax=0;
        String ans ="";

        for (int i=0; i<s.length-1; i++) {
            int k=0;
            char s1 = s[i];
            char s2 = s[i+1];
            for (int j=0; j<s.length-1; j++) {
                if (s[j]==s1 && s[j+1]==s2) {
                    k++;
                }
            }

            if (k==s.length-1) {
                ans=s1+""+s2;
                System.out.println(ans);
                return;
            }

            if (k>kmax) {
                kmax=k; ans=s1+""+s2;
            }
        }

        System.out.println(ans);

    }
}