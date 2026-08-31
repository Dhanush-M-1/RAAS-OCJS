import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;
public class Main {
public static void main(String[] args){
Scanner sc = new Scanner(in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
int[] a=new int[n];
int[] b=new int[n];
int[] c=new int[m];
int[] d=new int[m];
    for (int i = 0; i < n; i++) {
        a[i]=Integer.parseInt(sc.next());
        b[i]=Integer.parseInt(sc.next());
    }
    for (int i = 0; i <m; i++) {
        c[i]=Integer.parseInt(sc.next());
        d[i]=Integer.parseInt(sc.next());
    }
    for (int i = 0; i < n; i++) {
    int min=200000000,s=0;
        for (int j = 0; j < m; j++) {
            int temp=abs(a[i]-c[j])+abs(b[i]-d[j]);
            if(temp<min){
            min=temp;
            s=j;
            }
        }
        out.println(s+1);
    }
}
}