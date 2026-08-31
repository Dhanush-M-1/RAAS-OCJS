import java.util.Arrays;
import java.util.Scanner;
public class HelpfulMaths {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String exp = in.next();
        String[] nums = exp.split("[+]");
        int[] nb = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            nb[i]=Integer.parseInt(nums[i]);
        }
        Arrays.sort(nb);
         for(int i=0;i<nums.length;i++){
             if(i==nums.length-1){
                 System.out.println(nb[i]);
             }
             else{
             System.out.print(nb[i]+"+");}
         }
     }
}
