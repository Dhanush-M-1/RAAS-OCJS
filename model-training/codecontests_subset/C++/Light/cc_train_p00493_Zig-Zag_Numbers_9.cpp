#include <bits/stdc++.h>
using namespace std;
#define rep(i,a,n) for(int i=a; i<n; i++)
#define repq(i,a,n) for(int i=a; i<=n; i++)
#define repr(i,a,n) for(int i=a; i>=n; i--)
typedef long long int ll;
typedef pair<int, int> pii;
template<typename T> void chmax(T &a, T b) {a = max(a, b);}
template<typename T> void chmin(T &a, T b) {a = min(a, b);}
constexpr ll MOD = 10000LL;

// digit, mod, prev, neu-up-down, flag
// neu-up-down ... 0 -> neutral, 1 -> up, 2 -> down
ll dp[510][510][10][3][2];

ll solve(string s, int M, int less) {
    memset(dp, 0, sizeof(dp));
    dp[0][0][0][0][0] = 1;

    int N = s.length();
    rep(i,0,N) rep(j,0,M) rep(k,0,10) rep(l,0,3) rep(f,0,2) {
        int lim = f ? 9 : s[i] - '0';

        // neutral (l == 0 and k == 0)
        if(l == 0 && k == 0) {
            rep(x,0,lim+1) {
                int mo = (j*10+x) % M;
                (dp[i+1][mo][x][0][f || x < lim] += dp[i][j][k][l][f]) %= MOD;
            }
        }
        else {
            // (up, neutral) -> down
            if(l == 0 || l == 1) {
                rep(x,0,lim+1) {
                    if(x >= k) continue;
                    int mo = (j*10+x) % M;
                    (dp[i+1][mo][x][2][f || x < lim] += dp[i][j][k][l][f]) %= MOD;
                }
            }
            // (down, neutral) -> up
            if(l == 0 || l == 2) {
                rep(x,0,lim+1) {
                    if(x <= k) continue;
                    int mo = (j*10+x) % M;
                    (dp[i+1][mo][x][1][f || x < lim] += dp[i][j][k][l][f]) %= MOD;
                }
            }
        }
    }

    ll ret = 0;
    rep(k,0,10) rep(l,0,3) rep(f,0,2) {
        if(less == 1 && f == 0) continue;
        (ret += dp[N][0][k][l][f]) %= MOD;
    }
    return ret;
}

int main() {
    string A, B; cin >> A >> B;
    int M; cin >> M;

    ll ra = solve(A, M, 1);
    ll rb = solve(B, M, 0);
    cout << (rb - ra + MOD) % MOD << endl;
    return 0;
}