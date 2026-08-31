import java.util.Scanner;
public class Problem040_219A_KString {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int freqLetters[] = new int[26];
        for(int i=0;i<26;i++)
            freqLetters[i]=0;
        int k=sc.nextInt();
        sc.nextLine();
        boolean isRepeated=true;
        String S = sc.nextLine();
        if(S.length()%k!=0)
            isRepeated=false;
        else
        {
            for(int i=0;i<S.length();i++)
                freqLetters[S.charAt(i)-97]++;
            lettercheck:for(int i=0;i<26;i++)
            {
                if(freqLetters[i]%k!=0)
                {
                    isRepeated=false;
                    break lettercheck;
                }
            }
         }
         if(isRepeated)
         {
             for(int l=0;l<k;l++)
             {
                 for(int i=0;i<26;i++)
                 {
                     for(int j=0;j<freqLetters[i]/k;j++)
                         System.out.print((char)(97+i));
                 }
             }
         }
         else
             System.out.println(-1);
    }
}
