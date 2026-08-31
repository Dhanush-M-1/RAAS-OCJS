import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        int count=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String x=br.readLine();
        int sum=x.length();
        for(char c:x.toCharArray()){
            if(c=='S'){
                count++;
            }else if(c=='T'){
                if(count!=0){
                    count--;
                    sum-=2;
                }
            }
        }System.out.println(sum);
    }
}