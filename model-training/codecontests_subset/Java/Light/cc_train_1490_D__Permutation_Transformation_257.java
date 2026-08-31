import java.util.Arrays;
import java.util.Scanner;

public class Main{

    static int[] nums;
    static int[] cntS;

     public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t --> 0){
        int n = sc.nextInt();
        nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }

        cntS = new int[n];
        dfs(0,n-1,0);
        Arrays.stream(cntS).forEach(a -> System.out.print(a+ " "));
        System.out.println();
    }
    }

    public static void dfs(int l, int r, int cnt) {
        
        if(l>r){
            return;
        }

        Arrays.fill(cntS,l,r+1,cnt);

        int maxPost = l;

        for(int i = l; i<=r;i++){
            if(nums[maxPost] < nums[i]){
                maxPost=i;
            } 
        }

        dfs(l, maxPost-1, cnt+1);
        dfs(maxPost+1,r, cnt+1);


    }

}