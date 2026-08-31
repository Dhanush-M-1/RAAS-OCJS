import java.util.Scanner;
public class p1421B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = sc.nextInt(); t-- > 0;) {
            int n = sc.nextInt(), c = 0;
            char a[][] = new char[n][n];
            for(int i=0;i<n;i++) a[i]=sc.next().toCharArray();
            String s = "", s2 = "";
            int x[] = {a[0][1]-'0', a[1][0]-'0', a[n - 2][n - 1]-'0', a[n - 1][n - 2]-'0'};
            if(x[0]==x[1]&&x[1]==x[2]&&x[2]==x[3]) {c=2; s="1 2"; s2="2 1";}
            else if(x[0]+x[1]==x[2]+x[3]) {c=2; s="2 1"; if(x[1]==x[2]) s2= n+" "+(n-1); else s2=(n-1)+" "+n;}
            else if(x[0]!=x[1]) {c=1; if(x[0]==x[3]) s="1 2"; else s="2 1";}
            else if(x[2]!=x[3]) {c=1; if(x[2]==x[0]) s=(n-1)+" "+n; else s=n+" "+(n-1);}
            System.out.println(c);
            if(s!="") System.out.println(s);
            if(s2!="") System.out.println(s2);
        }   
    }
}