#include <bits/stdc++.h>
using namespace std;
int dp[5201][5201];
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n / 4; j++) {
      char t;
      cin >> t;
      if (t >= 'A')
        t -= ('A' - 10);
      else
        t -= '0';
      int tt = t;
      for (int k = 3; k >= 0; k--) {
        dp[i][j * 4 - 3 + k] = tt % 2;
        tt /= 2;
      }
    }
  }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      dp[i][j] = dp[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
  vector<int> v;
  for (int i = 2; i * i <= n; i++)
    if (n % i == 0) {
      v.push_back(i);
      if (n / i != i) v.push_back(n / i);
    }
  v.push_back(n);
  sort(v.begin(), v.end());
  int ans = 1;
  bool ch = 1;
  for (int i = v.size() - 1; i >= 0; i--) {
    int t = v[i];
    ch = 1;
    for (int j = t; j <= n && ch; j += t) {
      for (int k = t; k <= n && ch; k += t) {
        int no = dp[j][k] - dp[j - t][k] - dp[j][k - t] + dp[j - t][k - t];
        if (no != 0 && no != t * t) ch = 0;
      }
    }
    if (ch) {
      ans = t;
      break;
    }
  }
  cout << ans;
  return 0;
}
