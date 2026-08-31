import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int T= s.nextInt();
        for(int t=0;t<T;t++){
            int n= s.nextInt();
            int m=s.nextInt();
            int[] jj= new int[26];
            s.nextLine();
            String sssss= s.nextLine();
            int[] p= new int[m];
            for(int i=0;i<m;i++){
                p[i]=s.nextInt();
            }
            int [] ll= new int[sssss.length()];
            for(int i=0;i<m;i++){
                ll[p[i]-1]+=1;
            }
            int josj=0;
            for(int i=ll.length-1;i>=0;i--){
                if(ll[i]==0){
                    ll[i]+=josj;
                }else{
                    josj+=ll[i];
                    ll[i]=josj;
                }
            }
            for(int i=0;i<ll.length;i++){
                ll[i]++;
            }
            for(int i=0;i<ll.length;i++){
                jj[sssss.charAt(i)-97]+=ll[i];
            }
            
            for(int i=0;i<26;i++){
                System.out.print(jj[i]+" ");
            }
            System.out.println();
        }
    }
}