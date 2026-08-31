#include <bits/stdc++.h>
using namespace std;
int n;
int x[100010];
int h[100010];
int memo[100010][3];
int dp(int prev, int last, int pos) {
  if (memo[pos][prev] != -1) {
    return memo[pos][prev];
  }
  int s1, s2, s3;
  s1 = s2 = s3 = 0;
  if (x[pos] + h[pos] < x[pos + 1]) {
    s1 = 1 + dp(1, x[pos] + h[pos], pos + 1);
  }
  if (x[pos] - h[pos] > last) {
    s2 = 1 + dp(0, x[pos], pos + 1);
  }
  s3 = dp(0, x[pos], pos + 1);
  return memo[pos][prev] = max(s1, max(s2, s3));
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  memset(memo, -1, sizeof(memo));
  memo[n - 1][0] = 1;
  memo[n - 1][1] = 1;
  cout << dp(0, INT_MIN, 0);
  return 0;
}
