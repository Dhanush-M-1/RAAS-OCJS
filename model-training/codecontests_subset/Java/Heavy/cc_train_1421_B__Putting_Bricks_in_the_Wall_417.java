import java.io.*; import java.util.*;
public class CF1421B {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N=Integer.parseInt(br.readLine());
            int a=0; int b=0; int c=0; int d=0;
            for (int j = 0; j < N; j++) {
                String s=br.readLine();
                if(j==0){
                    a=s.charAt(1)-'0';
                }else if(j==1){
                    b=s.charAt(0)-'0';
                }
                if(j==N-2){
                    c=s.charAt(N-1)-'0';
                }else if(j==N-1){
                    d=s.charAt(N-2)-'0';
                }
            }
            
            if(a+b==2){
                sb.append(c+d).append("\n");
                if(c>0){
                    sb.append((N-1)+" "+N).append("\n");
                }
                if(d>0){
                    sb.append(N+" "+(N-1)).append("\n");
                }
                
            }else if(a+b==0){
                sb.append(2-(c+d)).append("\n");
                if(c==0){
                    sb.append((N-1)+" "+N).append("\n");
                }                                       
                if(d==0){
                    sb.append(N+" "+(N-1)).append("\n");
                }
            }else{
                if(c+d==2){
                    sb.append(a+b).append("\n");
                    if(a>0){
                        sb.append(1+" "+2).append("\n");
                    }
                    if(b>0){
                        sb.append(2+" "+1).append("\n");
                    }
                }else if(c+d==0){
                    sb.append(2-(a+b)).append("\n");
                    if(a==0){
                        sb.append(1+" "+2).append("\n");
                    }
                    if(b==0){
                        sb.append(2+" "+1).append("\n");
                    }
                }else{
                    //Set all 0's
                    sb.append(2).append("\n");
                    if(a==0){//Make a,b 1, c,d 0
                        sb.append(1+" "+2).append("\n");
                    }else{
                        sb.append(2+" "+1).append("\n");
                    }
                    if(c>0){
                        sb.append((N-1)+" "+N).append("\n");
                    }else{
                        sb.append(N+" "+(N-1)).append("\n");
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
    
}
//Watch out for overflows (long), special cases (n=3)!