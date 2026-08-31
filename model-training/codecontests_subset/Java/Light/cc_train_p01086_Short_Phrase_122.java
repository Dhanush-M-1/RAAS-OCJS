import java.util.*;

public class Main {
    public static int[] goals = {5, 7, 5, 7, 7};
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int L = 31;
        
        while (true) {
            int W = sc.nextInt();
            if (W == 0) break;
            
            int[] arr = new int[W];
            
            for (int i = 0; i < W; i++) {
                arr[i] = sc.next().length();
            }
            
            for (int i = 0; i < W; i++) {
                if (isPossible(arr, i, 0, 0)) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
    
    public static boolean isPossible(int[] lens, int pos, int currLen, int goalPos) {
        if (goalPos >= 5) return true;
        if (currLen > goals[goalPos]) return false;
        if (currLen == goals[goalPos]) return isPossible(lens, pos, 0, goalPos + 1);
        return isPossible(lens, pos + 1, currLen + lens[pos], goalPos);
    }
}


