import java.util.Scanner;

public class A_526 {
    public static void main(String[] args) {
        int n,m=0,kt=0;
        String s;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        s=sc.next();
        char[] a=s.toCharArray();
        while(m<n) {
            if(a[m]=='*' ){
                for(int i=1;i<n;i++)
                    if(m+i*4<n)
                        if(a[m+i]=='*' && a[m+i*2]=='*' && a[m+i*3]=='*' && a[m+i*4]=='*' ){
                            System.out.println("yes");
                            kt=1;
                            break;
                        }
            }
            if(kt==1) break;
            m++;
            
        }
        if(kt==0)
        System.out.println("no");
        
        
    }
}