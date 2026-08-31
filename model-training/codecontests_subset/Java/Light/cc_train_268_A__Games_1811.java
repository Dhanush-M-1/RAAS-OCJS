import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     
          Scanner input=new Scanner(System.in);
        int n=input.nextInt();
           int[]arr1=new int[n];
           int []arr2=new int[n];
        for(int i=0;i<n;i++){
           arr1[i]=input.nextInt();
           arr2[i]=input.nextInt();
            
        }
        int count=0;
        int x=1;
        for(int i=0;i<n;i++){
            for(int j=x;j<n;j++){
            if(arr1[i]==arr2[j]){
                count++;
            }if(arr2[i]==arr1[j])
                count++;
         
        }
          x++;
        }
        System.out.println(count);

    }
               
    }