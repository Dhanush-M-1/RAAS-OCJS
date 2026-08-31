import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Recovery {
    static class Operator {
        int oper, l_idx, r_idx, param;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        boolean violated = false;
        
        List<Operator> operators = new LinkedList<Operator>();
        
        int[] upper_bounds = new int[n];
        for (int i = 0; i < upper_bounds.length; i++)
            upper_bounds[i] = Integer.MAX_VALUE;
        
        int[] increments = new int[n];
        for (int oper_idx = 0; oper_idx < k; oper_idx++) {
            int oper = sc.nextInt();
            int l_idx = sc.nextInt();
            int r_idx = sc.nextInt();
            int param = sc.nextInt();
            Operator list_oper = new Operator();
            list_oper.oper = oper;
            list_oper.l_idx = l_idx;
            list_oper.r_idx = r_idx;
            list_oper.param = param;
            operators.add(list_oper);
            
            if (oper == 1) {
                for (int i = l_idx - 1; i < r_idx; i++) {
                    increments[i] += param;
                }
            } else {
                for (int i = l_idx - 1; i < r_idx; i++) {
                    upper_bounds[i] = Math.min(upper_bounds[i], param - increments[i]);
                }               
            }
        }
        
        for (int i = 0; i < upper_bounds.length; i++)
            if (upper_bounds[i] == Integer.MAX_VALUE)
                upper_bounds[i] = 0;
        
        int[] test_bounds = upper_bounds.clone();
        for (Operator replay : operators) {
            int oper = replay.oper;
            int l_idx = replay.l_idx;
            int r_idx = replay.r_idx;
            int param = replay.param;
            
            if (oper == 1) {
                for (int i = l_idx - 1; i < r_idx; i++) {
                    test_bounds[i] += param;
                }
            } else {
                boolean found = false;
                for (int i = l_idx - 1; i < r_idx; i++) {
                    if (test_bounds[i] == param) {
                        found = true;
                        break;
                    }
                }               
                if (!found) {
                    violated = true;
                    break;
                }
            }
        }
        
        if (violated) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            for (int i = 0; i < upper_bounds.length - 1; i++) {
                System.out.print(upper_bounds[i] + " ");
            }
            System.out.println(upper_bounds[upper_bounds.length - 1]);
        }
    
    }
}
