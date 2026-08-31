#include "bits/stdc++.h"
#define rep(i,n) for(int i=0;i<n;i++)
using namespace std;

typedef long long ll;

int main() {
    int N, M, a, MOD = 1e9 + 7;
    cin >> N >> M;
    vector<int> dp(N + 1, 1);
    rep(i, M) {
        cin >> a;
        dp[a] = 0;
    }
    for (int i = 2; i <= N; i++) {
        if (dp[i] != 0) dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
    }
    cout << dp[N] << endl;
}