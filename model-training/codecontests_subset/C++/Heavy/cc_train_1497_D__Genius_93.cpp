#include <bits/stdc++.h>

using namespace std;

#define f first
#define s second
#define pb push_back
#define int long long
#define ld long double
#define pi pair<int, int>
#define sz(x) (int)x.size()
#define all(x) x.begin(),x.end()

const int N = 5e3 + 5,mod = 1e9 + 7;
const int big = 1e18;

int n, tg[N], s[N], dp[N];

signed main() {
    ios_base::sync_with_stdio(0), cin.tie(0);
    int t; cin >> t;
    while(t--) {
        cin >> n;
        for(int i = 1; i <= n; i++) cin >> tg[i];
        for(int i = 1; i <= n; i++) cin >> s[i];
        for(int i = 1; i <= n; i++) dp[i] = 0;
        for(int j = 2; j <= n; j++) {
            for(int i = j - 1; i; i--) {
                if(tg[i] == tg[j]) continue;
                int cost = abs(s[i] - s[j]);
                int idp = dp[i], jdp = dp[j];
                dp[i] = max(dp[i], jdp + cost);
                dp[j] = max(dp[j], idp + cost);
            }
        }
        cout << *max_element(dp + 1,dp + n + 1) << "\n";
    }
}   