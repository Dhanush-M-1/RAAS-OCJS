import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        int weights = in.nextInt();
        int days = in.nextInt();
        int[] weightsArr= new int[weights];
        int[] daysArr = new int[days];
        for(int i = 0; i < weights; i++){
            weightsArr[i] = in.nextInt();
        }
        ArrayList<Integer> initialConfig = new ArrayList<Integer>(weights);
        
        for(int i = 0 ; i < days; i++){
            daysArr[i] = in.nextInt();
            if(!initialConfig.contains(daysArr[i])){
                initialConfig.add(daysArr[i]);
            }
        }
        for(int i = 0;i < weights; i++){
            if(!initialConfig.contains(weightsArr[i]))
                initialConfig.add(i);
        }
        
        Collections.reverse(initialConfig);
        
        Stack<Integer> s = new Stack<Integer>();
        for (Integer integer : initialConfig) {
            s.push(integer);
        }
        
        //Calculate 
        int cost = 0;
        ArrayList<Integer> tmp;
        for(int i = 0; i < days; i++){
            tmp = new ArrayList<Integer>();
            int cur = s.peek();
            while(cur != daysArr[i]){
                cost += weightsArr[s.peek() - 1];
                tmp.add(s.pop());
                cur = s.peek();
            }
            s.pop();
            Collections.reverse(tmp);
            for(Integer integer: tmp){
                s.push(integer);
            }
            s.push(daysArr[i]);
        }
        
        
        System.out.println(cost);   
    }

}