import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(canObtain(str) ? "YES" : "NO");
    }

    public static boolean canObtain(String str) {
        String keyence = "keyence";
        if (str.substring(0, keyence.length()).equals(keyence)
                || str.substring(str.length()-keyence.length()).equals(keyence)) {
            return true;
        }
        for (int leftChunkSize = 1; leftChunkSize < keyence.length(); leftChunkSize++) {
            String constructedStr = str.substring(0, leftChunkSize)
                    + str.substring(str.length() - keyence.length() + leftChunkSize);
            if (constructedStr.equals(keyence)) {
                return true;
            }
        }
        return false;
    }
}
