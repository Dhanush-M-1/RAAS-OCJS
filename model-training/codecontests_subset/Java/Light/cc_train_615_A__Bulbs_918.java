import java.util.*;

public class Solution {

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();int m = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            for(int j=0;j<a;j++){
                set.add(sc.nextInt());
            }
        }
        if(set.size()==m){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    
}
