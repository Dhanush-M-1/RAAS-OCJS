#include <iostream>
#include <cstdlib>
using namespace std;

#define FOR(i,a,b) for(int i=(a);i<(int)(b);i++)
#define rep(i,n) FOR(i,0,n)
#define dbg(x) cout<<#x<<": "<<(x)<<"\n"

void solve(string n) {
    int cnt = 0;
    while(stoi(n) > 9) {
        int m = n.size();
        int ma = -1;
        for(int i=1; i<m; i++) {
            string s1 = n.substr(0,i);
            string s2 = n.substr(i,m-i);
            if(stoi(s1) * stoi(s2) > ma) {
                ma = stoi(s1) * stoi(s2);
            }
        }
        n = to_string(ma);
        cnt++;
    }
    cout << cnt << "\n";
}

int main() {
    int q; cin>>q;
    rep(i,q) {
        string n; cin>>n;
        solve(n);
    }
    return 0;
}