import java.io.*;
    
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i, j;
        int count = 0;
    
        for(i=0; i<n; i++){
            int a = Integer.parseInt(br.readLine());
            for(j=2; (j*j)<=a; j++){
                if(a%j == 0) break;
            }
            if((j*j)>a) count++;
        }
        System.out.println(count);
    }
}