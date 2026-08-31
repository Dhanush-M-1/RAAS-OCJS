#include <iostream>
#define FOR(i,k,n) for (int (i)=(k); (i)<(n); ++(i))
#define REP(i,n) FOR(i,0,n)
using namespace std;


int gositigo[5] = {5,7,5,7,7};

int main(){
    int n;
    while(cin >> n && n != 0){
        int w[n],pos = 0;
        string str;
        REP(i,n){
            cin >> str;
            w[i] = str.length();
        }
        REP(i,n){
            int a,s;
            s = i;
            REP(j,5){
                a = 0;
                int l = w[s];
                while(l < gositigo[j]){
                    a++;
                    l += w[s + a];
                }
                if(l != gositigo[j]){goto NEXT;}
                s += a + 1;
            }
            pos = i+1;
            break;
            NEXT: continue;
        }
        cout << pos << endl;
    }
    return 0;
}