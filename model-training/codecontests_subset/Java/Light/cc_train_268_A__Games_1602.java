import java.util.Scanner;

/**
 *
 * @author Mostafa POP
 */
public class Codeforces {

    /**
     * @param args the command line arguments
     */
    public static int  searchcl1(int []arr,int ele,int end){
        int c=0;
        for(int i=end-1;i>=0;i=i-2){
            if(ele==arr[i]){
                c++;
            }
        }
        return c;
    }
    public static int Games(int []arr){
        int num=0,total=0;
        float z;
        for(int i=2;i<arr.length;i++){
            total+=searchcl1(arr,arr[i],i);
        }
        return total;
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int g;
        int []arra=new int[num*2];
        for(int i=0;i<arra.length;i++){
            g=sc.nextInt();
            arra[i]=g;
        }
        int s=Games(arra);
        System.out.println(s);               
    } 
}