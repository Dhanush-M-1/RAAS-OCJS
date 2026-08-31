import java.util.*;
public class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            HashSet<Integer> set = new HashSet<Integer>();
            for(int i = 0 ; i < n1 ; i++){
                int x = sc.nextInt();
                set.add(x);
            }
            Boolean flag = false;
            for(int i = 0 ; i < n2 ; i++){
                int x = sc.nextInt();
                if(set.contains(x)&& (!flag)){
                    System.out.println("YES");
                    System.out.println("1 "+x);
                    flag = true;
                }
            }
            if(!flag)
                System.out.println("NO");
        }
    }
}