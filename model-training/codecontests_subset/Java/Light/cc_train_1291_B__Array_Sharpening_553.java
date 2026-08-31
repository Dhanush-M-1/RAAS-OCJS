import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(new BufferedInputStream(System.in));
        int v=sc.nextInt();
        while(v-->0){
            int a=sc.nextInt();
            int b[]=new int[a];
            int c[]=new int[a];
            for(int i=0;i<a;i++){
                b[i]=sc.nextInt();
                if(i<a/2)
                    c[i]=i;
                else
                    c[i]=a-i-1;
            }
            if(a%2==1){
                int flag=0;
                for(int i=0;i<a;i++){
                    if(c[i]>b[i])
                        flag++;
                }
                if(flag==0)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }else{
                int flag1=0;
                int flag2=0;
                c[a/2-1]++;
                for(int i=0;i<a;i++){
                    if(c[i]>b[i])
                        flag1++;
                }
                c[a/2-1]--;
                c[a/2]++;
                for(int i=0;i<a;i++){
                    if(c[i]>b[i])
                        flag2++;
                }
                if(flag2==0||flag1==0)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }

    }
}
