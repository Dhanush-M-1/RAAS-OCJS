#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

const int N = 233333;
const ll mod = 1e9 + 7;

ll dp[10][N];
int main() {
    int m = 200011;
    for(int i = 0; i <= 9; ++i) dp[i][0] = 1;
    for(int i = 1; i <= m; ++i) {
        for(int d = 0; d <= 9; ++d) {
            if(d <= 8) {
                dp[d][i] = dp[d+1][i-1];
            } else {
                dp[d][i] = (dp[1][i-1] + dp[0][i-1]) % mod;
            }
        }
    }
    int T, n, k;
    cin >> T;
    while(T--) {
        scanf("%d %d", &n, &k);
        int x = n;
        ll ans = 0;
        while(x) {
            int bit = x % 10;
            x /= 10;
            ans = (ans + dp[bit][k]) % mod;
        }
        printf("%lld\n", (ans+mod) % mod);
    }
}