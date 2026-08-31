import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String AnsS = "keyence";
        String s = sc.nextLine();

        boolean isAns = true;

        int i = 0;
        int j = 0;
        int checkCnt = 0;
        while (checkCnt < AnsS.length()) {
            if (s.charAt(i) == AnsS.charAt(i)) {
                i++;
            }
            else if (s.charAt(s.length() - j - 1) == AnsS.charAt(AnsS.length() - j - 1)) {
                j++;
            }
            else {
                isAns = false;
            }
            checkCnt++;
        }

        System.out.println(isAns ? "YES" : "NO");
    }
}
