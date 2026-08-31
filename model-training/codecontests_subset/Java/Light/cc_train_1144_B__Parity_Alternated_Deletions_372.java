import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author arabtech
 */
public class Nnn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> even=new ArrayList<Integer>();
        ArrayList<Integer> odd=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            int num=sc.nextInt();
            if(num%2==0){
                even.add(num);
            }
            else{
                odd.add(num);
            }
        }
        if(n%2==0&&even.size()==odd.size()){
            System.out.println(0);
        }
        else if(n%2==1&&Math.abs(even.size()-odd.size())==1){
            System.out.println(0);
        }
        else{
            int sum=0;
            if(odd.size()<even.size()){
                Collections.sort(even);
                for(int i=even.size()-odd.size()-2;i>=0;i--){
                    sum+=even.get(i);
                }
            }
            else{
                Collections.sort(odd);
                 for(int i=odd.size()-even.size()-2;i>=0;i--){
                    sum+=odd.get(i);
                }
            } 
            System.out.println(sum);
        }
    }
}
