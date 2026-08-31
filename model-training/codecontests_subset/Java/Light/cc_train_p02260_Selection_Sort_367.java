import java.util.*;
//import java.lang.Math;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int A[];
        A=new int[N];
        for(int i=0;i<N;i++) A[i]=sc.nextInt();
        int cnt=0;
        for(int i=0;i<N;i++){
            int mi=i;
            for(int j=i;j<N;j++) if(A[j]<A[mi]) mi=j;
            if(mi!=i) cnt++;
            int tmp=A[i];
            A[i]=A[mi];
            A[mi]=tmp;
        }
        for(int i=0;i<N;i++){
            System.out.print(A[i]);
            System.out.print(i==N-1?"\n":" ");
        }
        System.out.println(cnt);
        sc.close();
    }
}
