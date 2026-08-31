import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0){
            int n = scan.nextInt(), m = scan.nextInt();
            String str = scan.next();
            int[] result = new int[26];
            int[] error =new int[m];
            for (int i = 0; i < m; i ++)
                error[i] = scan.nextInt();
            Arrays.sort(error);//2 2 3 8 9
            int last = 0;
            for (int i = 0; i < m; i ++){//m = 5
                for (int k = last; k < error[i]; k ++){//考虑 2 2
                    result[str.charAt(k) - 'a'] += m - i;
                    last = error[i];
                }
            }
            for (int i = 0; i < n; i ++)
                result[str.charAt(i) - 'a'] ++;
            for (int i : result)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
