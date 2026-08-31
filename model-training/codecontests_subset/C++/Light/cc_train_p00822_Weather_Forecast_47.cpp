#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using PII = pair<ll, ll>;
#define FOR(i, a, n) for (ll i = (ll)a; i < (ll)n; ++i)
#define REP(i, n) FOR(i, 0, n)
#define ALL(x) x.begin(), x.end()
template<typename T> void chmin(T &a, const T &b) { a = min(a, b); }
template<typename T> void chmax(T &a, const T &b) { a = max(a, b); }
struct FastIO {FastIO() { cin.tie(0); ios::sync_with_stdio(0); }}fastiofastio;
#ifdef DEBUG_ 
#include "../program_contest_library/memo/dump.hpp"
#else
#define dump(...)
#endif
const ll INF = 1LL<<60;

bool dp[366][9][7][7][7][7];
int main(void) {
    while(1) {
        ll n;
        cin >> n;
        if(!n) break;
        vector<vector<ll>> v(n, vector<ll>(16));
        REP(i, n) REP(j, 16) cin >> v[i][j];

        // REP(i, n) {
        //     cerr << "i:" << i << endl;
        //     REP(j, 4) {
        //         REP(k, 4) cerr << v[i][j*4+k] << " ";
        //         cerr << endl;
        //     }
        // }

        if(v[0][5] || v[0][6] || v[0][9] || v[0][10]) {
            cout << 0 << endl;
            continue;
        }

        REP(i, n) REP(j, 9) REP(d0, 7) REP(d1, 7) REP(d2, 7) REP(d3, 7) {
            dp[i][j][d0][d1][d2][d3] = false;
        }
        dp[0][4][1][1][1][1] = true;
        FOR(i, 1, n) REP(j0, 9) {
            const ll j = j0 + j0/3;
            const ll x = j%4, y = j/4; 
            REP(d0, 7) REP(d1, 7) REP(d2, 7) REP(d3, 7) {
                if(!dp[i-1][j0][d0][d1][d2][d3]) continue;
                REP(nj0, 9) {
                    const ll nj = nj0 + nj0/3;
                    const ll nx = nj%4, ny = nj/4;
                    if(abs(x-nx) + abs(y-ny) > 2) continue;
                    if(x!=nx && y!=ny) continue;
                    if(v[i][nj] || v[i][nj+1] || v[i][nj+4] || v[i][nj+5]) continue;

                    if(nj == 0 && d1<6 && d2<6 && d3<6) {
                        dp[i][nj0][0][d1+1][d2+1][d3+1] = true;
                    } else if(nj == 2 && d0<6 && d2<6 && d3<6) {
                        dp[i][nj0][d0+1][0][d2+1][d3+1] = true;
                    } else if(nj == 8 && d0<6 && d1<6 && d3<6) {
                        dp[i][nj0][d0+1][d1+1][0][d3+1] = true;
                    } else if(nj == 10 && d0<6 && d1<6 && d2<6) {
                        dp[i][nj0][d0+1][d1+1][d2+1][0] = true;
                    } else if(d0<6 && d1<6 && d2<6 && d3<6) {
                        dp[i][nj0][d0+1][d1+1][d2+1][d3+1] = true;
                    }
                }
            }
        }

        ll ret = 0;
        REP(i, 9) REP(d0, 7) REP(d1, 7) REP(d2, 7) REP(d3, 7) {
            if(dp[n-1][i][d0][d1][d2][d3]) {
                ret = 1;
            }
        }
        cout << ret << endl;
    }

    return 0;
}
