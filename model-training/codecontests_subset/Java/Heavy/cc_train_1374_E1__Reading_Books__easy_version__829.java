import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
            int l=s.nextInt();
            int m=s.nextInt();
            ArrayList<Long> a1=new ArrayList<>();
            ArrayList<Long> a2=new ArrayList<>();
            ArrayList<Long> a3=new ArrayList<>();
            int b1=0;
            int b2=0;
            int b3=0;
            for (int i=0;i<l;i++){
                long h=s.nextInt();
                int u=s.nextInt();
                int y=s.nextInt();
                if (u==1&&y==0){
                    a1.add(h);
                    b1++;
                } else if (u==0&&y==1){
                    a2.add(h);
                    b2++;
                } else if (u==1&&y==1){
                    a3.add(h);
                    b3++;
                }
            }
            int c1=0;
            int c3=0;
            Collections.sort(a1);
            Collections.sort(a2);
            Collections.sort(a3);
            long ans=0;
            if (b1+b3<m||b2+b3<m){
                System.out.println(-1);
            } else {
                for (int i=0;i<m;i++){
                    if (b1==c1||b2==c1){
                        ans+=a3.get(c3);
                        c3++;
                    } else {
                        if (b3!=c3){
                            if (a1.get(c1)+a2.get(c1)<a3.get(c3)){
                                ans+=a1.get(c1)+a2.get(c1);
                                c1++;
                            } else {
                                ans+=a3.get(c3);
                                c3++;
                            }
                        } else {
                            ans+=a1.get(c1)+a2.get(c1);
                            c1++;
                        }

                    }
                }
                System.out.println(ans);
            }
    }
}