import java.util.*;
import java.io.*;
import java.lang.*;
public class Codeforces{
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in)); 
    PrintWriter out =new PrintWriter(System.out);
    StringTokenizer st =new StringTokenizer("");
    String next(){
        if(!st.hasMoreTokens()){
            try{
                st=new StringTokenizer(br.readLine());
            }
            catch(Exception e){

            }
        }
        return st.nextToken();
    }
    int nextInt(){
        return Integer.parseInt(next());
    }
    public static void main(String[] args) {
        new Codeforces().solve();
    }
    void solve(){
        int t=nextInt();
        while(t-->0){
            int n=nextInt();
            int arr[][] =new int [n][n];
            for(int i=0;i<n;i++){
                char temp[]=next().toCharArray();
                for(int j=0;j<n;j++){
                    arr[i][j]=temp[j]-'0';
                }
            }
            if(arr[0][1]==0 && arr[1][0]==0){
                if(arr[n-1][n-2]==1 && arr[n-2][n-1]==1){
                    out.println(0);
                }
                if(arr[n-1][n-2]==0 && arr[n-2][n-1]==0){
                    out.println(2);
                    out.println((n)+" "+(n-1));
                    out.println((n-1)+" "+(n));
                }
                if(arr[n-1][n-2]==1 && arr[n-2][n-1]==0){
                    out.println(1);
                    out.println((n-1)+" "+(n));
                }
                if(arr[n-1][n-2]==0 && arr[n-2][n-1]==1){
                    out.println(1);
                    out.println((n)+" "+(n-1));
                }
            }
            if(arr[0][1]==1 && arr[1][0]==1){
                if(arr[n-1][n-2]==1 && arr[n-2][n-1]==1){
                    out.println(2);
                    out.println((n)+" "+(n-1));
                    out.println((n-1)+" "+(n));
                    
                }
                if(arr[n-1][n-2]==0 && arr[n-2][n-1]==0){
                    out.println(0);
                }
                if(arr[n-1][n-2]==0 && arr[n-2][n-1]==1){
                    out.println(1);
                    out.println((n-1)+" "+(n));
                }
                if(arr[n-1][n-2]==1 && arr[n-2][n-1]==0){
                    out.println(1);
                    out.println((n)+" "+(n-1));
                }
            }
            if((arr[0][1]==0 && arr[1][0]==1)){
                if(arr[n-1][n-2]==1 && arr[n-2][n-1]==1){
                    out.println(1);
                    out.println(2+" "+1);                    
                }
                if(arr[n-1][n-2]==0 && arr[n-2][n-1]==0){
                    out.println(1);
                    out.println(1+" "+2);
                }
                if(arr[n-1][n-2]==0 && arr[n-2][n-1]==1){
                    out.println(2);
                    out.println(1+" "+2);
                    out.println((n-1)+" "+(n));
                }
                if(arr[n-1][n-2]==1 && arr[n-2][n-1]==0){
                    out.println(2);
                    out.println(1+" "+2);
                    out.println((n)+" "+(n-1));
                }
            }
            if((arr[0][1]==1 && arr[1][0]==0)){
                if(arr[n-1][n-2]==1 && arr[n-2][n-1]==1){
                    out.println(1);
                    out.println(1+" "+2);                    
                }
                if(arr[n-1][n-2]==0 && arr[n-2][n-1]==0){
                    out.println(1);
                    out.println(2+" "+1);
                }
                if(arr[n-1][n-2]==0 && arr[n-2][n-1]==1){
                    out.println(2);
                    out.println(1+" "+2);
                    out.println((n)+" "+(n-1));
                }
                if(arr[n-1][n-2]==1 && arr[n-2][n-1]==0){
                    out.println(2);
                    out.println(2+" "+1);
                    out.println((n)+" "+(n-1));
                }
            }
            
        }

        out.close();
    }
}
