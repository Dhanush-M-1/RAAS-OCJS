#include <bits/stdc++.h>
using namespace std;
const int INF = 1e18;
const int mod = 1e9 + 7;
const int N = 2e5 + 10;
inline int add(int x, int y) {
  x += y;
  if (x >= mod) x -= mod;
  return x;
}
inline int mul(int x, int y) {
  x = (1LL * x * y) % mod;
  return x;
}
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
int mat[5201][1301];
int dp[5201][5201];
int n;
int get(int i, int j) {
  int jj = (j - 1) / 4 + 1;
  int pos = 3 - (j - 1) % 4;
  return ((mat[i][jj] & (1 << pos)) > 0 ? 1 : 0);
}
int get2(int a, int b, int c, int d) {
  return (dp[c][d] - dp[a - 1][d] - dp[c][b - 1] + dp[a - 1][b - 1]);
}
void pre() {
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= n; ++j) {
      dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + get(i, j);
    }
  }
}
bool check(int x) {
  for (int r = 1; r <= n / x; ++r) {
    for (int cc = 1; cc <= n / x; ++cc) {
      int a = (r - 1) * x + 1;
      int b = (cc - 1) * x + 1;
      int c = (r - 1) * x + x;
      int d = (cc - 1) * x + x;
      if (get2(a, b, c, d) != 0 && get2(a, b, c, d) != x * x) return false;
    }
  }
  return true;
}
int32_t main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= n / 4; ++j) {
      char ch;
      cin >> ch;
      if (ch >= '0' && ch <= '9')
        mat[i][j] = ch - '0';
      else
        mat[i][j] = ch - 'A' + 10;
    }
  }
  pre();
  int ans = 0;
  for (int i = 1; i * i <= n; i++) {
    if (n % i == 0) {
      if (check(i)) ans = max(ans, i);
      if (i * i != n)
        if (check(n / i)) ans = max(ans, n / i);
    }
  }
  cout << ans;
  return 0;
}
