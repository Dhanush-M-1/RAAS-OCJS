import java.util.*;

public class P1398A800 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int tests = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < tests; i++){
            int answer = -1;
            int len = Integer.parseInt(scan.nextLine());
            String[] nums = scan.nextLine().trim().split(" ");
            if(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]) <= Integer.parseInt(nums[len-1])){
                System.out.println("1 2 " + len);
            }
            else{
                System.out.println(-1);
            }
        }
    }
}
