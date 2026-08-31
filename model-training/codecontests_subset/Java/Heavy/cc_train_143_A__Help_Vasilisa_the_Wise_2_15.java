import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;
public class Code143A {

    public static void main(String[] args) throws Exception {
        BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int r1 = parseInt(st.nextToken()), r2 = parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int c1 = parseInt(st.nextToken()), c2 = parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int d1 = parseInt(st.nextToken()), d2 = parseInt(st.nextToken());

        boolean ws = false;
        for(int i=1;i<=9&&!ws;++i){
            for(int j=1;j<=9&&!ws;++j){
                for(int k=1;k<=9&&!ws;++k){
                    for(int l=1;l<=9&&!ws;++l){
                        
                        if(i!=j && i!=k && i!=l && j!=k&& j!= l && k!=l &&(i+k)==c1 && (i+j)==r1 && (k+l) ==r2 && (j+l)==c2 && (i+l)==d1 && (k+j)==d2){
                            ws = true;
                            System.out.println(i+" " + j);
                            System.out.println(k+" "+ l);
                        }
                    }
                }
            }
        }
        if(!ws)System.out.println(-1);

    }

}
