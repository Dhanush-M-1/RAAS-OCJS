#include <bits/stdc++.h>

using namespace std;

int dp[10000000];

int solve(int n) {

    if(dp[n] != -1) {
        return dp[n];
    }

    if(n < 10) {
        return 0;
    }

    int nn= 0;

    for(int i = (int)log10(n); i > 0; --i) {
        nn = max(nn, (n / (int)pow((double)10, i)) * (n % (int)pow((double)10, i)));
    }

    return dp[n] = solve(nn) + 1;

}

int main() {

    int q, n;

    memset(dp, -1, sizeof(dp));

    cin >> q;

    for(int i = 0; i < q; ++i) {
        cin >> n;
        cout << solve(n) << endl;
    }

}