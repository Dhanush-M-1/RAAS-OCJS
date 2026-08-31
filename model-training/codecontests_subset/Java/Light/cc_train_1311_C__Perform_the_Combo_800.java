import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            String s = sc.next();
            HashMap<Integer,long[]> hm = new HashMap<>();
            long c[] = new long[26];
            for(int i=0;i<n;i++){
                c[s.charAt(i)-'a']++;
                long q[] = new long[26];
                for(int j=0;j<26;j++)   q[j]=c[j];
                hm.put(i+1,q);
            }
            long a[] = new long[26];
            for(int i=0;i<m;i++){
                long x[] = hm.get(sc.nextInt());
                for(int j=0;j<26;j++)   a[j]+=x[j];
            }
            for(int i=0;i<26;i++)   a[i]+=c[i];
            for(int i=0;i<26;i++)   System.out.print(a[i]+" ");
            System.out.println();
        }
    }
}