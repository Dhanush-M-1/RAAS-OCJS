import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] p = new int[N+1];
        for(int i=1;i<=N;i++){
            p[i] = sc.nextInt();
        }
        int left =  1;
        int ans = 0;
        while(left<=N){
            if(p[left]!=left) left++;
            else{
                int right = left;
                while(right<=N&&p[right]==right) right++;
                ans += (right-left+1)/2;
                left = right;
            }
        }
        System.out.println(ans);
    }
}
