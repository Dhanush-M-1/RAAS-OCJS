import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Admin on 12/30/2014.
 */
public class CF_500_C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();
        int[] weights = new int[n];
        int[] bookOnDay = new int[m];
        for(int i = 0; i < n; i++){
            weights[i] = sc.nextInt();
        }
        for(int i = 0 ; i < m; i++){
            bookOnDay[i] = sc.nextInt()-1;
        }
        boolean[] placed = new boolean[n];
        int numPlaced = 0;
        ArrayList<Integer> stack = new ArrayList<Integer>(20000);
        for(int i = 0; i < m; i++){
            if(!placed[bookOnDay[i]]){
                stack.add(bookOnDay[i]);
                placed[bookOnDay[i]] = true;
                numPlaced++;
            }
            if(numPlaced == n){
                break;
            }
        }
        //System.out.println(stack.toString());
        int ans = 0;
        for(int i = 0; i < m; i++){
            //System.out.println(stack.toString());
            for(int j = 0; j < n; j++){
                if(stack.get(j) == bookOnDay[i]){
                    int temp = stack.remove(j);
                    stack.add(0, temp);
                    break;
                } else {
                    ans+=weights[stack.get(j)];
                }
            }
            //System.out.println(ans);
        }
        System.out.println(ans);
    }
}
