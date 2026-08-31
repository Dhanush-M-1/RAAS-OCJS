
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author pter9_000
 */
public class Zep2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        boolean arr[]= new boolean[n];
        char zv = '*';
        for(int i=0;i<n;i++){
            if(str.charAt(i)==zv){arr[i]=true;} else {arr[i]=false;}
        }
        int firststar =0;
        while(arr[firststar]==false){
            firststar++;
            if (firststar>n-1){break;}
        }
        if (firststar>n-1){System.out.println("no"); return;}
        //System.out.println("firststar="+firststar);
        //System.out.println(Arrays.toString(arr));
        for(int j=0;j<n;j++){
			if(firststar>n-1){break;}
            while(arr[firststar]==false){
                firststar++;
                if(firststar>n-1){break;}
            }
            if(firststar>n-1){break;}
            for(int i=0;i<24;i++){
                int pos = firststar;
                int good = 1;
                while(true){
                    pos+=i+1;
                    if(pos>n-1){break;}
                    if(arr[pos]==true){good++;}
                    else
                    {break;}
                    if(good==5){System.out.println("yes"); return;}
                }

            }
            firststar++;
        }
        System.out.println("no");
    }
    
}