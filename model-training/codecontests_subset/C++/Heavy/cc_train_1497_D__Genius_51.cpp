#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    int t;
    cin >> t;

    while(t--) {
        int n;
        cin >> n;
        vector<int> tag(n);
        for(int i = 0; i < n; i++) cin >> tag[i];
        vector<int> s(n);
        for(int i = 0; i < n; i++) cin >> s[i];
        vector<ll> dp(n, 0);
        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(tag[i] == tag[j]) continue;
                ll t1 = dp[j] + abs(s[i] - s[j]);
                ll t2 = dp[i] + abs(s[i] - s[j]);
                dp[i] = max(dp[i], t1);
                dp[j] = max(dp[j], t2);
            }
        }
        cout << *max_element(dp.begin(), dp.end()) << "\n";
    }

    return 0;
}