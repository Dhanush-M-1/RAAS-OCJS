import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    void run(){
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        int s = kb.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i =0; i<n; i++){
            arr.add(kb.nextInt());
        }
        if(n == 1){
            System.out.println(Math.abs(arr.get(0)-s));
            return;
        }

        Collections.sort(arr);

        int curr = arr.get(n/2);


        BigInteger  ans =  BigInteger.ZERO;
        if(curr == s){
            System.out.println(0);
            //System.out.println("het");
            return;
        }else if(curr < s){
            //System.out.println("het1");
            //System.out.println(Arrays.toString(arr.toArray()));
            for(int j = n/2; j<n; j++){
                //System.out.println(j);
                int v = arr.get(j);
                if(s <= v){
                    break;
                } else{
                    ans = ans.add(BigInteger.valueOf(Math.abs(v - s)));
                }
            }
        } else{ // curr > s
            //System.out.println("het2");
            for(int j = n/2; j>=0; j--){
                int v = arr.get(j);
                if(s >= v){
                    break;
                } else{
                    ans = ans.add(BigInteger.valueOf(Math.abs(v - s)));
                }
            }
        }

        System.out.println(ans);

    }
    public static void main(String[] args) {
        new Main().run();
    }
}
