//  NetBeans IDE Default License
import java.util.*;

public class SerialKiller {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String i1=scan.next(),i2=scan.next();
        System.out.println(i1+" "+i2);
        int n=scan.nextInt();
        String[][] a=new String[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=scan.next();
            a[i][1]=scan.next();
            if(a[i][0].equals(i1))
                i1=a[i][1];
            else i2=a[i][1];
            System.out.println(i1+" "+i2);
        }
    }
}