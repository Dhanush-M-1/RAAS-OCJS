#include <bits/stdc++.h>
using namespace std;
#ifndef _LOCAL
//#pragma GCC optimize("O3,Ofast")
#else
#pragma GCC optimize("O0")
#endif
#define ttt template<typename t, typename u>
ttt inline void umin(t &a, const u b) {if(b < a) a = b;}
ttt inline void umax(t &a, const u b) {if(a < b) a = b;}
ttt vector<t>& operator<< (vector<t> &a, const u b) {a.push_back(t(b)); return a;}
typedef pair<int, int> pii;
typedef long long ll;
typedef long double ld;
typedef int8_t byte;
ll time() {return chrono::system_clock().now().time_since_epoch().count();}
mt19937 rnd(time());
#define ft first
#define sd second
#define len(f) int((f).size())
#define bnd(f) (f).begin(), (f).end()
#define _ <<' '<<
const int inf = 1e9 + 5;
const ll inf64 = 4e18 + 5;
const int md = 1e9 + 7;
namespace MD {
    void add(int &a, const int b) {if((a += b) >= md) a -= md;}
    void sub(int &a, const int b) {if((a -= b) < 0) a += md;}
    int prod(const int a, const int b) {return ll(a) * b % md;}
};

const int N = 2e5 + 5;
int f[10][N][10];
bool ready;

void solve() {
    if(!ready) {
        ready = true;
        for(int d = 0; d < 10; ++d) {
            f[d][0][d] = 1;
            for(int i = 1; i < N; ++i) {
                for(int j = 1; j < 10; ++j)
                    MD::add(f[d][i][j], f[d][i - 1][j - 1]);
                MD::add(f[d][i][0], f[d][i - 1][9]);
                MD::add(f[d][i][1], f[d][i - 1][9]);
            }
        }
    }
    int n, m;
    cin >> n >> m;
    int ans = 0;
    vector<int> t;
    if(!n) t << 0;
    while(n) t << n % 10, n /= 10;
    for(int i : t)
        for(int j = 0; j < 10; ++j)
            MD::add(ans, f[i][m][j]);
    cout << ans << endl;
}

signed main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#ifndef _LOCAL
//    freopen("file.in", "r", stdin);
//    freopen("file.out", "w", stdout);
#else
    system("color a");
    freopen("in.txt", "r", stdin);
#endif
    int t; cin >> t;
    while(t--)
    solve();
}
