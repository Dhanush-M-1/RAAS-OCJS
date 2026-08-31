import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t>0){
            t--;
            int k=scanner.nextInt();
            int n[]=new int[scanner.nextInt()];
            int m[]=new int [scanner.nextInt()];
            for(int i=0;i<n.length;i++) n[i]=scanner.nextInt();
            for(int i=0;i<m.length;i++) m[i]=scanner.nextInt();
            int i=0;
            int j=0;
            ArrayList<Integer> l=new ArrayList();
            while(i<n.length || j<m.length){
                if(i<n.length && n[i]<=k){
                    if(n[i]==0) k++;
                    l.add(n[i]);
                    i++;
                }
                else if( j<m.length &&m[j]<=k){
                    if(m[j]==0)k++;
                    l.add(m[j]);
                    j++;
                }
                else break;
            }
            if(i>=n.length && j>= m.length){
                for(int x:l)  System.out.println(x);
            }
            else System.out.println(-1);
        }
    }
}
