import java.util.*;

public class NewClass{
public static void main (String [] args){
Scanner sc = new Scanner (System.in);
    int x = sc.nextInt();
    int even=0,odd=0,sum=0;
    int [] a = new int [x];
    for (int i = 0; i < x; i++) {
        a[i] = sc.nextInt();
        if (a[i]%2==0)
            even++;
        else odd++;
    }
    int max = Math.max(even, odd);
    int diff = Math.abs(even-odd);
    if(diff > 1){
    Arrays.sort(a);
        for (int i = 0; i < x; i++) {                   
        if(diff == 1)break;
    if(max == even){
    if(a[i]%2==0){sum+=a[i];diff--;}
    }else {
    if(a[i]%2!=0){sum+=a[i];diff--;}
    
    }
    }
    System.out.println(sum);
    }else System.out.println(0);
}
}