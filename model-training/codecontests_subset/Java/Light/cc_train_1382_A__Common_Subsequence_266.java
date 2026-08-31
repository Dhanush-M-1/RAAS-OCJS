import java.util.*;
public class solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for(int i =0;i<n;i++){
                a[i] = sc.nextInt();
            }
            for(int i =0;i<m;i++){
                b[i] = sc.nextInt();
            }
            int element  = -234235;
            Arrays.sort(a);
            Arrays.sort(b);
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(a[i] == b[j]){
                        element = a[i];
                        break;
                    }else if(a[i]<b[j]) break;
                }
                if(a[i] == element) break;
            }
            if(element != -234235){
                System.out.println("YES");
                System.out.println("1 "+element);
            }else System.out.println("NO");
        }
    }
}