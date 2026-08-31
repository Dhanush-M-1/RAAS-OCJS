//CodeForces 219A
//Joey Massoni, Amanda Roche, Pauline Callejos

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        String s  = in.next();
        
        int numOfA = 0;
        int numOfB = 0;
        int numOfC = 0;
        int numOfD = 0;
        int numOfE = 0;
        int numOfF = 0;
        int numOfG = 0;
        int numOfH = 0;
        int numOfI = 0;
        int numOfJ = 0;
        int numOfK = 0;
        int numOfL = 0;
        int numOfM = 0;
        int numOfN = 0;
        int numOfO = 0;
        int numOfP = 0;
        int numOfQ = 0;
        int numOfR = 0;
        int numOfS = 0;
        int numOfT = 0;
        int numOfU = 0;
        int numOfV = 0;
        int numOfW = 0;
        int numOfX = 0;
        int numOfY = 0;
        int numOfZ = 0;

        
        char[] brokenGibberish = s.toCharArray();
        
        Arrays.sort(brokenGibberish);
        
        for (int i = 0; i < brokenGibberish.length; i++){
            if (brokenGibberish[i] == 'a'){
                numOfA++;
            }else if (brokenGibberish[i] == 'b'){
                numOfB++;
            }else if (brokenGibberish[i] == 'c'){
                numOfC++;
            }else if (brokenGibberish[i] == 'd'){
                numOfD++;
            }else if (brokenGibberish[i] == 'e'){
                numOfE++;
            }else if (brokenGibberish[i] == 'f'){
                numOfF++;
            }else if (brokenGibberish[i] == 'g'){
                numOfG++;
            }else if (brokenGibberish[i] == 'h'){
                numOfH++;
            }else if (brokenGibberish[i] == 'i'){
                numOfI++;
            }else if (brokenGibberish[i] == 'j'){
                numOfJ++;
            }else if (brokenGibberish[i] == 'k'){
                numOfK++;
            }else if (brokenGibberish[i] == 'l'){
                numOfL++;
            }else if (brokenGibberish[i] == 'm'){
                numOfM++;
            }else if (brokenGibberish[i] == 'n'){
                numOfN++;
            }else if (brokenGibberish[i] == 'o'){
                numOfO++;
            }else if (brokenGibberish[i] == 'p'){
                numOfP++;
            }else if (brokenGibberish[i] == 'q'){
                numOfQ++;
            }else if (brokenGibberish[i] == 'r'){
                numOfR++;
            }else if (brokenGibberish[i] == 's'){
                numOfS++;
            }else if (brokenGibberish[i] == 't'){
                numOfT++;
            }else if (brokenGibberish[i] == 'u'){
                numOfU++;
            }else if (brokenGibberish[i] == 'v'){
                numOfV++;
            }else if (brokenGibberish[i] == 'w'){
                numOfW++;
            }else if (brokenGibberish[i] == 'x'){
                numOfX++;
            }else if (brokenGibberish[i] == 'y'){
                numOfY++;
            }else if (brokenGibberish[i] == 'z'){
                numOfZ++;
            }
        }
        
        String littleWord = "";
                
        if(numOfA > 0 && numOfA % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfA > 0){
            int a = numOfA/k;
            
            for(int x = 0; x < a; x++){
                
                littleWord = littleWord + "a";
               
            }
        }
        
        if(numOfB > 0 && numOfB % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfB > 0){
            int b = numOfB/k;
            
            for(int x = 0; x < b; x++){
                
                littleWord = littleWord + "b";
               
            }
        }
        
        if(numOfC > 0 && numOfC % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfC > 0){
            int c = numOfC/k;
            
            for(int x = 0; x < c; x++){
                
                littleWord = littleWord + "c";
               
            }
        }
        
        if(numOfD > 0 && numOfD % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfD > 0){
            int d = numOfD/k;
            
            for(int x = 0; x < d; x++){
                
                littleWord = littleWord + "d";
               
            }
        }
        
        if(numOfE > 0 && numOfE % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfE > 0){
            int e = numOfE/k;
            
            for(int x = 0; x < e; x++){
                
                littleWord = littleWord + "e";
               
            }
        }
        
        
        if(numOfF > 0 && numOfF % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfF > 0){
            int f = numOfF/k;
            
            for(int x = 0; x < f; x++){
                
                littleWord = littleWord + "f";
               
            }
        }
        
        if(numOfG > 0 && numOfG % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfG > 0){
            int g = numOfG/k;
            
            for(int x = 0; x < g; x++){
                
                littleWord = littleWord + "g";
               
            }
        }
        
        if(numOfH > 0 && numOfH % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfH > 0){
            int h = numOfH/k;
            
            for(int x = 0; x < h; x++){
                
                littleWord = littleWord + "h";
               
            }
        }
        
        if(numOfI > 0 && numOfI % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfI > 0){
            int i = numOfI/k;
            
            for(int x = 0; x < i; x++){
                
                littleWord = littleWord + "i";
               
            }
        }
        
        
        if(numOfJ > 0 && numOfJ % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfJ > 0){
            int j = numOfJ/k;
            
            for(int x = 0; x < j; x++){
                
                littleWord = littleWord + "j";
               
            }
        }
        
        if(numOfK > 0 && numOfK % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfK > 0){
            int kay = numOfK/k;
            
            for(int x = 0; x < kay; x++){
                
                littleWord = littleWord + "k";
               
            }
        }
        
        if(numOfL > 0 && numOfL % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfL > 0){
            int l = numOfL/k;
            
            for(int x = 0; x < l; x++){
                
                littleWord = littleWord + "l";
               
            }
        }
        
        
        if(numOfM > 0 && numOfM % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfM > 0){
            int m = numOfM/k;
            
            for(int x = 0; x < m; x++){
                
                littleWord = littleWord + "m";
               
            }
        }
        
        if(numOfN > 0 && numOfN % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfN > 0){
            int n = numOfN/k;
            
            for(int x = 0; x < n; x++){
                
                littleWord = littleWord + "n";
               
            }
        }
        
        if(numOfO > 0 && numOfO % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfO > 0){
            int o = numOfO/k;
            
            for(int x = 0; x < o; x++){
                
                littleWord = littleWord + "o";
               
            }
        }
        
        if(numOfP > 0 && numOfP % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfP > 0){
            int p = numOfP/k;
            
            for(int x = 0; x < p; x++){
                
                littleWord = littleWord + "p";
               
            }
        }
        
        if(numOfQ > 0 && numOfQ % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfQ > 0){
            int q = numOfQ/k;
            
            for(int x = 0; x < q; x++){
                
                littleWord = littleWord + "q";
               
            }
        }
        
        if(numOfR > 0 && numOfR % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfR > 0){
            int r = numOfR/k;
            
            for(int x = 0; x < r; x++){
                
                littleWord = littleWord + "r";
               
            }
        }
        
        if(numOfS > 0 && numOfS % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfS > 0){
            int es = numOfS/k;
            
            for(int x = 0; x < es; x++){
                
                littleWord = littleWord + "s";
               
            }
        }
        
        if(numOfT > 0 && numOfT % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfT > 0){
            int t = numOfT/k;
            
            for(int x = 0; x < t; x++){
                
                littleWord = littleWord + "t";
               
            }
        }
        
        if(numOfU > 0 && numOfU % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfU > 0){
            int u = numOfU/k;
            
            for(int x = 0; x < u; x++){
                
                littleWord = littleWord + "u";
               
            }
        }
        
        if(numOfV > 0 && numOfV % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfV > 0){
            int v = numOfV/k;
            
            for(int x = 0; x < v; x++){
                
                littleWord = littleWord + "v";
               
            }
        }
        
        if(numOfW > 0 && numOfW % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfW > 0){
            int w = numOfW/k;
            
            for(int x = 0; x < w; x++){
                
                littleWord = littleWord + "w";
               
            }
        }
        
        if(numOfX > 0 && numOfX % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfX > 0){
            int ex = numOfX/k;
            
            for(int x = 0; x < ex; x++){
                
                littleWord = littleWord + "x";
               
            }
        }
        
        if(numOfY > 0 && numOfY % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfY > 0){
            int y = numOfY/k;
            
            for(int x = 0; x < y; x++){
                
                littleWord = littleWord + "y";
               
            }
        }
        
        if(numOfZ > 0 && numOfZ % k != 0){
            System.out.println(-1);
            return;
        } else if (numOfZ > 0){
            int z = numOfZ/k;
            
            for(int x = 0; x < z; x++){
                
                littleWord = littleWord + "z";
               
            }
        }
        
        
        for(int x = 0; x < k; x++){
            
            System.out.print(littleWord);
            
        }


    }   
}
