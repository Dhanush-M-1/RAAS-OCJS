import java.util.Scanner;

public class ASerialKiller {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String n1=in.next();
        String n2=in.next();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            System.out.println(n1+" "+n2);
        String x=in.next();
        String y=in.next();
        if(n1.equals(x))
            n1=y.toString();
        else
            n2=y.toString();
        }
        System.out.println(n1+" "+n2);
    }
    
}
