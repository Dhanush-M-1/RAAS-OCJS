import java.util.Scanner;
public class p1466C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        for(int t=sc.nextInt();t-->0;) {
            char c[]=sc.next().toCharArray();
            int n=c.length,z=0;
            char x='0';
            for(int i=0;i<n-1;i++) {
                if(i+2<n && c[i]==c[i+2]) {
                    c[i+2]=x++;
                    z++;
                }
                if(x=='9') x='0';
                if(c[i]==c[i+1]) {
                    c[i+1]=x++;
                    z++;
                }
                if(x=='9') x='0';
            }
            System.out.println(z);
        }
    }
}
