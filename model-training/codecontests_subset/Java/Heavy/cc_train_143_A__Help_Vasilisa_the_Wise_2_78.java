
// author: Ahmed A.M
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //S1 p1 = new S1();   p1.solve();
        //S2 p2 = new S2();   p2.solve();
        //S3 p3 = new S3();   p3.solve();
        //S4 p4 = new S4();   p4.solve();
        //S5 p5 = new S5();   p5.solve();
        //S6 p6 = new S6();   p6.solve();
        //S7 p7 = new S7();   p7.solve();
        //S8 p8 = new S8();   p8.solve();
        //S9 p9 = new S9();   p9.solve();
        //S10 p10 = new S10();    p10.solve();
        //S11 p11 = new S11();    p11.solve();
        //S12 p12 = new S12();    p12.solve();
        //S13 p13 = new S13();    p13.solve(); *  confusing
        //S14 p14 = new S14();    p14.solve();
        //S15 p15 = new S15();    p15.solve();
        //S16 p16 = new S16();    p16.solve();
        //S17 p17 = new S17();    p17.solve();
        //S18 p18 = new S18();    p18.solve(); * without help?
        //S19 p19 = new S19();    p19.solve(); * without set ?
        //S20 p20 = new S20();    p20.solve(); * confusing * Data Types
        //S21 p21 = new S21();    p21.solve(); * confusing and fuzzy thinking
        //S22 p22 = new S22();    p22.solve();
        //S23 p23 = new S23();    p23.solve(); * very annoying problem in very annoying moments
        //S24 p24 = new S24();    p24.solve();
        //S25 p25 = new S25();    p25.solve();
        //S26 p26 = new S26();    p26.solve();
        //S27 p27 = new S27();    p27.solve();
        //S28 p28 = new S28();    p28.solve();
        //S29 p29 = new S29();    p29.solve();
        //S30 p30 = new S30();    p30.solve();
        //S31 p31 = new S31();    p31.solve();
        //S32 p32 = new S32();    p32.solve();
        //S33 p33 = new S33();    p33.solve();
        //S34 p34 = new S34();    p34.solve();
        //S35 p35 = new S35();    p35.solve();
        //S36 p36 = new S36();    p36.solve(); * Repeated mistakes
        //S37 p37 = new S37();    p37.solve();
        //S38 p38 = new S38();    p38.solve();
        //S39 p39 = new S39();    p39.solve(); * Not good
        //S40 p40 = new S40();    p40.solve();
        //S41 p41 = new S41();    p41.solve(); * Observations
        //S42 p42 = new S42();    p42.solve(); 
        //S43 p43 = new S43();    p43.solve(); * don't understand it
        //S45 p45 = new S45();    p45.solve(); * 2    
        //S46 p46 = new S46();    p46.solve(); * 1
        //S47 p47 = new S47();    p47.solve(); * 1
        //S48 p48 = new S48();    p48.solve(); * 1
        //S49 p49 = new S49();    p49.solve(); * 4 * Cascading of mistakes
        //S50 p50 = new S50();    p50.solve(); * 2 I've to eat now
        //S51 p51 = new S51();    p51.solve(); * 1
        //S52  p52 = new S52();  p52.solve();  * 2 
        //S53 p53 = new S53();    p53.solve(); * 3
        //S54 p54 = new S54();    p54.solve(); * 1
        //S55 p55 = new S55();    p55.solve(); * 1
        //S56 p56 = new S56();    p56.solve(); * 1
        //S57 p57 = new S57();    p57.solve(); * 1
        //S58 p58 = new S58();    p58.solve(); * 3
        //S59 p59 = new S59();    p59.solve(); * 1
        //S60 p60 = new S60();    p60.solve(); * 1
        //S61 p61 = new S61();    p61.solve(); * 1
        //S62 p62 = new S62();    p62.solve(); * 1
        //S63 p63 = new S63();    p63.solve(); * 1
        //S64 p64 = new S64();    p64.solve(); * 
        // -----
        //S67 p67 = new S67();    p67.solve(); * 2
        //S68 p68 = new S68();    p68.solve(); * 1  
        //S69 p69 = new S69();    p69.solve();
        //S70 p70 = new S70();    p70.solve(); * 1
        //S71 p71 = new S71();    p71.solve();
        //S72 p72 = new S72();    p72.solve();
        //S73 p73 = new S73();    p73.solve();
        //S74 p74 = new S74();    p74.solve(); * 2
        //S78 p78 = new S78();    p78.solve(); * 1
        S79 p79 = new S79();    p79.solve();
    }
}
 class S79 {
    
    public static void solve(){
        Scanner input = new Scanner(System.in);
        int r1 = input.nextInt();
        int r2 = input.nextInt();
        int c1 = input.nextInt();
        int c2 = input.nextInt();
        int d1 = input.nextInt();
        int d2 = input.nextInt();
        for (int i = 1; i <=9; i++) {
            for (int j = 1; j <= 9; j++){
                for (int k = 1; k <= 9; k++){
                    for (int l = 1; l <= 9; l++){
                        if (i!=j && j!=k && k != l && i!=k && i!=l && j!=l){
                            if (i+j == r1 &&
                                    k+l == r2 &&
                                    i+k == c1 &&
                                    j+l == c2 &&
                                    i+l == d1 &&
                                    k+j == d2){
                                System.out.println(i +" "+ j);
                                System.out.println(k +" "+ l);
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
