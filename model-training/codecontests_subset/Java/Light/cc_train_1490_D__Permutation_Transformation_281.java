import java.util.*;

public class Permutation_Transformation {
    public static void main(String[] args) throws java.lang.Exception{
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i=0;i<t;i++){
            int n = input.nextInt();
            int[] nums = new int[n];
            for(int j=0;j<n;j++){
                nums[j] = input.nextInt();
            }
            int[] depths = new int[n];
            build(nums,depths,0,n-1,0);
            for(int j=0;j<n;j++){
                System.out.print(depths[j]+" ");
            }
            System.out.println();
        }
    }

    public static void build(int[] nums,int[] depths, int a, int b, int depth){
        if(a>b){
            return;
        }
        if(a==b){
            depths[a] = depth;
            return;
        }
        int max = a;
        for(int i=a;i<=b;i++){
            if(nums[i]>nums[max]){
                max = i;
            }
        }
        depths[max] = depth;
        build(nums, depths, a, max-1, depth+1);
        build(nums, depths, max+1, b, depth+1);
    }
}
