#include <bits/stdc++.h>
using namespace std;

string suite = "SHCD";

bool cards[4][13];

int main(){
    int N; cin >> N;
    for(int i=0; i<N; i++){
        char s; cin >> s;
        int x; cin >> x; x--;
        cards[suite.find(s)][x] = true;
    }
    for(int i=0; i<4; i++){
        for(int j=0; j<13; j++) if(!cards[i][j]){
            cout << suite[i] << " " << j+1 << endl;
        }
    }
    
    return 0;
}