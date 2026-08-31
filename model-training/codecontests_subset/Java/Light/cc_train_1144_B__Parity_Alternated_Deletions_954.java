
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;


public class JavaApplication168<T> {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Vector<Integer> odd = new Vector();
        Vector<Integer> even = new Vector();
        int sum = 0;
        int index_odd =0 , index_even = 0;
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            sum += num;
            if(num % 2 != 0){
                odd.add(num);
            }else{
                even.add(num);
            }
        }
        
        
        Collections.sort(odd,Collections.reverseOrder());
        Collections.sort(even,Collections.reverseOrder());
        int k = Math.min(odd.size(), even.size());
        int rem = sum;
        for(int i=0; i<k; i++){
            rem -= odd.get(i);
        }
        for(int i=0; i<k; i++){
            rem -= even.get(i);
        }
        if(odd.size() > k){
            rem -= odd.get(k);
        }
        if(even.size() > k){
            rem -= even.get(k);
        }
        System.out.println(rem);
        
        
        
        
        

        
    }
}
