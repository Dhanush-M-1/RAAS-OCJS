#include <bits/stdc++.h>
using namespace std;

#define DUMP(x) cerr << #x << "=" << x << endl
#define DUMP2(x, y) cerr<<"("<<#x<<", "<<#y<<") = ("<<x<<", "<<y<<")"<< endl
#define BINARY(x) static_cast<bitset<16> >(x)

#define rep(i,n) for(int i=0;i<(int)(n);i++)
#define REP(i,m,n) for (int i=m;i<(int)(n);i++)

#define in_range(x, y, w, h) (0<=(int)(x) && (int)(x)<(int)(w) && 0<=(int)(y) && (int)(y)<(int)(h))
#define ALL(a) (a).begin(),(a).end()

typedef long long ll;
const int INF = 1e9;
typedef pair<int, int> PII;
int dx[4]={0, -1, 1, 0}, dy[4]={-1, 0, 0, 1};

const int MOD = 10000;
int dp[501][500][10][3][2];

int M, L;
string N;

int solve(int n, int m, int last, int up, int same)
{
    if (n == L) return !m;
    if (dp[n][m][last][up][same] != -1) return dp[n][m][last][up][same];

    int res = 0;
    rep(d, 10) {

        int nsame = 0;
        if (same && d > N[n] - '0') break;
        if (same && d == N[n] - '0') nsame = 1;

        int nup = (up + 1) % 2;
        if (up == 0 && last >= d) continue;
        if (up == 1 && last <= d) continue;
        if (up == 2 && last && last == d) continue;

        if (up == 2) {
            if (last == 0) nup = 2;
            else if (last < d) nup = 1;
            else if (last > d) nup = 0;
            else assert(false);
        }
        res += solve(n+1, (m * 10 + d) % M, d, nup, nsame);
        res %= MOD;
    }

    return dp[n][m][last][up][same] = res;
}


/**
int calc(string N, int M)
{
    int L = N.size();
    memset(dp, 0, sizeof(dp));

    dp[0][0][0][2][1] = 1;
    rep(i, L) rep(m, M) rep(last, 10) rep(up, 3) rep(same, 2) {
        if (dp[i][m][last][up][same] == 0) continue;

        rep(d, 10) {
            int nup = (up + 1) % 2;
            if (up == 0 && last >= d) continue;
            if (up == 1 && last <= d) continue;
            if (up == 2) {
                if (last == 0) nup = 2;
                else if (last < d) nup = 1;
                else if (last > d) nup = 0;
                else continue;
            }

            int nsame = 0;
            if (same && d > N[i] - '0') break;
            if (same && d == N[i] - '0') nsame = 1;

            dp[i+1][(m*10 + d) % M][d][nup][nsame] += dp[i][m][d][up][same];
            // dp[i+1][(m*10 + d) % M][d][nup][nsame] %= MOD;
            cerr << "A" << endl;
        }
    }

#if 1
    rep(i, L) rep(m, M) rep(last, 10) rep(up, 3) rep(same, 2) {
        cerr << i+1 << " " << m << " " << last << " " << up << " " << same << " : ";
        cerr << dp[i+1][m][last][up][same] << endl;
    }
#endif

    int res = 0;
    rep(last, 10) rep(up, 2) rep(same, 2) {
        res += dp[L][0][last][up][same];
    }
    return res - 1;
}
*/

int main()
{
    /*
    int M;
    string A, B;
    cin >> A >> B >> M;
    cout << calc(B, M) - calc(A, M) + sim(A, true) + sim(A, false) << endl;
    */

    string A, B;
    cin >> A >> B >> M;

    // A -= 1
    for (int i=A.size()-1; i>=0; i--) {
        if (A[i] == '0') A[i] = '9';
        else {
            A[i]--;
            break;
        }
    }

    N = A;
    L = N.size();
    memset(dp, -1, sizeof(dp));
    int tmpa = solve(0, 0, 0, 2, 1);

    N = B;
    L = N.size();
    memset(dp, -1, sizeof(dp));
    int tmpb = solve(0, 0, 0, 2, 1);

    cout << (tmpb - tmpa + MOD) % MOD << endl;
}