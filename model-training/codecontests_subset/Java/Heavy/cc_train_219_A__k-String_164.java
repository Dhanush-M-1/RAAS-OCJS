import java.util.*;
public class Sample {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int n = str.length();
        String uniqueStr = getUniqueString(str);
        String finalStr = "";
        if(uniqueStr.length() > (n / k)) {
            finalStr += "-1";
        } else {
            int countEachChar[] = new int[uniqueStr.length()];
            int count2 = 0;
            for(int i = 0; i < uniqueStr.length(); i++) {
                countEachChar[i] = getCharCount(str, uniqueStr.charAt(i));
                if(countEachChar[i] % k == 0) {
                    count2 += countEachChar[i] / k;
                } else {
                    finalStr += "-1";
                    break;
                }
            }
            if(count2 == (n / k)) {
                String onePart = "";
                for(int i = 0; i < countEachChar.length; i++) {
                    for(int j = 0; j < countEachChar[i] / k; j++) {
                        onePart += Character.toString(uniqueStr.charAt(i));
                    }
                }
                for(int i = 0; i < k; i++) {
                    finalStr = finalStr + onePart;
                }
            }
        }
        System.out.println(finalStr);
    }
    public static String getUniqueString(String str) {
        String st = "";
        for(int i = 0; i < str.length(); i++) {
            if(st.indexOf(str.charAt(i)) == -1) {
                st += Character.toString(str.charAt(i));
            }
        }
        return st;
    }
    public static int getCharCount(String str, char ch) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(ch == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}