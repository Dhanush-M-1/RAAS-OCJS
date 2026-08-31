import java.util.Scanner;

public class Contest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        String y = sc.next();
        int n = sc.nextInt(),k=0;
        String u,z;
        String[] a = new String[2*n+2];
        a[k++] = x; a[k++] = y;
        for (int i = 0; i < n; i++) {
            u = sc.next(); z= sc.next();
            if(u.equals(x)){x=z;}
            else y=z;
             a[k++] = x; a[k++] = y;
        }
        for(int i=0;i<a.length;i+=2){
            System.out.println(a[i]+" "+a[i+1]);
        }
    }

}
