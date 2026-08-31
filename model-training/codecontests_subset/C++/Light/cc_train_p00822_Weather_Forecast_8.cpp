#define  _CRT_SECURE_NO_WARNINGS
#pragma comment (linker, "/STACK:526000000")

#include "bits/stdc++.h"

using namespace std;
typedef string::const_iterator State;
#define eps 1e-11L
#define MAX_MOD 1000000007LL
#define GYAKU 500000004LL

#define MOD 998244353LL
#define seg_size 262144 * 4LL
#define pb push_back
#define mp make_pair
typedef long long ll;
#define REP(a,b) for(long long (a) = 0;(a) < (b);++(a))
#define ALL(x) (x).begin(),(x).end()

void init() {
    iostream::sync_with_stdio(false);
    cout << fixed << setprecision(20);
}


//#define int ll

unsigned long xor128() {
    static unsigned long x = 123456789, y = 362436069, z = 521288629, w = 88675123;
    unsigned long t = (x ^ (x << 11));
    x = y; y = z; z = w;
    return (w = (w ^ (w >> 19)) ^ (t ^ (t >> 8)));
}

int dp[9][7][7][7][7][500] = {};

void solve() {
    while (true) {

        int n;
        cin >> n;
        if (n == 0) return;
        REP(tea,9)
        REP(q, 7) {
            REP(t, 7) {
                REP(j, 7) {
                    REP(p, 7) {
                        REP(i,n+1)
                        dp[tea][q][t][j][p][i] = 0;
                    }
                }
            }
        }

        dp[4][1][1][1][1][0] = 1;
        const int dx[4] = { 1,0,-1,0 };
        const int dy[4] = { 0,1,0,-1 };
        REP(i, n) {
            vector<vector<int>> go;
            REP(q, 4) {
                go.push_back(vector<int>{});
                REP(j, 4) {
                    int a;
                    cin >> a;
                    go.back().push_back(a);
                }
            }

            REP(q, 9) {
                int x = q / 3;
                int y = q % 3;
                int die = 0;
                REP(t, 4) {
                    int nx = x + dx[t / 2];
                    int ny = y + dy[t % 2];
                    if (go[nx][ny] == 1) {
                        die = 1;
                    }
                }
                if (die == 0) continue;
                int tea = q;
                REP(q, 7) {
                    REP(t, 7) {
                        REP(j, 7) {
                            REP(p, 7) {
                                dp[tea][q][t][j][p][i] = 0;
                            }
                        }
                    }
                }
            }

            REP(x, 3) {
                REP(y, 3) {
                    REP(q, 7) {
                        REP(t, 7) {
                            REP(j, 7) {
                                REP(p, 7) {
                                    if (dp[x * 3 + y][q][t][j][p][i] == 0) continue;
                                    REP(dir, 4) {
                                        REP(cos, 4) {
                                            int new_x = x + dx[dir] * cos;
                                            int new_y = y + dy[dir] * cos;
                                            if (new_x >= 0 && new_x <= 2 && new_y >= 0 && new_y <= 2) {
                                                int nq = q + 1;
                                                int nt = t + 1;
                                                int nj = j + 1;
                                                int np = p + 1;
                                                if (new_x == 0 && new_y == 0) {
                                                    nq = 0;
                                                }
                                                if (new_x == 2 && new_y == 0) {
                                                    nt = 0;
                                                }
                                                if (new_x == 0 && new_y == 2) {
                                                    nj = 0;
                                                }
                                                if (new_x == 2 && new_y == 2) {
                                                    np = 0;
                                                }
                                                if (nq < 7 && nj < 7 && nt < 7 && np < 7) {
                                                    dp[new_x * 3 + new_y][nq][nt][nj][np][i + 1] = 1;
                                                }
                                            }
                                            else break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int ok = 0;
        REP(i,9)
        REP(q, 7) {
            REP(t, 7) {
                REP(j, 7) {
                    REP(p, 7) {
                        ok = max(ok, dp[i][q][t][j][p][n]);
                    }
                }
            }
        }
        cout << ok << endl;
    }
}

#undef int
int main() {
    init();
    solve();
}

