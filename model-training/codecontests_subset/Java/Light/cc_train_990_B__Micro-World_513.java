import java.util.*;

public class NewClass1 {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,k,i;
        n=sc.nextInt();
        k=sc.nextInt();
        int a[]=new int[n];
        TreeSet<Integer> tr=new TreeSet<>();
        for ( i=0;i<n;i++){
            a[i]=sc.nextInt();
            tr.add(a[i]);
        }
        int removed=0;
        for (i=0;i<n;i++){
            Integer x=tr.floor(a[i]+k);
            if (x > a[i] && (x <= a[i]+k)) removed++;
        }
        System.out.println(n-removed);


    }
}