import java.util.*;
import java.lang.*;
public class MyClass {
    public static void main(String args[]) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int array[] = new int[n];
        for(int i = 0; i<n; i++){
            array[i] = read.nextInt();
        }
        int even = 0;
        int odd = 0;
        for(int r = 0; r<n; r++){
            if(array[r]%2 == 0){
                even++;
            }
            else{
                odd++;
            }
        }
        Arrays.sort(array);
        List<Integer> listA = new ArrayList();
        for(int k = n - 1; k>=0; k--){
            if(odd>even){
                if(array[k]%2 != 0){
                    listA.add(array[k]);
                }
        }
            else{
                if(array[k]%2 == 0){
                    listA.add(array[k]);
                }
            }
        }
        if(odd>even){
        for(int d = 0; d<even+1; d++){
                listA.remove(0);
        }
        }
        else if(odd<even){
            for(int t = 0; t<odd+1; t++){
                listA.remove(0);
            }
        }
        if(odd == even){
            System.out.println(0);
        }
        else{
        int sum = 0;
        for(int d = 0; d<listA.size(); d++){
            sum = sum + listA.get(d);
        }
        System.out.println(sum);
        }
    }
}
