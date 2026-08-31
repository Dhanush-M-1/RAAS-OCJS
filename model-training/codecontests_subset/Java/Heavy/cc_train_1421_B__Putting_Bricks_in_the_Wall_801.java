import java.io.IOException;
import java.io.*;
import java.util.*;
public class Cp {
    static int count=0;
    static StringBuilder sb;
    static void apply(int pos,int val,int i,int j){
        if (pos!=val){
            count++;
            sb.append(i).append(" ").append(j).append("\n");
        }
    }
    static void find(int leftR,int leftD,int downUp,int downL,int n,int val){
        sb.setLength(0);
        count=0;
        apply(downUp,val^1,n-1,n);
        apply(downL,val^1,n,n-1);
        apply(leftR,val,1,2);
        apply(leftD,val,2,1);

    }
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb1 = new StringBuilder();
        sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- >= 1) {
            int n = Integer.parseInt(br.readLine());
            char ch[][] = new char[n][n];
            for (int i = 0; i < n; i++) {
                ch[i]=br.readLine().trim().toCharArray();
            }
            int LeftR=ch[0][1]-'0';
            int leftDown=ch[1][0]-'0';
            int downUp=ch[n-2][n-1]-'0';
            int downL=ch[n-1][n-2]-'0';
            find(LeftR,leftDown,downUp,downL,n,1);
            if (count>2)find(LeftR,leftDown,downUp,downL,n,0);
            sb1.append(count).append("\n");
            sb1.append(sb);


        }
        System.out.println(sb1);


    }
}