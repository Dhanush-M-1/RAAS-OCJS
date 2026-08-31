import java.util.*;

class Main{
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        int N=sc.nextInt(),M=sc.nextInt(),a[]=new int[N],b[]=new int[N],c[]=new int[M],d[]=new int[M];
        for(int i=0;i<N;i++){
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
        }
        for(int i=0;i<M;i++){
            c[i]=sc.nextInt();
            d[i]=sc.nextInt();
        }
        for(int i=0;i<N;i++){
            Pair dis = new Pair(-1,Integer.MAX_VALUE);
            for(int j=0;j<M;j++){
                int e=Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]);
                if(dis.b>e){
                    dis.a=j;
                    dis.b=e;
                }
            }
            System.out.println(dis.a+1);
        }
    }
}
class Pair{
    int a,b;
    public Pair(int a,int b){
        this.a=a;
        this.b=b;
    }
}
