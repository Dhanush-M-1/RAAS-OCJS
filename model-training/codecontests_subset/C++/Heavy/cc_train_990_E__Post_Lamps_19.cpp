#include <bits/stdc++.h>
using namespace std;
const int MOD = (int)1e9 + 7;
const int FFTMOD = 1007681537;
const int INF = (int)1e9;
const long long LINF = (long long)1e18;
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
inline long long isqrt(long long k) {
  long long r = sqrt(k) + 1;
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
const int maxn = 1e6 + 5;
int n, m, k;
int f[maxn];
int a[maxn];
int lst[maxn];
void volamtruyenkyii() {
  cin >> n >> m >> k;
  for (int i = (0); i < (m); ++i) {
    int x;
    cin >> x;
    f[x] = 1;
  }
  f[n] = 1;
  for (int i = (1); i < (k + 1); ++i) cin >> a[i];
  if (f[0]) {
    cout << -1 << "\n";
    return;
  }
  int tmp = 0;
  for (int i = (1); i < (n + 1); ++i) {
    if (!f[i]) tmp = i;
    lst[i] = tmp;
  }
  long long res = LINF;
  for (int i = (1); i < (k + 1); ++i) {
    int st = 0, cnt = 0;
    while (st < n) {
      if (!f[st]) {
        cnt++;
        st += i;
      } else {
        int pv = lst[st];
        if (pv + i <= st) {
          cnt = -1;
          break;
        } else {
          cnt++;
          st = pv + i;
        }
      }
    }
    if (cnt >= 0) {
      chkmin(res, (long long)cnt * a[i]);
    }
  }
  if (res == LINF) res = -1;
  cout << res << "\n";
}
int main(int argc, char* argv[]) {
  ios_base::sync_with_stdio(0), cin.tie(0);
  if (argc > 1) {
    assert(freopen(argv[1], "r", stdin));
  }
  if (argc > 2) {
    assert(freopen(argv[2], "wb", stdout));
  }
  volamtruyenkyii();
  cerr << "\nTime elapsed: " << 1000 * clock() / CLOCKS_PER_SEC << "ms\n";
  return 0;
}
