import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int K = sc.nextInt();
        System.out.println(cnt(N, K));

    }

    private static long cnt(String N, int K){
        if(N.length() == 0){return 0;}
        if(N.charAt(0) == '0'){
            return cnt(N.substring(1), K);
        }
        if(K == 0){
            return 0;
        }
        if(K == 1){
            if(N.length() == 1){
                return (N.charAt(0)-'0');
            }else {
                return (N.length() - 1) * 9 + (N.charAt(0) - '0');
            }
        }
        if(N.length() < K){
            return 0;
        }
        long res=0;
        res = cnt(N.substring(1), K-1);
        res += (N.charAt(0)-'0'-1) * cnt(nines(N.length()-1), K-1);
        res += cnt(nines(N.length()-1), K);
        return res;
    }

    private static String nines(int k){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<k;i++){
            sb.append('9');
        }
        return sb.toString();
    }
}
