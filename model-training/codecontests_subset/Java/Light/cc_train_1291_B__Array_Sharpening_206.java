
    import java.util.*;

    public class main {

        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            int n = in.nextInt();

            for(int j=0;j<n;j++){
                int m = in.nextInt();
                int inc=-1, dec = m;
                int[] a = new int[m];

                for(int i=0;i<m;i++){
                    a[i] = in.nextInt();
                }

                for(int i=0;i<m;i++){
                    if(a[i]>=i){
                        inc=i;
                    }else break;
                }
                String ans="No";
                int ind=0;
                for(int i=m-1;i>=0;i--){
                    if(a[i]>=ind){
                        dec=i;
                        ind++;
                    }else break;
                }
                if(inc>=dec){
                    ans="Yes";
                }
                System.out.println(ans);
            }
        }
    }
