import java.util.Arrays;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws java.lang.Exception{
	// write your code here
        // Input
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] nums = new int[(s.length()/2)+1];
        int index = 0;
        for (char c : s.toCharArray()) {
            if (c != '+') {
                nums[index] = Character.getNumericValue(c);
                index++;
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            System.out.print(nums[i]+"+");
        }
        System.out.print(nums[nums.length-1]);
        }
    }
