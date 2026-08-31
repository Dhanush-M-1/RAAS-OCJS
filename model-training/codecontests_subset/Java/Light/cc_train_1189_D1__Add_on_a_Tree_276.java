import java.util.*;

/**
 * Created by akashchaudhary on 7/5/19.
 */
public class Solution {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();

        int a[] = new int[100002];

        for(int i=0;i<length-1;i++){
            a[sc.nextInt()]++;
            a[sc.nextInt()]++;
        }

        boolean sol = true;

        for(int i=1;i<=length;i++){
            if(a[i]==2){
                sol = false;
            }
        }

        if(sol){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
