import java.util.Scanner;

/**
 * Created on 16.04.2016.
 */
public class task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s=input.nextLine();
        String[] ss = s.split(" ");
        int n = Integer.valueOf(ss[ss.length-1]);
        int cntplus = s.split("\\+").length-1;
        int cntminus = s.split("-").length-1;
        String rez="";
        if(n*cntplus<cntminus||cntplus>n*(cntminus+1)){
            rez="Impossible";
        }else {
            rez+="Possible"+"\n";
            int add = cntplus + 1 - cntminus - n;
            int cntadd;
            int dob;
            if (n>1){
                cntadd = Math.abs(add / (n - 1));
                dob = Math.abs(add % (n - 1))+1;
            }else{
                cntadd=add;
                dob=1;
            }

            ss = s.split("\\?");
            int tekadd = 0, tekdob = 0;
            if (add < 0) {
                for (int i = 0; i < ss.length - 1; i++) {
                    if (!ss[i].trim().contains("-")) {
                        if (tekadd < cntadd) {
                            rez += ss[i] + Integer.toString(n);
                            tekadd++;
                        } else if (tekdob == 0) {
                            rez += ss[i] + Integer.toString(dob);
                            tekdob++;
                        } else {
                            rez += ss[i] + "1";
                        }
                    } else {
                        rez += ss[i] + "1";
                    }
                }
            } else {
                for (int i = 0; i < ss.length - 1; i++) {
                    if (ss[i].trim().contains("-")) {
                        if (tekadd < cntadd) {
                            rez += ss[i] + Integer.toString(n);
                            tekadd++;
                        } else if (tekdob == 0) {
                            rez += ss[i] + Integer.toString(dob);
                            tekdob++;
                        } else {
                            rez += ss[i] + "1";
                        }
                    } else {
                        rez += ss[i] + "1";
                    }
                }
            }
            rez+=ss[ss.length-1];
        }
        System.out.println(rez);
        }
}

