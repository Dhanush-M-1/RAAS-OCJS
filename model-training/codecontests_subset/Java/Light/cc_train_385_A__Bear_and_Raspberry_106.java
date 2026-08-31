import java.util.Scanner;

public class BearAndRasberry {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int ans =0;
        int n = ip.nextInt();
        int c = ip.nextInt();
        int prev = -1;
        for(int i=0;i<n;i++){
            int curr = ip.nextInt();
            if(prev==-1){
                prev=curr;
                continue;
            }
            int profit = prev - curr -c;
            ans = Math.max(ans,profit);
            prev = curr;
        }
        System.out.println(ans);
    }
}
