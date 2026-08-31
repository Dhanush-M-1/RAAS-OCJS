import java.util.*;
public class Sol{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();
        int arr[]=new int[n];
        int arrAns[]=new int[n-1];
        for(int i=0;i<n;i++){
         arr[i]=sc.nextInt();
            if(i!=0) {
                arrAns[i-1]=arr[i-1]-arr[i];
            }
        }
        Arrays.sort(arrAns);
        if(arrAns[n-2]-c>0) {
        	
            System.out.println(arrAns[n-2]-c);
        }
        else {
            System.out.println("0");
        }
    }
}