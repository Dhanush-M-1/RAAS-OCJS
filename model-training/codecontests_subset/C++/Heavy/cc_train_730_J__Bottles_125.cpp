#include <bits/stdc++.h>
using namespace std;
template <typename T>
T getint() {
  T x = 0, p = 1;
  char ch;
  do {
    ch = getchar();
  } while (ch <= ' ');
  if (ch == '-') p = -1, ch = getchar();
  while (ch >= '0' && ch <= '9') x = x * 10 + ch - '0', ch = getchar();
  return x * p;
}
template <typename T1, typename T2>
bool umin(T1 &x, const T2 &y) {
  if (x > y) return x = y, true;
  return false;
}
template <typename T1, typename T2>
bool umax(T1 &x, const T2 &y) {
  if (x < y) return x = y, true;
  return false;
}
const int maxn = 1e6 + 10;
const int inf = (int)1e9 + 5;
const int mod = (int)1e9 + 7;
const long long llinf = (long long)1e18 + 5;
const long double pi = acos(-1.0);
int dp[2][101][101 * 101];
int main() {
  int n;
  cin >> n;
  vector<int> a(n), b(n);
  int sum = 0;
  for (int i = (0); i < (n); i++) cin >> a[i], sum += a[i];
  vector<int> c(n);
  for (int i = (0); i < (n); i++) cin >> b[i], c[i] = b[i];
  sort((c).begin(), (c).end());
  reverse((c).begin(), (c).end());
  int x = sum;
  int k = 0;
  for (int i = (0); i < (c.size()); i++) {
    x -= c[i];
    k++;
    if (x <= 0) break;
  }
  for (int i = (0); i < (2); i++)
    for (int j = (0); j < (101); j++)
      for (int k = (0); k < (101 * 101); k++) dp[i][j][k] = -inf;
  dp[0][0][0] = 0;
  for (int i = (0); i < (n); i++) {
    for (int j = (0); j < (n + 1); j++) {
      for (int sum = (0); sum < (101 * 101); sum++) {
        if (sum >= b[i] && j > 0)
          umax(dp[1][j][sum], dp[0][j - 1][sum - b[i]] + a[i]);
        umax(dp[1][j][sum], dp[0][j][sum]);
      }
    }
    for (int j = (0); j < (n + 1); j++)
      for (int sum = (0); sum < (101 * 101); sum++) {
        dp[0][j][sum] = dp[1][j][sum];
        dp[1][j][sum] = -inf;
      }
  }
  int res = -inf;
  for (int j = (sum); j < (101 * 101); j++) {
    umax(res, dp[0][k][j]);
  }
  cout << k << ' ' << sum - res << endl;
  return 0;
}
