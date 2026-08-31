import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       int n=scanner.nextInt();
       int m=scanner.nextInt();
       String x=scanner.nextLine();
       boolean mark[]=new boolean[m];
       for (int i=0;i<n;i++){
            x=scanner.nextLine();
            String temp[]=x.split(" ");
            for (int j=1;j<temp.length;j++){
                mark[Integer.parseInt(temp[j])-1]=true;
            }
       }
       for (int i=0;i<m;i++){
           if (mark[i]==false){
               System.out.println("NO");
               return;
           }
       }
        System.out.println("YES");
    }
}