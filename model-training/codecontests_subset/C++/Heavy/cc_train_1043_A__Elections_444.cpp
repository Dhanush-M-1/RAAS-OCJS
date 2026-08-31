#include <bits/stdc++.h>
using namespace std;
long long INFLL = (long long)4e18, MOD = 1e9 + 7;
const int INF = 0x3f6f6f6f;
vector<vector<int> > adj;
vector<int> vis, color, level, temp_color;
int dx8[] = {0, 1, 1, 1, 0, -1, -1, -1}, dy8[] = {1, 1, 0, -1, -1, -1, 0, 1},
    dx4[] = {0, 1, 0, -1}, dy4[] = {1, 0, -1, 0};
inline long long mexp(long long x, long long n, long long m = MOD) {
  long long res = 1;
  x %= m;
  while (n) {
    if (n & 1) res = (res * x) % m;
    n >>= 1;
    x = (x * x) % m;
  }
  return res;
}
inline bool ispow2(long long x) { return x && (!(x & (x - 1))); }
inline long long gcd(long long a, long long b) {
  while (a > 0 && b > 0) {
    if (a > b)
      a %= b;
    else
      b %= a;
  }
  return a + b;
}
int32_t main(void) {
  cout << fixed;
  cerr << fixed;
  cout << setprecision(10);
  cerr << setprecision(3);
  mt19937 genr(chrono::high_resolution_clock::now().time_since_epoch().count());
  int n;
  cin >> n;
  long long sum = 0, mx = -1;
  for (int i = 0; i < n; ++i) {
    long long t;
    cin >> t;
    mx = max(mx, t);
    sum += t;
  };
  ;
  cout << max(mx, (long long)ceil((2 * sum) / n) + 1) << '\n';
  return 0;
}
