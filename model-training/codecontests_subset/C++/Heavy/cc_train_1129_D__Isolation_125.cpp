#include <bits/stdc++.h>
using namespace std;
const int MOD = 119 << 23 | 1;
const int FFTMOD = 119 << 23 | 1;
const int INF = (int)1e9 + 23111992;
const long long LINF = (long long)1e18 + 23111992;
const long double PI = acos((long double)-1);
const long double EPS = 1e-9;
inline long long gcd(long long a, long long b) {
  long long r;
  while (b) {
    r = a % b;
    a = b;
    b = r;
  }
  return a;
}
inline long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
inline long long fpow(long long n, long long k, int p = MOD) {
  long long r = 1;
  for (; k; k >>= 1) {
    if (k & 1) r = r * n % p;
    n = n * n % p;
  }
  return r;
}
template <class T>
inline int chkmin(T& a, const T& val) {
  return val < a ? a = val, 1 : 0;
}
template <class T>
inline int chkmax(T& a, const T& val) {
  return a < val ? a = val, 1 : 0;
}
inline unsigned long long isqrt(unsigned long long k) {
  unsigned long long r = sqrt(k) + 1;
  while (r * r > k) r--;
  return r;
}
inline long long icbrt(long long k) {
  long long r = cbrt(k) + 1;
  while (r * r * r > k) r--;
  return r;
}
inline void addmod(int& a, int val, int p = MOD) {
  if ((a = (a + val)) >= p) a -= p;
}
inline void submod(int& a, int val, int p = MOD) {
  if ((a = (a - val)) < 0) a += p;
}
inline int mult(int a, int b, int p = MOD) { return (long long)a * b % p; }
inline int inv(int a, int p = MOD) { return fpow(a, p - 2, p); }
inline int sign(long double x) { return x < -EPS ? -1 : x > +EPS; }
inline int sign(long double x, long double y) { return sign(x - y); }
mt19937 mt(chrono::high_resolution_clock::now().time_since_epoch().count());
inline int myrand() { return abs((int)mt()); }
const int maxn = 1e5 + 5;
const int magic = 500;
int n, k;
int a[maxn];
int nxt[maxn];
int off[magic];
int c[maxn];
int f[magic][maxn];
int dp[maxn];
int sum;
void inc(int d) {
  if (0 <= k - off[d] && k - off[d] < maxn) {
    submod(sum, f[d][k - off[d]]);
  }
  off[d]++;
}
void dec(int d) {
  off[d]--;
  if (0 <= k - off[d] && k - off[d] < maxn) {
    addmod(sum, f[d][k - off[d]]);
  }
}
void upd(int d, int l, int r, int val) {
  for (int i = d * magic; i < (d + 1) * magic && i < n; i++) {
    if (c[i] + off[d] <= k) {
      submod(sum, f[d][c[i]]);
    }
    f[d][c[i]] = 0;
    c[i] += off[d];
  }
  off[d] = 0;
  for (int i = l; i <= r; i++) {
    c[i] += val;
  }
  for (int i = d * magic; i < (d + 1) * magic && i < n; i++) {
    addmod(f[d][c[i]], dp[i + 1]);
    if (c[i] <= k) {
      addmod(sum, dp[i + 1]);
    }
  }
}
void upd(int l, int r, int val) {
  int il = (l + magic - 1) / magic;
  int ir = r / magic;
  for (int i = (il); i < (ir); ++i) {
    if (val == 1) {
      inc(i);
    } else {
      dec(i);
    }
  }
  if (l < il * magic) {
    upd(il - 1, l, min(il * magic - 1, r), val);
  }
  if (il <= ir && ir * magic <= r) {
    upd(ir, max(l, ir * magic), r, val);
  }
}
void chemthan() {
  cin >> n >> k;
  for (int i = (0); i < (n); ++i) cin >> a[i];
  dp[n] = 1;
  vector<int> lst(n + 1, n);
  fill_n(nxt, n + 1, n);
  for (int i = (n)-1; i >= (0); --i) {
    addmod(sum, dp[i + 1]);
    addmod(f[i / magic][0], dp[i + 1]);
    nxt[i] = lst[a[i]];
    if (nxt[i] == n) {
      upd(i, nxt[i] - 1, 1);
    } else {
      int ni = nxt[i];
      upd(ni, nxt[ni] - 1, -1);
      upd(i, ni - 1, 1);
    }
    dp[i] = sum;
    lst[a[i]] = i;
  }
  cout << dp[0] << "\n";
}
int main(int argc, char* argv[]) {
  ios_base::sync_with_stdio(0), cin.tie(0);
  if (argc > 1) {
    assert(freopen(argv[1], "r", stdin));
  }
  if (argc > 2) {
    assert(freopen(argv[2], "wb", stdout));
  }
  chemthan();
  cerr << "\nTime elapsed: " << 1000 * clock() / CLOCKS_PER_SEC << "ms\n";
  return 0;
}
