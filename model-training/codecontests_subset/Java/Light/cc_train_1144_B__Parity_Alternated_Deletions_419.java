import java.util.*;
public class abc {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[]a=new int[n];
        int[]ch=new int[n];int[] nch=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scan.nextInt();
        }
        int countOfch=0;
        int countOfNch=0;
        for (int i=0;i<n;i++){
            if(a[i] % 2==0){
                ch[i]=a[i];
                countOfch++;
            }else {
                nch[i]=a[i];
                countOfNch++;
            }
        }
        Arrays.sort(ch);
        Arrays.sort(nch);
        if(countOfch>countOfNch){
            for(int i=n-1;i>0;i--) {
                if(ch[i]!=0){
                    ch[i]=0;
                    if(nch[i]!=0){
                        nch[i]=0;
                    }else break;;
                }else break;
            }
        }else {
            for(int i=n-1;i>0;i--) {
                if(nch[i]!=0){
                    nch[i]=0;
                    if(ch[i]!=0){
                        ch[i]=0;
                    }else break;
                }else break;
            }
        }int summ=0;
        for (int i=0;i<n;i++){
            summ+=ch[i]+nch[i];
        }
        System.out.println(summ );
    }
}