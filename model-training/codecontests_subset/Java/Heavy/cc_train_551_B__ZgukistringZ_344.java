//package codeforces;

import java.util.Scanner;

public class Codeforces {
    
    static int a[] = new int[100];
    static int b[] = new int[100];
    static int c[] = new int[100];
    
    public static void main(String[] args) {
        String astr, bstr, cstr;
        Scanner sc = new Scanner(System.in);
        
        astr = sc.next(); bstr = sc.next(); cstr = sc.next();
        
        for(int i = 0; i < astr.length(); ++i) a[astr.charAt(i) - 'a']++;
        for(int i = 0; i < bstr.length(); ++i) b[bstr.charAt(i) - 'a']++;
        for(int i = 0; i < cstr.length(); ++i) c[cstr.charAt(i) - 'a']++;
        
        
        int b_cnt = 0;
        
        int bNum = 0, cNum = 0;
        
        boolean exit = false;
        
        for(;;){
            int c_cnt = Integer.MAX_VALUE;
            
            for(int j = 0; j < 26; ++j){
                if(a[j] - b_cnt * b[j] < 0) { exit = true; break; }
                if(c[j] > 0) { c_cnt = Math.min(c_cnt, (a[j] - b_cnt * b[j]) / c[j]); }
            }
            
            if(exit) break;
            
            if(b_cnt + c_cnt > bNum + cNum) { bNum = b_cnt; cNum = c_cnt; }
            b_cnt++;
        }
        
        
        for(int i = 0; i < 26; ++i){
            a[i] -= bNum * b[i] + cNum * c[i];
        }
        
        /*StringBuilder sb = new StringBuilder();
        for(int i = 0; i < b_cnt; ++i){
            sb.append(bstr);
        }
        for(int i = 0; i < c_cnt; ++i){
            sb.append(cstr);
        }
        
        for(int i = 0; i < 26; ++i){
            for(int j = 0; j < a[i]; ++j){
                sb.append((char)(i + 'a'));
            }
        }
        
        System.out.println(sb.toString());*/
        
        for(int i = 0; i < bNum; ++i){
            for(int j = 0; j < bstr.length(); ++j){
                System.out.printf("%c", bstr.charAt(j));
            }
        }
        for(int i = 0; i < cNum; ++i){
            for(int j = 0; j < cstr.length(); ++j){
                System.out.printf("%c", cstr.charAt(j));
            }
        }
        
        for(int i = 0; i < 26; ++i){
            for(int j = 0; j < a[i]; ++j){
                System.out.printf("%c", (char)(i + 'a'));
            }
        }
            
        sc.close();
    }
}
