import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;


public class Bye_2014_1 {
    public static void main(String[] args) throws IOException{
        PrintWriter pw = new PrintWriter(System.out, true);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] line = input.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] W = new int[n];
        line = input.readLine().split(" ");
        for(int i=0;i<n;i++){
            W[i] = Integer.parseInt(line[i]);
        }
        int[] M = new int[m];
        line = input.readLine().split(" ");
        for(int i=0;i<m;i++){
            M[i] = Integer.parseInt(line[i])-1;
        }
        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();
        boolean[] check = new boolean[n];
        for(int i=0;i<m;i++){
            if(!check[M[i]]){
                check[M[i]] = true;
                B.push(M[i]);
            }
        }
        for(int i=0;i<n;i++){
            if(!check[i]){
                check[i] = true;
                B.push(i);
            }
        }
        while(!B.isEmpty()){
            //System.out.println(B.peek());
            A.push(B.pop());
        }
        int x; 
        long sum = 0;
        for(int i=0;i<m;i++){
            while(A.peek() != M[i])B.push(A.pop());
            x = A.pop();
            
            while(!B.isEmpty()){
                sum += W[B.peek()];
                A.push(B.pop());
            }
            A.push(x);
        }
        pw.println(sum);
        pw.close();
        input.close();
    }
}
