import java.util.Scanner;
class Main{
    static public void  main(String[] av){

        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int a[]= new int[n];
               for(int  i=0;i<n;i++){
            a[i] =sc.nextInt();
        }
int sum=0;
        for (int j=0;j<n;j++){
           double len = Math.sqrt(a[j]);
for ( int i=2 ; i<=len;i++){
    if(a[j]%i==0){
        sum++;
        break;
    }

    }
}



System.out.println(n-sum);       
    }
    
}
