import java.util.*;
public class qd{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int n4=n/4;
        boolean a[][]=new boolean[n][n];
        for(int i=0;i<n;i++){
            String s=sc.next();
            for(int j=0;j<n4;j++){
                int x=0;
                 if(s.charAt(j)>='A'){
                     x=s.charAt(j)-55;
                 }
                 else x=s.charAt(j)-48;
                for(int k=0;k<4;k++){
                    a[i][j*4+k]=((x>>(3-k))&1)==1?true:false;
                }
            }
        }
        ArrayList<Integer> al=new ArrayList<Integer>();
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                al.add(i);
                if(i*i!=n)al.add(n/i);
            }
        }
        Collections.sort(al,(n1,n2)->n2-n1);
        short row[][]=new short[n][n];
        short col[][]=new short[n][n];
        short tot[][]=new short[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                row[i][j]=1;
                col[i][j]=1;
                tot[i][j]=1;
                if(j>0 &&a[i][j]==a[i][j-1])
                    col[i][j]+=col[i][j-1];
                if(i>0 &&a[i][j]==a[i-1][j])
                    row[i][j]+=row[i-1][j];
                if(i>0 && j>0 &&a[i][j]==a[i-1][j-1] &&a[i][j]==a[i][j-1] && a[i][j]==a[i-1][j])
                   tot[i][j]+=Math.min(col[i][j-1],Math.min(row[i-1][j],tot[i-1][j-1]));   
            }
            
        }
        int ans=0;
        l2:for(int x:al){
            boolean flag=true;
            for(int i=x-1;i<n;i=i+x){
                for(int j=x-1;j<n;j=j+x){
                     if(tot[i][j]<x){
                         flag=false;
                        continue l2;
                     }
                }
            }
            ans=x;
            break;
        }
        System.out.println(ans);
    }
    
}