import java.util.*;
public class JavaApplication10 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        int n1,n2,n3,n4;
        
        int sum = r1+r2+c1+c2+d1+d2;
        if(sum%3==0){
        n1 = (c1 + r1 + d1 - (sum/3)) / 2;
        n2 = r1 - n1;
        n3 = c1 - n1;
        n4 = d1 - n1;
        if(n1!=n2 && n2!= n3 && n3!= n4 && n1>0&&n2>0&&n3>0&&n4>0 && n1<10 && n2<10&&n3<10 &&n4<10 && n1!=n3 && n1!=n4 && n2!= n4){
        System.out.println(n1+ " " +n2);
        System.out.println(n3+ " "+n4);
        } else{
            System.out.println(-1);
        }
        
    }   else
            System.out.println("-1");}
}

