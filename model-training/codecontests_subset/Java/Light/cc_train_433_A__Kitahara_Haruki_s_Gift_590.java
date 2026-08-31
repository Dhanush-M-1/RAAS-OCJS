import java.util.Scanner;
public class apples {
public static void main(String args[]){
    Scanner input=new Scanner(System.in);
    int n,i=0;
    int arr[]=new int[100];
    n=input.nextInt();
    int sum=0;
    for(i=0;i<n;i++)
    {
        arr[i]=input.nextInt();
        sum=sum+arr[i];
    }
    if(n%2==0)
    {
    if(sum%200==0){
        System.out.println("YES");
    }
    else{
        System.out.println("NO");
    }
    }
    if(n%2!=0)
    {
        if(sum%200==0&&n*200!=sum&&n!=1){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
}
