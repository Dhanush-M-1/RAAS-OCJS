import java.util.*;
public class Q519B{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sa=0,sb=0,c=0;
        for(int i =0 ;i<n;i++){
            sa = sa+sc.nextLong();
        }
        for(int i = 0 ;i<n-1;i++)
            sb = sb+sc.nextLong();
        for(int i =0 ;i<n-2;i++)
            c+=sc.nextLong();
        System.out.println(sa-sb);
        System.out.println(sb-c);
    }
}
