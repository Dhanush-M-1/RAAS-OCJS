import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int a[]=new int[m+1];
        for(int i=0;i<n;i++){
            int x=s.nextInt();
            a[x]++;
        }
        int possible=0;
        for(int i=1;i<m;i++){
            for(int j=i+1;j<=m;j++){
                possible=possible+a[i]*a[j];
            }
        }
        
        System.out.println(possible);
        
    
    }
    
    
}
