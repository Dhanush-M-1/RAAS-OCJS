#include <iostream>

using namespace std;

void solve(int n) {
    int ans = 0;
    string t; cin >> t;
    for(int i=0; i<n-1; i++) {
        string s; cin >> s;
        if(t[0]!=s[0] and t[1]==s[1]) ans++;
        t = s;
    }
    cout << ans << "\n";
}

int main() {
    int n;
    while(cin>>n && n) solve(n);
    return 0;
}