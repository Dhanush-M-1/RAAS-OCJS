import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] c = new char[4][4];
        for(int i=0; i<4; i++)c[i] = br.readLine().toCharArray();
        int[][] d = new int[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(c[i][j]=='o')d[i][j]=-1;
                else if(c[i][j]=='x')d[i][j]=1;
            }
        }
        if(d[0][0]+d[1][1]+d[2][2]==2||d[3][3]+d[1][1]+d[2][2]==2||d[1][0]+d[2][1]+d[3][2]==2||d[0][1]+d[1][2]+d[2][3]==2){System.out.println("YES"); return;}
        if(d[0][3]+d[1][2]+d[2][1]==2||d[3][0]+d[1][2]+d[2][1]==2||d[1][3]+d[2][2]+d[3][1]==2||d[0][2]+d[1][1]+d[2][0]==2){System.out.println("YES"); return;}
        else{
            for(int i=0; i<4; i++){
                if(d[i][0]+d[i][1]+d[i][2]==2||d[i][3]+d[i][1]+d[i][2]==2){System.out.println("YES"); return;}
                if(d[0][i]+d[1][i]+d[2][i]==2||d[3][i]+d[1][i]+d[2][i]==2){System.out.println("YES"); return;}
            }
        }
        System.out.println("NO");
    }   
}