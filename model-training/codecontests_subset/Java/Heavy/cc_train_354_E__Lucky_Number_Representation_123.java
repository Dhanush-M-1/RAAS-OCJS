import java.util.*;
public class Main{
    public static void main(String[]args) {
        boolean[] used = new boolean[7*6+1];
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int[] vals = new int[6];
        for(vals[0] = 0; vals[0] < 3; vals[0]++) {
            for(vals[1] = 0; vals[1] < 3; vals[1]++) {
                for(vals[2] = 0; vals[2] < 3; vals[2]++) {
                    for(vals[3] = 0; vals[3] < 3; vals[3]++) {
                        for(vals[4] = 0; vals[4] < 3; vals[4]++) {
                            for(vals[5] = 0; vals[5] < 3; vals[5]++) {
                                int sum = 0;
                                for(int i = 0; i < 6; i++) {
                                    if(vals[i] == 1) sum += 4;
                                    else if(vals[i] == 2) sum += 7;
                                }
                                if(!used[sum]) {
                                    //System.out.println(sum);
                                    int[] nums = new int[6];
                                    for(int i = 0 ; i < 6; i++) {
                                        if(vals[i] == 1) nums[i] = 4;
                                        else if(vals[i] == 2) nums[i] = 7;
                                    }
                                    map.put(sum, nums);
                                    used[sum] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        //System.out.println(map);
        Scanner in = new Scanner(System.in);
        int inputs = in.nextInt();
        while(inputs--> 0 ){
            long a = in.nextLong();
        
            Stack<int[]> ret = new Stack<int[]>();
            if(!dfs(ret, a, map)) {
                System.out.println(-1);
            }
        }
    }
    
    
    public static boolean dfs(Stack<int[]> ret, long num,Map<Integer, int[]> map) {
        for(Integer key: map.keySet()) {
            if( key % 10 == num % 10 && num >= key) {
                long next = num-key;
                next = next / 10;
                if(next == 0) {
                    ret.push(map.get(key));
                    print(ret);
                    return true;
                } else {
                    ret.push(map.get(key));
                    if(dfs(ret, next, map)) {
                        return true;
                    }
                    ret.pop();
                }
            }
        }
        return false;
    }
    
    public static void print(Stack<int[]> ret) {
        long[] ans = new long[6];
        while(!ret.isEmpty()) {
            int[] next = ret.pop();
            for(int i =0 ; i < ans.length; i++) {
                ans[i] *= 10;
                ans[i] += next[i];
            }
        }
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        //AC
    }
}