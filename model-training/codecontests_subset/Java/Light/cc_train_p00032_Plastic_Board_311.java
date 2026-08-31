import java.util.*;
public class Main{
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt1= 0;
        int cnt2= 0;int a,b,c;
        while(sc.hasNext()){
            String[] mm = sc.nextLine().split(",");
            a = Integer.parseInt(mm[0]); b = Integer.parseInt(mm[1]); c = Integer.parseInt(mm[2]);
            cnt1 += c*c==a*a+b*b?1:0;
            cnt2 += a==b?1:0;
        }
        System.out.println(cnt1);System.out.println(cnt2);
    }
}