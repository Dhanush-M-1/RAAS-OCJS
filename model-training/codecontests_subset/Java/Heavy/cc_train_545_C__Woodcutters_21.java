import java.util.Scanner;

public class woodcutter {
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);

        int len = scan.nextInt();

        if(len<2){System.out.println(len); return;}

        int[][] nums = new int[len][2];
        boolean[] v = new boolean[len+1];

        for(int i = 0;i<len;i++){
            String s = scan.nextLine();
            if(s.length()==0){
                i--; continue;
            }
            String[] num = s.split("\\s+");

            if(num[0].length()>0){
               // System.out.println("here");
                nums[i][0] = Integer.parseInt(num[0]);
                nums[i][1] = Integer.parseInt(num[1]);
            }
        }

        scan.close();
        int res = 2;

        for(int i = 1;i<len-1;i++){
    
            int idx = nums[i][0];
            int l = nums[i][1];
            if((idx-l>nums[i-1][0] && !v[i-1]) || (idx-l>(nums[i-1][0]+nums[i-1][1]))){
                res++;
            }
            else if(idx+l<nums[i+1][0]){
                res++;
                v[i] = true;
            }
        }

        System.out.println(res);
    }
}