import java.util.Scanner;

public class ZeptoA {
    public static void main(String[] args){
        String s;
        int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        s=in.next();
        boolean ok=false;
        for(int i=0;i<n;i++){
            if (!ok){
                for(int j=1;j<(int)(n-i+3)/4;j++){
                    if(!ok){
                        ok=true;
                        for(int k=0;k<5;k++){
                            if (s.charAt(i+k*j)=='.'){
                                ok=false;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (ok) System.out.print("yes");
        else System.out.print("no");
    }
}
