#include <bits/stdc++.h>
#pragma GCC optimize("O2")
long long poww(long long a, long long b, long long md) {
  return (!b ? 1
             : (b & 1 ? a * poww(a * a % md, b / 2, md) % md
                      : poww(a * a % md, b / 2, md) % md));
}
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
using namespace std;
const int maxn = 1000 * 100 + 5;
const long long inf = 9223372036854775807;
const long long mod = 1e9 + 7;
const long long Log = 22;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int t;
  cin >> t;
  while (t--) {
    int mark[1001];
    memset(mark, 0, sizeof mark);
    int n, m, ans = -1;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
      int x;
      cin >> x;
      mark[x] = 1;
    }
    for (int i = 1; i <= m; i++) {
      int x;
      cin >> x;
      if (mark[x]) {
        ans = x;
      }
    }
    if (ans != -1) {
      cout << "YES" << endl << 1 << ' ' << ans << endl;
    } else
      cout << "NO" << endl;
  }
}
