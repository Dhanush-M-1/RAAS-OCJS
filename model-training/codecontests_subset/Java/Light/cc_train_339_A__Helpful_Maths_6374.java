import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class sol{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        sc.close();
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0;i<inputString.length();i++){
            if(inputString.charAt(i) != '+'){
                nums.add(Integer.parseInt(String.valueOf(inputString.charAt(i))));
            }
        }
        Collections.sort(nums);
        System.out.print(nums.get(0));
        for(int j=1;j<nums.size();j++){
            System.out.print("+" + nums.get(j));
        }
    }
}