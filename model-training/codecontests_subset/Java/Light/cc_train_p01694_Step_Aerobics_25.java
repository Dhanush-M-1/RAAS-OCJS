import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        solve2582();
    }

    public static void solve2582() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            if(n == 0){
                break;
            }
            String[] step = new String[n];
            for (int i = 0; i < n; i++){
                step[i] = sc.next();
            }
            int ans = 0;
            n = n % 2 == 0 ? n : n-1;
            for(int i = 0;i < n; i = i + 2){
                if(step[i].charAt(0) != step[i+1].charAt(0)){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}