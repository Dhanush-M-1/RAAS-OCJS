#pragma GCC optimize(2)
#include <bits/stdc++.h>
#define all(n) (n).begin(), (n).end()
#define se second
#define fi first
#define pb emplace_back
#define mp make_pair
#define sqr(n) ((n)*(n))
#define rep(i, a, b) for (int i = (a); i <= (b); ++i)
#define per(i, a, b) for (int i = (a); i >= (b); --i)
#define precision(a) setiosflags(ios::fixed) << setprecision(a)
#define IOS ios::sync_with_stdio(false);cin.tie(0);cout.tie(0)
using namespace std;
typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> PII;
typedef pair<ll, ll> PLL;
typedef vector<int> VI;
typedef vector<long long> VL;
typedef double db;

template <typename T> inline char read(T &x) {
    x = 0; T fg = 1; char ch = getchar();
    while (!isdigit(ch)) {if (ch == '-') fg = -1;ch = getchar();}
    while (isdigit(ch)) x = (x << 3) + (x << 1) + (ch ^ '0'), ch = getchar();
    x = fg * x; return ch;
}
template <typename T, typename... Args> inline void read(T &x, Args &... args) { read(x), read(args...); }
template <typename T> inline void write(T x) {
    int len = 0; char c[21]; if (x < 0) putchar('-'), x = -x;
    do{++len; c[len] = x % 10 + '0';} while (x /= 10);
    for (int i = len; i >= 1; i--) putchar(c[i]);
}
template <typename T, typename... Args> inline void write(T& x, Args &... args) { write(x), write(args...); }

template<class T1, class T2> bool umin(T1& a, T2 b) { return a > b ? (a = b, true) : false; }
template<class T1, class T2> bool umax(T1& a, T2 b) { return a < b ? (a = b, true) : false; }
template<class T> void clear(T& a) { T().swap(a); }

const int N = 5e3 + 5;

int n, m, _, k, cas;
ll a[N], s[N], d[2][N];

int main() {
    IOS;
    for (cin >> _; _; --_) {
        cin >> n;
        rep (i, 1, n) cin >> a[i], d[0][i] = -1e18;
        rep (i, 1, n) cin >> s[i];
        rep (i, 1, n) {
            rep (j, 1, n) d[i & 1][j] = d[i & 1 ^ 1][j]; d[i & 1][i] = 0;
            per (j, i - 1, 1) if (a[i] ^ a[j])
                umax(d[i & 1][j], d[i & 1][i] + abs(s[i] - s[j])),
                umax(d[i & 1][i], d[i & 1 ^ 1][j] + abs(s[i] - s[j]));
            umax(d[i & 1][i], d[i & 1 ^ 1][i]);
        }
        cout << *max_element(d[n & 1], d[n & 1] + n + 1) << '\n';
    }
    return 0;
}