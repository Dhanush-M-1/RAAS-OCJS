import java.util.Scanner;

public class JavaApplication250 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();int m=sc.nextInt();
        int[] a = new int[m+1];sc.nextLine();
        for(int i=0;i<n;i++){
            
            String s = sc.nextLine();
            String[] t = s.split(" ");            
            for(int j=1;j<=Integer.parseInt(t[0]);j++){
               int b= Integer.parseInt(t[j]);
               a[b]++;
            }
            
        }
        int b=0;
        for(int i=1;i<=m;i++){
            if(a[i]>0) b++;
        }
        
        if(b==m) System.out.println("YES");
        else System.out.println("NO");
    }
    
}
