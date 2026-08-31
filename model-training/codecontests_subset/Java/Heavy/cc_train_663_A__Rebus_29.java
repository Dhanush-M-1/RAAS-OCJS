import java.util.Scanner;

public class Rebus {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int pcount = 1, mcount = 0, idx = 0, n;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '+') {
                ++pcount;
            } else if(s.charAt(i) == '-') {
                ++mcount;
            } else if(s.charAt(i) == '=') {
                idx = i + 2;
                break;
            }
        }
        n = Integer.parseInt(s.substring(idx));
        int ps[] = new int[pcount];
        int ms[] = new int[mcount];
        for(int i = 0; i < pcount; ++i) {
            ps[i] = 1;
        }
        for(int i = 0; i < mcount; ++i) {
            ms[i] = 1;
        }
        
        int tmp = pcount - mcount, dif = n - tmp;
        
        if(dif > 0) {
            for(int i = 0; i < pcount; ++i) {
                if(ps[i] + dif <= n) {
                    ps[i] += dif;
                    dif = 0;
                    break;
                } else {
                    ps[i] = n;
                    dif -= n - 1;
                }
                if(dif <= 0) {
                    break;
                }
            }
        } else {
            dif *= -1;
            for(int i = 0; i < mcount; ++i) {
                if(ms[i] + dif <= n) {
                    ms[i] += dif;
                    dif = 0;
                    break;
                } else {
                    ms[i] = n;
                    dif -= n - 1;
                }
                if(dif <= 0) {
                    break;
                }
            }
        }
        
        if(dif == 0) {
            String ans = "";
            boolean flag = true;
            int x = 0, y = 0;
            for(int i = 0; i < s.length(); ++i) {
                if(s.charAt(i) == '?') {
                    if(flag) {
                        ans += ps[x++] + " ";
                    } else {
                        ans += ms[y++] + " ";
                    }
                } else if(s.charAt(i) == '+') {
                    ans += "+";
                    flag = true;
                } else if(s.charAt(i) == '-') {
                    ans += "-";
                    flag = false;
                } else if(s.charAt(i) == '=') {
                    ans += "= ";
                    break;
                } else {
                    ans += " ";
                }
            }
            ans += n;
            System.out.println("Possible");
            System.out.println(ans);
        } else {
            System.out.println("Impossible");
        }
        
        input.close();
    }

}
