import java.util.Scanner;

public class Main {
    public static void main (String[] args)  {
        Scanner scan = new Scanner(System.in);
        int n, ans = 0, mx = -1, tmp, sum = 0 ;
        n =  scan.nextInt();
        for(int i  = 0 ; i < n ; i++ ) {
            tmp = scan.nextInt();
            sum += tmp;
           mx = Math.max(mx, tmp);
        }
        ans = Math.max( (int)Math.ceil(2*(sum*1.0)/n) , mx);
        if(n*ans - sum <= sum)
            ans++;
        System.out.print(ans);

    }
}