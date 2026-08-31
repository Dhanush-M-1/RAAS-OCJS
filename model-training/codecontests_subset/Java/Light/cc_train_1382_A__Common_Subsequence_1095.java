import java.util.*;
public class div2_658_A {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0){
            int n=scan.nextInt();
            int m=scan.nextInt();
            List<Integer> a=new ArrayList<>();
            int result=0;
            for (int i = 0; i < n; i++) 
                a.add(scan.nextInt());
            for (int i = 0; i < m; i++){
                int temp=scan.nextInt();
                if (a.contains(temp))
                    result=temp;
            }
            if(result>0)
                System.out.println("YES\n"+1+" "+result);
            else
                System.out.println("NO");
        }
    }
}