import java.util.*;
public class HelpfulMaths{
    public static void main(String args[]){
        int count1=0,count2=0,count3=0,x=0;
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char ch[]=s.toCharArray();
        for(int i=0;i<s.length();i=i+2){
            if(ch[i]=='1')
            count1++;
            if(ch[i]=='2')
            count2++;
            if(ch[i]=='3')
            count3++;
        }
        while(count1!=0){
            ch[x]='1';
            x+=2;
            count1--;
        }
        while(count2!=0){
            ch[x]='2';
            x+=2;
            count2--;
        }
        while(count3!=0){
            ch[x]='3';
            x+=2;
            count3--;
        }
        for(int i=0;i<s.length();i++){
            if(ch[i]=='\0')
                ch[i]='+';
        }
        for(int i=0;i<s.length();i++){
            System.out.print(ch[i]);
        }
        sc.close();
    }
}