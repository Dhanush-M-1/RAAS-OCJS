#include<bits/stdc++.h>
using namespace std;
using ll = long long;

int main(void){
    bool f[4][14];
    fill(f[0], f[4], false);
    string m = "SHCD";
    int n;
    cin >> n;
    for(int i = 0; i < n; i++){
        string c;
        int num;
        cin >> c >> num;
        int j;
        for(j = 0; j < 4; j++) if(c[0] == m[j]) break;
        f[j][num] = true;
    }
    for(int i = 0; i < 4; i++){
        for(int j = 1; j < 14; j++){
            if(!f[i][j]) cout << m[i] << ' ' << j << endl;
        }
    }
    return 0;
}
