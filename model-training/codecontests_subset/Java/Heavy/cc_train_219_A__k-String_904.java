import java.util.Scanner;

public class L50P219A{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int k=in.nextInt();
        in.nextLine();
        char[] s=in.nextLine().toCharArray();
        String helper="abcdefghijklmnopqsrtuvwxyz";
        int []a=new int[26];
        for(int i=0;i<s.length;i++){
            a[helper.indexOf(s[i])]++;
        }
        boolean flag=true;
        for(int i=0;i<26;i++){
            if(a[i]%k!=0){
                flag=false;
                break;
            }
        }

        if(!flag){
            System.out.println(-1);
        }
        else{
            for(int l=0;l<k;l++){
                for(int i=0;i<26;i++){
                    for(int j=0;j<(a[i]/k);j++){
                        System.out.print(helper.charAt(i));
                    }
                }
            }
            System.out.println();
        }
        in.close();
    }
}