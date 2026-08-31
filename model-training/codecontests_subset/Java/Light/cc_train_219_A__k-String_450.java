import java.util.Scanner;

public class K_strng {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i,j,n,k,l,x,y;
        String s,s1;
        char r;
        boolean is;
        while (input.hasNext()){
            /*char h = 'f';
            int e= 0;
            char r = (char) (e + 97);
            System.out.println(r);*/
            n = input.nextInt(); s1 = input.nextLine(); is = false;
            s = input.nextLine();
            int[] arr = new int[26];
            l = s.length();
            for (i=0; i<l; i++)
            {
                arr[s.charAt(i) - 'a']++;
            }
            for (i=0; i<26; i++){
                if (arr[i] % n != 0) {
                    is = true;
                    break;
                }
            }

            if (!is){
                for (i=0; i<n; i++){
                    for (j=0; j<26; j++){
                        x = arr[j] / n;
                        r = (char) (j + 97);
                        for (k=0; k<x; k++) System.out.print(r);
                    }
                }
                System.out.println();
            }
            else System.out.println(-1);
        }
    }
}
