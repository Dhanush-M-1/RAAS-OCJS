import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int length=200000;
        char[][] ans=new char[length][n];
        int count=0;
        int oldcount=1;
        ans[0][0]='a';
        char[] usedhigh=new char[length];
        char tmphigh;
        for(int i=0;i<length;i++){
            usedhigh[i]='a';
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<oldcount;j++){
                ans[j][i]='a';
                tmphigh=usedhigh[j];
                for(int k=98;k<tmphigh+2;k++){
                    count++;
                    for(int l=0;l<i;l++){
                        ans[count][l]=ans[j][l];
                    }
                    ans[count][i]=(char)k;
                    usedhigh[count]=(char)Math.max(usedhigh[j],ans[count][i]);
                }
            }
            oldcount=count+1;
        }
        String[] finalans=new String[length];
        for(int i=0;i<length;i++){
            finalans[i]="";
            for(int j=0;j<n;j++){
                finalans[i]+=ans[i][j];
            }
        }
        Arrays.sort(finalans);
        String bad=finalans[0];
        for(int i=0;i<length;i++){
            if(!finalans[i].equals(bad)){
                
                System.out.println(finalans[i]);
            }
        }
        
        
 
    }



}