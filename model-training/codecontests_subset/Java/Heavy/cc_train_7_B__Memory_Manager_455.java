import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(), m = in.nextInt(), n, cnt = 0;
        int[] nid = new int[10010];

        String s;
        while (t-- > 0) {
            s = in.next();
            if (s.charAt(0) == 'd') {
                // for(int i=1;i<=m;i++){ System.out.print(nid[i]); }System.out.println();
                int i,j;
                for(i=1,j=1;i<=m;i++){
                    if(nid[i]!=0){
                        nid[j]=nid[i];
                        j++;
                    }
                }
                for(;j<=m;j++){nid[j]=0;}
                // for(i=1;i<=m;i++){ System.out.print(nid[i]); }System.out.println();
            } else if (s.charAt(0) == 'e') {
                // System.out.print("e");for(int i=1;i<=m;i++){ System.out.print(nid[i]); }System.out.println();
                n = in.nextInt();
                if(n>cnt||n<1){
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                    continue;
                }
                int flag=-1;
                for(int i=1;i<=m;i++){
                    if(nid[i]==n){
                        flag=1;
                        nid[i]=0;
                        if(nid[i+1]!=n){break;}
                    }
                }
                if(flag==-1){
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                }
            } else if (s.charAt(0) == 'a') {
                n = in.nextInt();
                int posnow = -1;
                for (int i = 1, j = 0; i + j <= m;) {
                    if (nid[i+j] != 0) {
                        i = i + j + 1;
                        j = 0;
                    } else {
                        j++;
                        if (j >= n) {
                            // System.out.println("i="+i+"j="+j);
                            posnow = i;
                            break;
                        }
                    }
                }
                if (posnow == -1) {
                    System.out.println("NULL");
                } else {
                    cnt++;
                    for(int i=posnow;i<posnow+n;i++){
                        nid[i]=cnt;
                    }
                    System.out.println(cnt);
                }
            }
        }
    }
}