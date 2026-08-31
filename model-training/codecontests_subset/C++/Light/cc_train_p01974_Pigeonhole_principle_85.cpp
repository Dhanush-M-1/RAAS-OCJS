#include <bits/stdc++.h>
using namespace std;
using ll = long long;
#define REP(i,n) for (ll i = 0, i##_len = (n); i < i##_len; i++)

int main() {

    ll n; cin >> n;
    vector<ll> a(n);
    REP(i, n) cin >> a[i];

    vector<ll> dp(n-1, -1);
    for (ll ai : a) {
        if (dp[ai % (n-1)] == -1) {
            dp[ai % (n-1)] = ai;
        } else {
            cout << ai << " ";
            cout << dp[ai % (n-1)] << endl;
            return 0;
        }
    }

}
