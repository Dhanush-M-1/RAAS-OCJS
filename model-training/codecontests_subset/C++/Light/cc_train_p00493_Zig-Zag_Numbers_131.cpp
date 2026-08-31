#include <bits/stdc++.h>
using namespace std;
template <class T> inline bool chmax(T &a, T b) {
    if(a < b) {
        a = b;
        return 1;
    }
    return 0;
}
template <class T> inline bool chmin(T &a, T b) {
    if(a > b) {
        a = b;
        return 1;
    }
    return 0;
}
typedef long long int ll;

#define ALL(v) (v).begin(), (v).end()
#define RALL(v) (v).rbegin(), (v).rend()
#define endl "\n"
const double EPS = 1e-7;
const int INF = 1 << 30;
const ll LLINF = 1LL << 60;
const double PI = acos(-1);
const int dx[4] = {1, 0, -1, 0};
const int dy[4] = {0, 1, 0, -1};

//-------------------------------------

const int MOD = 10000;

int dp[510][510][10][3][2];
int M;

int calc(string s) {
    memset(dp, 0, sizeof(dp));
    int n = s.size();
    int firstNum = s[0] - '0';
    for(int i = 0; i <= firstNum; i++) {
        if(i == firstNum) {
            dp[1][i % M][i][0][0] = 1;
        } else {
            dp[1][i % M][i][0][1] = 1;
        }
    }

    // i := 上からi桁目
    for(int i = 1; i < n; i++) {
        // j := Mで割ったあまり
        for(int j = 0; j < M; j++) {
            // k := 今の数字
            for(int k = 0; k < 10; k++) {
                // l := 増加中(2)or減少中(1)or変化なし(0)のフラグ
                for(int l = 0; l < 3; l++) {
                    // a := 次の数字
                    // flg == 1
                    for(int a = 0; a < 10; a++) {
                        int nr = (10 * j + a) % M;
                        if(l == 0) {
                            if(k == 0) {
                                (dp[i + 1][nr][a][0][1] += dp[i][j][k][l][1]) %=
                                    MOD;
                            } else {
                                if(a < k) {
                                    (dp[i + 1][nr][a][1][1] +=
                                     dp[i][j][k][l][1]) %= MOD;
                                }
                                if(a > k) {
                                    (dp[i + 1][nr][a][2][1] +=
                                     dp[i][j][k][l][1]) %= MOD;
                                }
                            }
                        } else if(l == 1 && a > k) {

                            (dp[i + 1][nr][a][2][1] += dp[i][j][k][l][1]) %=
                                MOD;
                        } else if(l == 2 && a < k) {
                            (dp[i + 1][nr][a][1][1] += dp[i][j][k][l][1]) %=
                                MOD;
                        }
                    }
                    // flg == 0
                    if(k > (int)(s[i - 1] - '0')) {
                        continue;
                    }
                    int limit = s[i] - '0';
                    for(int a = 0; a <= limit; a++) {
                        int nr = (10 * j + a) % M;
                        if(a == limit) {
                            if(l == 0) {
                                if(k == 0) {
                                    (dp[i + 1][nr][a][0][0] +=
                                     dp[i][j][k][l][0]) %= MOD;
                                } else {
                                    if(a < k) {
                                        (dp[i + 1][nr][a][1][0] +=
                                         dp[i][j][k][l][0]) %= MOD;
                                    }
                                    if(a > k) {
                                        (dp[i + 1][nr][a][2][0] +=
                                         dp[i][j][k][l][0]) %= MOD;
                                    }
                                }
                            } else if(l == 1 && a > k) {

                                (dp[i + 1][nr][a][2][0] += dp[i][j][k][l][0]) %=
                                    MOD;
                            } else if(l == 2 && a < k) {
                                (dp[i + 1][nr][a][1][0] += dp[i][j][k][l][0]) %=
                                    MOD;
                            }
                        } else {
                            if(l == 0) {
                                if(k == 0) {
                                    (dp[i + 1][nr][a][0][1] +=
                                     dp[i][j][k][l][0]) %= MOD;
                                } else {
                                    if(a < k) {
                                        (dp[i + 1][nr][a][1][1] +=
                                         dp[i][j][k][l][0]) %= MOD;
                                    }
                                    if(a > k) {
                                        (dp[i + 1][nr][a][2][1] +=
                                         dp[i][j][k][l][0]) %= MOD;
                                    }
                                }
                            } else if(l == 1 && a > k) {

                                (dp[i + 1][nr][a][2][1] += dp[i][j][k][l][0]) %=
                                    MOD;
                            } else if(l == 2 && a < k) {
                                (dp[i + 1][nr][a][1][1] += dp[i][j][k][l][0]) %=
                                    MOD;
                            }
                        }
                    }
                }
            }
        }
    }
    int res = 0;
    for(int i = 0; i < 10; i++) {
        for(int j = 0; j < 3; j++) {
            for(int k = 0; k < 2; k++) {
                (res += dp[n][0][i][j][k]) %= MOD;
            }
        }
    }
    res = (MOD + res - 1) % MOD;
    return res;
}

int check(string s) {
    int n = s.size();
    int now = 0;
    for(int i = 0; i < n; i++) {
        now = (10 * now + (int)(s[i] - '0')) % M;
    }
    if(now != 0) {
        return 0;
    }
    if(n == 1 && s != "0") {
        return 1;
    }
    if(n == 1 && s == "0") {
        return 0;
    }
    bool isZouka;
    int fi = s[0] - '0';
    int se = s[1] - '0';
    if(fi > se) {
        isZouka = false;
    } else if(fi < se) {
        isZouka = true;
    } else {
        return 0;
    }
    for(int i = 1; i < n - 1; i++) {
        fi = s[i] - '0';
        se = s[i + 1] - '0';
        if(fi > se && !isZouka) {
            return 0;
        }
        if(fi < se && isZouka) {
            return 0;
        }
        if(fi == se) {
            return 0;
        }
        isZouka = !isZouka;
    }
    return 1;
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(false);
    string a, b;
    cin >> a >> b >> M;
    int ans = (MOD + calc(b) - calc(a) + check(a)) % MOD;
    cout << ans << endl;
}
