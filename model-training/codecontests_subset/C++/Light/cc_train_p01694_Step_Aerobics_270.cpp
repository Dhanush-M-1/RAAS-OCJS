#include<bits/stdc++.h>
using namespace std;
#define rep(i, n) for(int i=0;i<n;++i)
#define rep2(i, a, b) for(int i=(a);i<=(b);++i)

int main(){
    while(1){
        int n;
        cin >> n;
        if(!n) break;
        vector<string> s(n);
        rep(i, n) cin >> s[i];
        int ans = 0;
        rep(i, n / 2) {
            if(s[i * 2][0] != s[i * 2 + 1][0]) ans++;
        }
        cout << ans << "\n";
    }
}

