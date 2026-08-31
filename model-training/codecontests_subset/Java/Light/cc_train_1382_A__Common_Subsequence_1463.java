import java.util.*;

public class Main {
    public static void main(String[] srgs) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            HashSet<Integer> set1=new HashSet<>();

            for (int i=0;i<n;i++){
                set1.add(sc.nextInt());
            }
            boolean flag=false;
            for (int j=0;j<m;j++){
                int val=sc.nextInt();
                if (set1.contains(val) && !flag){
                    flag=true;
                    System.out.println("YES");
                    System.out.println(1+" "+val);
                }
            }
            if (!flag) {
                System.out.println("NO");
            }
        }
    }
}