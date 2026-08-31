import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] count=new int[26];
        int k=sc.nextInt();
        String str=sc.next();
        sc.close();
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)-'a']++;
        }
        String res="";
        for(int i=0;i<count.length;i++){
            if(count[i]%k!=0){
                System.out.println(-1);
                return;
            }else{
                int t=count[i]/k;
                for(int j=0;j<t;j++){
                    res+=(char)(i+'a');
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<k;i++){
            sb.append(res);
        }
    System.out.println(sb);
    }
}
