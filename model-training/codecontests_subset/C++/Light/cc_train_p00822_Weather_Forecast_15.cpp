#include <bits/stdc++.h>

using namespace std;

#define REP(i, n) for (int i = 0; i < (n); i++)
#define FOR(i, m, n) for (int i = (m); i < (n); i++)
#define int long long

bool dp[400][10][7][7][7][7];
bool wed[400][17];

int dx[4] = {0, 0, 1, 1}, dy[4] = {0, 1, 0, 1};

int dxx[9] = {-2, -1, 0, 1, 2, 0, 0, 0, 0}, dyy[9] = {0, 0, 0, 0, 0, -2, -1, 1, 2};
int pos[9] = {0, 1, 2, 4, 5, 6, 8, 9, 10};
bool solve() {
    int N;
    cin >> N;
    if (N == 0) return false;
    REP(i, N + 1) {
        REP(j, 10) REP(a, 7) REP(b, 7) REP(c, 7) REP(d, 7) { dp[i][j][a][b][c][d] = false; }
    }
    REP(i, N) {
        REP(j, 16) { cin >> wed[i][j]; }
    }
    // REP(i, N) {
    //     REP(j, 16) { cout << wed[i][j] << " "; }
    //     cout << endl;
    // }
    dp[0][4][1][1][1][1] = true;
    REP(k, 4) {
        if (wed[0][pos[4] + dx[k] * 4 + dy[k]]) dp[0][4][1][1][1][1] = false;
    }
    REP(i, N - 1) {
        REP(j, 9) {
            REP(a, 7) REP(b, 7) REP(c, 7) REP(d, 7) {
                if (!dp[i][j][a][b][c][d]) continue;
                int x = j / 3, y = j % 3;
                REP(k, 9) {
                    int nx = x + dxx[k], ny = y + dyy[k];
                    int nj = nx * 3 + ny;
                    if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
                    int np = pos[nj];
                    assert(np + 5 < 16);
                    if (wed[i + 1][np] || wed[i + 1][np + 1] || wed[i + 1][np + 4] || wed[i + 1][np + 4 + 1]) continue;
                    int na = a + 1, nb = b + 1, nc = c + 1, nd = d + 1;

                    if (np == 0) na = 0;
                    if (np == 2) nb = 0;
                    if (np == 8) nc = 0;
                    if (np == 10) nd = 0;

                    if (na >= 7 || nb >= 7 || nc >= 7 || nd >= 7) continue;

                    dp[i + 1][nj][na][nb][nc][nd] = true;
                }
            }
        }
    }
    bool ok = false;
    REP(j, 9) REP(a, 7) REP(b, 7) REP(c, 7) REP(d, 7) {
        if (dp[N - 1][j][a][b][c][d]) ok = true;
    }
    if (ok)
        cout << 1 << endl;
    else
        cout << 0 << endl;
    return true;
}
signed main() {
    while (solve())
        ;
    // solve();
}
