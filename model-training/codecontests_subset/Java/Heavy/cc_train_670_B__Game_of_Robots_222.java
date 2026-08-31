import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author PRAVEER SATYAM
 */
public class B {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz ;
        stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        int[] arr = new int[n];
        stz = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(stz.nextToken());
        }
        int i=0,l=0;
        while((i+(++l))<k){
            i+=l;
            //l++;
        }
         //print(i);   
        System.out.print(arr[k-i-1]);
        //print(t);
    } 
    static void print(long a){
        System.out.print(a);
    }
    static void print(String a){
        System.out.print(a);
    }
    static void println(long a){
        System.out.println(a);
    }
    static void println(String a){
        System.out.println(a);
    }
}