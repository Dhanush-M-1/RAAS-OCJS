import java.util.Scanner;
public class Test {
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        String str = myObj.nextLine();
        String[] arr = str.split(" ");
        int candles = Integer.parseInt(arr[0]);
        int cnt = 0;
        int d = Integer.parseInt(arr[1]);
        int ans = 0;
        while (candles >= 1){
            ans++;
            candles--;
            cnt++;
            if (cnt == d){
                cnt = 0;
                candles++;
            }
        }
        System.out.println(ans);
    }
}
