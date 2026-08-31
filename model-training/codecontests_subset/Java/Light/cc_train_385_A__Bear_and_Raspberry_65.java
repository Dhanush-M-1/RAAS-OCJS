import java.util.Scanner;
//abdxy
public class JavaApplication4 {

    public static void main(String[] args) {
      Scanner scan=new Scanner(System.in);
      int n=scan.nextInt();
      int m=scan.nextInt();
      int[] a=new int[n];

        for (int i = 0; i <n; i++) {
            a[i]=scan.nextInt();
        }
      int g=a[0]-a[1];int y=0;
        for (int i = 0; i <n-1; i++) {
            y=i+1;
            if((a[i]-a[y])>g)g=a[i]-a[y];
        
        }
        g-=m;
     if(g>0)System.out.println(g);
      else System.out.println(0);
      
    }}