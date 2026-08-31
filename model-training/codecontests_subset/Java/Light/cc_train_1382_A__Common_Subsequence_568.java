import java.io.*;
public class comSub{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            String s = br.readLine();
            String[] token = s.split(" ");
            int n = Integer.parseInt(token[0]);
            int m = Integer.parseInt(token[1]);
            int[] a = new int[n];
            int[] b = new int[m];
            
            String s1 = br.readLine();
            String[] token1 = s1.split(" ");
            for (int i=0; i<n; i++)
            a[i] = Integer.parseInt(token1[i]);
            
            String s2 = br.readLine();
            String[] token2 = s2.split(" ");
            for (int i=0; i<m; i++)
            b[i] = Integer.parseInt(token2[i]);
            
            int flag=0,v=0;
            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    if(a[i]==b[j]){
                        flag=1;
                        v=a[i];
                        break;
                    }
                }
            }
            if (flag==1){
            System.out.println("YES");
            System.out.println("1 "+v);
            }
            else
            System.out.println("NO");
        }
    }
}