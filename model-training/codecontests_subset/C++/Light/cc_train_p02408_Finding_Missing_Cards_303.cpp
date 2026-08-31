#include <bits/stdc++.h>
#include <string.h>
#define rep(i, n) for(int i = 0; i<(n); i++)
using namespace std;
typedef long long ll;
//pi = 3.14159265358979323846

int main() {
    int n;
    cin >> n;
    int a[4][13] = {};
    int x, y;
    char c[] = "SHCD";
    char b;
    rep(i, n){
        cin >> b >> y;
            rep(j, 4) if(b == c[j]) x = j;
            a[x][y - 1] = 1;
    }
    rep(i, 4){
        rep(j, 13){
            if(a[i][j] == 0) cout << c[i] << " " << j + 1 << endl;
        }
    }
}



