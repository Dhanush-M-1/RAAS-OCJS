#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
#include <chrono>
#include <random>
#include <unordered_set>
#include <unordered_map>

using namespace std;

typedef long long ll;

void solve() {
    int n;
    cin >> n;
    vector<int> type(n);
    for (int i = 0; i < n; i++) {
        cin >> type[i];
    }

    vector<int> s(n);
    for (int i = 0; i < n; i++) {
        cin >> s[i];
    }

    vector<ll> dp(n);

    for (int i = 0; i < n; i++) {
        for (int j = i - 1; j >= 0; j--) {
            if (type[i] != type[j]) {
                ll t = dp[j];
                dp[j] = max(dp[j], dp[i] + abs(s[i] - s[j]));
                dp[i] = max(dp[i], t + abs(s[i] - s[j]));
            }
        }
    }

    ll ans = 0;
    for (int i = 0; i < n; i++) {
        ans = max(ans, dp[i]);
    }

    cout << ans;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
#if defined(_DEBUG)
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int q = 1;
    cin >> q;
    for (; q > 0; q--) {
        solve();
        cout << endl;
    }
}