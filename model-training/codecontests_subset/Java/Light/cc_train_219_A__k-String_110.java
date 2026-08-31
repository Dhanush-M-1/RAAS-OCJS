import java.util.Scanner;


public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        String line = in.next();
        
        int letters[] = new int[26];
        
        for(int i=0;i<line.length();i++) letters[line.charAt(i)-'a']++;
        
        for(int i=0;i<26;i++)
            if(letters[i]%n!=0) {
                System.out.println("-1");
                return;
            }
        
        
        String ans="";
        for(int i=0;i<26;i++)
            for(int j=0;j<letters[i]/n;j++)
                ans+=(char)(i+'a');
        
        String res="";
        for(int i=0;i<n;i++) res+=ans;
        System.out.println(res);
            
        

    }

}