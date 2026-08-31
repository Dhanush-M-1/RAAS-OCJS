#include <bits/stdc++.h>
#pragma GCC optimization("O3")
using namespace std;
const long long inf = INT_MAX;
const long long inf2 = 1e18;
const long long minf = -1 * 1e9;
const long long MAX = 1e5 + 5;
const long long MOD = 1e9 + 7;
const double pi = acos(-1.0);
const double EPS = 1e-9;
void init(int precision) {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cout.setf(ios::fixed);
  cout.setf(ios::showpoint);
  cout.precision(precision);
}
inline void iofile() { freopen("input.txt", "r", stdin); }
long long n, a, b, c, ans;
int main() {
  init(10);
  cin >> n >> a >> b >> c;
  for (long long i = 0; i <= a; i++) {
    for (long long j = 0; j <= b; j++) {
      if (i & 1) continue;
      if (i / 2 + j <= n && n - (i / 2 + j) <= c * 2) {
        if ((n - i / 2 + j) % 2 == 0) ans++;
      }
    }
  }
  cout << ans << '\n';
}
