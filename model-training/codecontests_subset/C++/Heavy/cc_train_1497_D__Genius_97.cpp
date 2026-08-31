#include <iostream>
#include <cmath>
#include <iomanip>
#include <algorithm>
#include <vector>

using namespace std;

void solve() {
    int n;
    cin >> n;
    vector <int> t(n), s(n);
    for (auto &u : t)
        cin >> u;
    for (auto &u : s) 
        cin >> u;

    vector <long long> dp(n, 0);
    for (int i = 0; i < n; i++) {
        for (int j = i; j > -1; j--) {
            if (t[i] != t[j]) {
                int tmp = abs(s[i] - s[j]);
                long long back_i = dp[i];
                dp[i] = max(dp[i], dp[j] + tmp);
                dp[j] = max(dp[j], back_i + tmp);
            }
        }
    }
    cout << *max_element(dp.begin(), dp.end()) << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int t = 1;
    cin >> t;
    while (t--) solve();
}