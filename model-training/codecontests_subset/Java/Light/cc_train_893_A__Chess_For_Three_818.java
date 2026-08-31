import java.util.*;
import java.lang.*;
 
public class Solution{
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] score = new int[]{1,1,0};
        int index =0;
        boolean flag = true;
        for(int i=0;i<n;i++){
            int w=scan.nextInt();
            if(w==3&&i==0){flag=false;break;}
            if(i==0&&n==1){flag=true;break;}
            if(score[w-1]==-1){flag=false;break;}
            for(int k=0;k<3;k++){
                if((w-1!=k&&score[k]==0)||(w-1!=k&&score[k]==1)){score[w-1]=1;score[k]=-1;index=k;break;}
            }
            for(int k=0;k<3;k++){
                if(index!=k&&score[k]==-1){score[k]=0;}
            }

        }
        if(flag){System.out.println("YES");}
        else{System.out.println("NO");}
    }
}