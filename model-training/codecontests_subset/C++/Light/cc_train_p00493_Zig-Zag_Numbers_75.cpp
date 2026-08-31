#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef unsigned __int128 HASH;
typedef pair<int,int> pii;
typedef pair<ll, ll> pll;
typedef pair<ull, ull> pullull;
typedef pair<ll,int> plli;
typedef pair<double, int> pdbi;
typedef pair<int,pii> pipii;
typedef vector<int> vi;
typedef vector<ll> vll;
typedef vector<vi> vvi;
typedef vector<vvi> vvvi;
typedef vector<pii> vpii;
typedef vector<vector<int>> mat;

#define rep(i,n) for (int i=0;i<(n);i++)
#define rep2(i,a,b) for (int i=(a);i<(b);i++)
#define rrep(i,n) for (int i=(n);i>0;i--)
#define rrep2(i,a,b) for (int i=(a);i>b;i--)
#define pb push_back
#define fi first
#define se second
#define all(a) (a).begin(),(a).end()
#define rall(a) (a).rbegin(),(a).rend()

const ll hmod1 = 999999937;
const ll hmod2 = 1000000000 + 9;
const ll INF = 1<<30;
const ll mod = 10000;
const int dx4[4] = {1, 0, -1, 0};
const int dy4[4] = {0, 1, 0, -1};
const int dx8[8] = {1, 1, 1, 0, 0, -1, -1, -1};
const int dy8[8] = {0, 1, -1, 1, -1, 0, 1, -1};
const double pi = 3.141592653589793;

//#define int long long
#define addm(X, Y) ((X) = ((X) + (Y) % mod) % mod)

string a, b;
ll dp1[2][2][10][2][2][500 + 5], dp2[2][2][10][2][2][500 + 5];
int mo;

signed main(){
    cin.tie(0);
    ios::sync_with_stdio(false);
    cin >> a >> b >> mo;

    dp1[0][0][0][0][0][0] = 1;
    dp1[0][0][0][1][0][0] = 1;
    int cur = 1, pre = 0;
    rep(i, b.size()){
        rep(j, 2)rep(d, 10)rep(l, 2)rep(z, 2)rep(m, mo) dp1[cur][j][d][l][z][m] = 0;
        rep(j, 2) {
            int lim = j ? 9 : b[i] - '0';
            rep(d, lim + 1)rep(k, 10)rep(z, 2) {
                if (z != 0 && d == k) continue;
                rep(l, 2) {
                    if (z != 0 && ((l == 0 && d < k) || (l == 1 && k < d))) continue;
                    rep(m, mo) {
                        if (z == 0 && d == 0) dp1[cur][1][0][l^1][0][0] = 1;
                        else addm(dp1[cur][j || d < lim][d][l^1][1][(10 * m + d) % mo], dp1[pre][j][k][l][z][m]);
                    }
                }
            }
        }
        swap(cur, pre);
    }
    int b_end = pre;

    dp2[0][0][0][0][0][0] = 1;
    dp2[0][0][0][1][0][0] = 1;
    cur = 1;
    pre = 0;
    rep(i, a.size()) {
        rep(j, 2)rep(d, 10)rep(l, 2)rep(z, 2)rep(m, mo) dp2[cur][j][d][l][z][m] = 0;
        rep(j, 2) {
            int lim = j ? 9 : a[i] - '0';
            rep(d, lim + 1)rep(k, 10)rep(z, 2) {
                if (z != 0 && d == k) continue;
                rep(l, 2) {
                    if (z != 0 && ((l == 0 && d < k) || (l == 1 && k < d))) continue;
                    rep(m, mo) {
                        if (z == 0 && d == 0) dp2[cur][1][0][l^1][0][0] = 1;
                        else addm(dp2[cur][j || d < lim][d][l^1][1][(10 * m + d) % mo], dp2[pre][j][k][l][z][m]);
                    }
                }
            }
        }
        swap(cur, pre);
    }
    int a_end = pre;

    ll ans = 0;
    rep(j, 2)rep(d, 10)rep(z, 2)rep(l, 2) addm(ans, dp1[b_end][j][d][l][z][0]);
    rep(j, 2)rep(d, 10)rep(z, 2)rep(l, 2) ans = (ans - dp2[a_end][j][d][l][z][0] + 2 * mod) % mod;

    if (a.size() == 1) {
        if (stoi(a) % mo == 0) addm(ans, 1);
        if (b.size() == 1) {
            rep2(i, stoi(a) + 1, stoi(b) + 1) {
                if (i % mo != 0) continue;
                ans = (ans - 1 + mod) % mod;
            }
        }
        else {
            rep2(i, stoi(a) + 1, 10) {
                if (i % mo != 0) continue;
                ans = (ans - 1 + mod) % mod;
            }
        }
    }
    else {
        rep(l, 2) addm(ans, dp2[a_end][0][a[a.size() - 1] - '0'][l][1][0]);
    }
    cout << ans << endl;
}