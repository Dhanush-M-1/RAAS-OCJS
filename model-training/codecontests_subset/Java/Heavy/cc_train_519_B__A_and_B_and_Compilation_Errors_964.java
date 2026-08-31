
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static boolean compare(int a,int b){
        return a==b;
    }
    public static void main (String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());   
        int a [] = new int [n];
        int b [] = new int [n-1];
        int c [] = new int [n-2];
        for(int i = 0;i < a.length;i++)
            a[i]=Integer.parseInt(st.nextToken());
        for(int i = 0;i < b.length;i++)
            b[i]=Integer.parseInt(st2.nextToken());
            //System.out.println(st2.nextToken());
        for(int i = 0;i < c.length;i++)
            c[i]=Integer.parseInt(st3.nextToken());
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        for(int i = 0;i < a.length;i++){
            if(i==a.length-1 || !compare(a[i],b[i])){
                System.out.print(a[i]+" ");
                break;
            }
        }
        for(int i = 0;i < b.length;i++){
            if(i==b.length-1 || !compare(b[i],c[i])){
                System.out.println(b[i]);
                break;
            }
                
        }
        //System.out.println(Arrays.toString(a)+Arrays.toString(b)+Arrays.toString(c));
    }
    
    
}
