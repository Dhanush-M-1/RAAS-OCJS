import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long toCheck = (long) Math.sqrt(x);
        long max = 1; long min = 1;
        for(int i=1;i<=toCheck;i++){
            if(x%i==0){
                long num2 = x/i;
                if(hcf(i,num2)==1){
                    max = num2;min=i;
                }
            }
        }
        System.out.println(max + " "+min);
    }

    private static long hcf(long i, long num2) {
        if(num2==0) return i;
        return hcf(num2,i%num2);
    }
}
