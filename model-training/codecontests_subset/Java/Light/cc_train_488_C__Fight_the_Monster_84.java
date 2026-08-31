import java.util.Scanner;


public class C27 {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int h1=sc.nextInt();
        int a1=sc.nextInt();
        int d1=sc.nextInt();
        int h2=sc.nextInt();
        int a2=sc.nextInt();
        int d2=sc.nextInt();
        int h=sc.nextInt();
        int a=sc.nextInt();
        int d=sc.nextInt();
        int m=Integer.MAX_VALUE;
        for (int i=0;i<1000;i++)
            for (int j=0;j<1000;j++){
                int l=0;
                int u=100000;
                while (u-l>5){
                    int mid =(l+u)/2;
                    if (can(h1+mid,a1+i,d1+j,h2,a2,d2)){
                        u=mid;
                        m=Math.min(mid*h+i*a+j*d,m);
                    }
                    else l=mid;
                }
                for (int k=l;k<=u;k++){
                    if (can(h1+k,a1+i,d1+j,h2,a2,d2)){
                        m=Math.min(k*h+i*a+j*d,m);
                    }
                }
            }
                
                
   System.out.print(m);
    }

    private static boolean can(int Hy, int Ay, int Dy, int Hm, int Am, int Dm) {
        if (Ay<=Dm)return false;
        if (Am<=Dy){
            return true;
        }
        int h=Hm;
        while (true){
            if (Hy>0 && h<=0)return true;
            if (Hy<=0)return false;
            h-=Math.max(0,Ay-Dm);
            Hy-=Math.max(0,Am-Dy);
        }
    }
    }


