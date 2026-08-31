import java.util.*;

public class Main{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] s = new int[15];
    int[] h = new int[15];
    int[] c = new int[15];
    int[] d = new int[15];
    String egara;
    int figure;
   for(int i=0;i<15;i++){
       s[i]=0;
       h[i]=0;
       c[i]=0;
       d[i]=0;
   }
   for(int i=0;i<n;i++){
       egara=sc.next();
       figure=sc.nextInt();
       if(egara.equals("S")) s[figure]=1;
       else if(egara.equals("H")) h[figure]=1;
       else if(egara.equals("C")) c[figure]=1;
       else if(egara.equals("D")) d[figure]=1;
   }
   for(int i=1;i<14;i++){
       if(s[i]==0) System.out.println("S "+i);
   }
   for(int i=1;i<14;i++){
    if(h[i]==0) System.out.println("H "+i);
}
for(int i=1;i<14;i++){
    if(c[i]==0) System.out.println("C "+i);
}
for(int i=1;i<14;i++){
    if(d[i]==0) System.out.println("D "+i);
}
}
}
