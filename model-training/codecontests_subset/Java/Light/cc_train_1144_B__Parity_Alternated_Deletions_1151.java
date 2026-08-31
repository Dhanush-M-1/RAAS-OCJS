import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ParityDeletions {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
            if(arr[i]%2==0){
                even.add(arr[i]);
            }else{
                odd.add(arr[i]);
            }
        }
        Collections.sort(even);
        Collections.sort(odd);
        long sum =0;
        if(even.size()-odd.size()-1>0){
            for(int i= 0 ;i<even.size()-odd.size()-1;i++){
                sum+=even.get(i);
            }
            System.out.println(sum);
        }else if(odd.size()-even.size()-1>0){
            for(int i=0;i<odd.size()-even.size()-1;i++){
                sum+=odd.get(i);
            }
            System.out.println(sum);
        }else{
            System.out.println(sum);
        }

    }
}
