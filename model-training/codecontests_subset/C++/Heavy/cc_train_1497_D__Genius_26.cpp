#include<bits/stdc++.h>

using namespace std;

using ll = long long;
void solve() {
    int n; cin >> n;
    vector<int> tag(n), s(n);
    for (auto &i : tag) cin >> i;
    for (auto &i : s) cin >> i;

    vector<ll> dp(n);

    for (int i = 1; i < n; i++) {
        for (int j = i - 1; j >= 0; j--) {
            if (tag[i] == tag[j]) continue;
            ll x = dp[i], y = dp[j], val = abs(s[i] - s[j]);
            dp[i] = max(dp[i], y + val);
            dp[j] = max(dp[j], x + val);
        }
    }

    ll ans = 0;
    for (int i = 0; i < n; i++) ans = max(ans, dp[i]);
    cout << ans << "\n";
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int test; cin >> test;
    while (test--) solve();
}