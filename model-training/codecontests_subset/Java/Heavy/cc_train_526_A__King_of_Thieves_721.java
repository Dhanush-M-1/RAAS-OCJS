import java.util.*;
import java.io.*;

public class CF_1237_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String s=sc.nextLine();
        int a[]=new int[1000];
        for(int i=0;i<n;i++)
            if(s.charAt(i)=='*')
                a[i]=1;
        
        for(int i=1;i<=n/4;i++)
            for(int j=0;j<n;j++)
                if(a[j]==1){
                    int flag=1;
                    for(int k=1;k<=4;k++){
                        if(a[j+k*i]==1)
                            continue;
                        else{
                            flag=0;
                            break;
                        }
                    }
                    if (flag==1){
                        System.out.println("yes");
                        return;
                    }
                }       
        System.out.println("no");
        return;
    }

}
