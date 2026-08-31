import java.util.*;

public class BRunForYourPrize 
{    
    static int n;
    static int eu=1, el=1000000;
    public static void main(String[] args) 
    {
        Scanner citeste = new Scanner(System.in);
        n = citeste.nextInt();
        int a[]= new int[n];
        for(int i=0; i<n; i++)
        {
            a[i]= citeste.nextInt();
        }
        incercarea2( a,  n);
    }    
    static void incercarea2(int a[], int n)
    {
        int max =1,min = 1000000;
        for(int i=0;i<n;i++)
        {
            if(a[i]>max&&a[i]<=500000)
                max = a[i];
            if(a[i]<min&&a[i]>500000)
                min = a[i];
        }
        if(max>1000000-min)
        System.out.println((max-1));
        else
        System.out.println((1000000-min));
    }
//    static void incercarea1(int a[], int n)
//    {
//         int  poz=1,secunde=0, premii_gasite=0;
//         while(premii_gasite<n)
//         {
//             secunde++;
//             if(a[i]==poz)
//                 premii_gasite++;
//             if(a[i]==1000000-poz)
//         }
//    }
}
