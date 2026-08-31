import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n,z,max=0;
        String s,a="";
        n = read.nextInt();
        s = read.next();
        String[] array = new String[n-1];
        for(int i=0;i<n-1;i++){
            array[i]=""+s.charAt(i)+s.charAt(i+1);
        }
        for(int i=0;i<n-1;i++){
            z=0;
            for(int y=0;y<n-1;y++){
                if(i==y)
                    continue;
                if(array[i].equals(array[y])){
                    z++;
                }
            }
            if(max<=z){
                max=z;
                a = array[i];
            }
        }
        System.out.println(a);
    }
}