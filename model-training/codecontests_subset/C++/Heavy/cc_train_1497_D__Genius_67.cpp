#include <bits/stdc++.h>
using namespace std;

#define all(n)      for(ll i=0; i<ll(n); i++)
#define pb          push_back
#define F           first
#define S           second
#define FIO         ios::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define deb(...)    << "[" << #__VA_ARGS__ ": " << (__VA_ARGS__) << "] "

#define int long long
using ll = long long;

void test_case() {
    int n;
    cin >> n;
    int tag[n], s[n];
    all(n) cin >> tag[i];
    all(n) cin >> s[i];

    vector<int> dp(n+1);

    for(int i=0; i<n; i++) {
        vector<int> c(i, LLONG_MIN), g(i, LLONG_MIN), mxc(i+1);

        for(int cum=0; cum<i; cum++) {
            if(tag[i] != tag[cum]) c[cum] = dp[cum]+abs(s[i]-s[cum]);
        }

        for(int go=i-1; go>=0; go--) {
            if(tag[i] != tag[go]) g[go] = abs(s[i]-s[go]);
        }

        for(int j=i-1; j>=0; j--) mxc[j] = max(c[j], mxc[j+1]);

        for(int j=0; j<i; j++) {
            if(tag[i] != tag[j]) dp[j] = max(dp[j], g[j]+mxc[j+1]);
        }

        dp[i] = mxc[0];

        // res = max(res, dp[i]);

    }

    int res = 0;
    all(n) res = max(res, dp[i]);

    cout << res << '\n';
}

signed main() {
    FIO;

    int t=1;
    cin >> t;
    while(t--) test_case();
}
