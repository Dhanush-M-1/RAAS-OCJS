import java.util.Scanner;

public class Games {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int count=0;
        int a[][]=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=s.nextInt();
            a[i][1]=s.nextInt();
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(a[i][0]==a[j][1]){
                    count++;
                }
                if(a[i][1]==a[j][0]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
