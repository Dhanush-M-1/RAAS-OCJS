import java.util.*;
 
public class CodeForces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int t = scanner.nextInt();
        while ((t-- != 0)) {
            int n = scanner.nextInt();
            List<Integer> points = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                points.add(scanner.nextInt());    
            }
 
            System.out.print(solve(points));
        }
    }
 
    private static String solve(List<Integer> arr) {
        int maxIndex = arr.size()/2;
        if(arr.size() < 6){
            return "0 0 0\n";
        }
        
        while(maxIndex > 0 && Objects.equals(arr.get(maxIndex-1), arr.get(maxIndex))){
            maxIndex--;
        }
        if(maxIndex < 3)
            return "0 0 0\n";
        int[] ans = new int[3];
        int j=0;
        for(int i=0;i<maxIndex;i++){
            ans[j]++;
            if(j < 2 && !Objects.equals(arr.get(i), arr.get(i + 1))){
                if(j == 0) j++;
                else if(ans[j] > ans[j-1]){
                    j++;
                }
            }
        }
        // System.out.println(ans[0] +" "+ans[1]+" "+ans[2]);
        if((ans[0] == 0 || ans[1] == 0 || ans[2] == 0)
        || ans[0] >= ans[1] || ans[0] >= ans[2]){
            return "0 0 0\n";
        }
        return ans[0] +" "+ans[1]+" "+ans[2]+"\n";
    }
}