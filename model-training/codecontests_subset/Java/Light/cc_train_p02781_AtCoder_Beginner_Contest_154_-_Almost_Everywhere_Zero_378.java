import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int k = sc.nextInt();

        int digits = n.length();

        int[] digit = new int[digits];
        int second = 0;
        int third = 0;
        long ans = 0;

        for(int i = 0 ; i < digits ; i++){
            digit[i] = Integer.valueOf(n.substring(i, i+1));
            if(i > 0 && digit[i] > 0){
                if(second == 0) {
                    second = i;
                }else if(third == 0){
                    third = i;
                }
            }
        }

        System.out.println(count(n, k));
    }

    static long count(String n, int k){
        int digits = n.length();

        int[] digit = new int[digits];
        int second = -1;

        long ans = 0;

        for(int i = 0 ; i < digits ; i++){
            digit[i] = Integer.valueOf(n.substring(i, i+1));
            if(i > 0 && digit[i] > 0){
                if(second == -1) {
                    second = i;
                }
            }
        }

        if(k == 1){
            return 9*(digits-1) + digit[0];
        }else if(k == 2){
            ans += 81 * (digits - 2) * (digits - 1) / 2;
            ans += 9 * (digits - 1) * (digit[0] - 1);
            if(second != -1) {
                return (ans + count(n.substring(second, digits), k - 1));
            }else{
                return (ans);
            }
        }else{
            ans += 729 * (digits - 3) * (digits - 2) * (digits - 1) / 6;
            ans += 81 * (digits - 2) * (digits - 1) * (digit[0] - 1) / 2;
            if(second != -1) {
                return (ans + count(n.substring(second, digits), k - 1));
            }else{
                return(ans);
            }
        }
    }
}