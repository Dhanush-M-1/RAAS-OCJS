import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int[] a,b;
        a = new int[101];
        b = new int[101];
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i,j,t,now=111,co=0,nowt=-1;
        for(i=0;i<n;i++)a[i] = s.nextInt();
        for(i=0;i<n;i++){
            for(j=i;j<n;j++){
                if(now>a[j]){
                    now=a[j];
                    nowt = j;
                }
            }
            if(a[i]!=now&&nowt>=0){
                t = a[nowt];
                a[nowt] = a[i];
                a[i]=t;
                co++;
            }
            now=111;
        }
        for(i=0;i<n;i++){
            if(i==0)System.out.print(a[i]);
            else System.out.print(" "+a[i]);
        }
        System.out.println();
        System.out.println(co);


    }
}
