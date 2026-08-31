import java.io.*;

public class ques478A {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" "); int sum=0;
        for(int i=0;i<input.length;i++){
            sum = sum + Integer.parseInt(input[i]);
        }
        if((sum%input.length)==0 && sum>0)System.out.println(""+(sum/input.length));
        else System.out.println("-1");
        
    }
}
