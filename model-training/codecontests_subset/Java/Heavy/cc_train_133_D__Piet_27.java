import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Solver {

    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws NumberFormatException, IOException {
        Solver solver = new Solver();
        solver.open();
        solver.solve();
        solver.close();
    }

    public void open() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    public String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken());
    }
    
    public boolean isLeft(int dpx,int dpy, int cpx, int cpy){
        
        
        return (dpx+cpx)*(dpy-cpy)>0;
    }

    public void solve() throws NumberFormatException, IOException {
        int m = nextInt();
        int n = nextInt();
        
        int[][] ar = new int[m][];
        for(int i=0;i<m;i++){
            String line = nextToken();
            int length = line.length();
            ar[i] = new int[length];
            for (int j=0;j<length;j++){
                ar[i][j] = (line.charAt(j)-'0');
            }
        }
        
        int k = ar[0].length;
        
        int[][][] edges = new int[m][k][4];
        
        for(int i=0;i<m;i++){
            for (int j=0;j<k;j++){
                int color = ar[i][j];
                if (color>0){
                    int left = j;
                    int right = j;
                    int top = i;
                    int bottom = i;
                    
                    while (left>=0 && ar[i][left]==color) left--;
                    left++;
                    while (right<k && ar[i][right]==color) right++;
                    right--;
                    while (top>=0 && ar[top][j]==color) top--;
                    top++;
                    while (bottom<m && ar[bottom][j]==color) bottom++;
                    bottom--;
                    
                    edges[i][j][0] = left;
                    edges[i][j][1] = top;
                    edges[i][j][2] = right;
                    edges[i][j][3] = bottom;
                }
            }
        }
        
        int currentX = 0;
        int currentY = 0;
        int directionX = 1;
        int directionY = 0;
        int choosenX = 0;
        int choosenY = -1;
        
        for (int i=0;i<n;i++){
            int nextX = 0;
            int nextY = 0;
            
            if (directionX+choosenX>0) 
                nextX = edges[currentY][currentX][2];
            else
                nextX = edges[currentY][currentX][0];
            
            if (directionY+choosenY>0) 
                nextY = edges[currentY][currentX][3];
            else
                nextY = edges[currentY][currentX][1]; 
            
            nextX += directionX;
            nextY += directionY;
            if (nextX>=0 && nextY>=0 && nextX<k && nextY<m && ar[nextY][nextX]>0){
                currentX = nextX;
                currentY = nextY;
            }else{
                if (isLeft(directionX, directionY, choosenX, choosenY)){
                    choosenX = -choosenX;
                    choosenY = -choosenY;
                }else{
                    int tmpX = choosenX;
                    choosenX = directionX;
                    directionX = tmpX;
                    
                    int tmpY = choosenY;
                    choosenY = directionY;
                    directionY = tmpY;
                }
            }
        }
        
        out.println(ar[currentY][currentX]);
    }

    public void close() {
        out.flush();
        out.close();
    }

}