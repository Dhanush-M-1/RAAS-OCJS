import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for(int i=0;i<n;i++){
            int temp = scanner.nextInt();
            if(temp%2 == 0){
                even.add(temp);
            }else {
                odd.add(temp);
            }
        }
        Collections.sort(even);
        Collections.sort(odd);
        int ans = findAns(even, odd);
        System.out.println(ans);

    }

    private static int findAns(ArrayList<Integer> even, ArrayList<Integer> odd) {
        int elen = even.size();
        int olen = odd.size();
        int diff = Math.abs(olen-elen);
        if(olen == elen || diff == 1)
            return 0;
        if(elen > olen){
           return getAns(even, diff);
        }
        else {
           return getAns(odd, diff);
        }

    }

    private static int getAns(ArrayList<Integer> odd, int elen) {

        int ans = 0;
        for(int i=0;i<elen-1;i++){
            ans = ans+odd.get(i);
        }
        return ans;
    }
}
