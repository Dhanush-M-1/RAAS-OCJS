#include <bits/stdc++.h>
using namespace std;
int abso(int a) { return a > 0 ? a : (-a); }
int cdiv(int a, int b) { return a / b + ((a % b) > 0); }
int mul(int a, int b) {
  int res = 0;
  while (b) {
    if (b & 1) res = (res + a) % (int)(1e9 + 7);
    a = (a + a) % (int)(1e9 + 7);
    b = b / 2;
  }
  return res;
}
int bexp(int a, int b) {
  int res = 1;
  while (b) {
    if (b & 1) res = mul(res, a);
    a = mul(a, a);
    b = b / 2;
  }
  return res;
}
int inv(int a) { return bexp(a, (int)(1e9 + 7) - 2); }
int n;
const int N = 100050;
int dp[N][2][2];
int x[N], h[N];
int solve(int idx, int left, int right) {
  if (idx >= n + 1) return 0;
  int& ans = dp[idx][left][right];
  if (ans != -1) return ans;
  ans = solve(idx + 1, 0, 0);
  if ((left == 0 && right == 0) || left == 1) {
    if (((x[idx] - h[idx]) > x[idx - 1]) || idx == 1)
      ans = max(ans, solve(idx + 1, 1, 0) + 1);
    if (((x[idx] + h[idx]) < x[idx + 1]) || idx == n)
      ans = max(ans, solve(idx + 1, 0, 1) + 1);
  } else if (right == 1) {
    if (((x[idx] + h[idx]) < x[idx + 1]) || idx == n)
      ans = max(ans, solve(idx + 1, 0, 1) + 1);
    if (((x[idx] - h[idx]) > (x[idx - 1] + h[idx - 1])))
      ans = max(ans, solve(idx + 1, 1, 0) + 1);
  }
  return ans;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  memset(dp, -1, sizeof(dp));
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> x[i] >> h[i];
  cout << solve(1, 0, 0);
}
